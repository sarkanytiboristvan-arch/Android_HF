package com.example.hf5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ListItem> items;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Mintaadatok
        items = new ArrayList<>();
        items.add(new ListItem("Alma", Color.BLACK));
        items.add(new ListItem("Körte", Color.BLACK));
        items.add(new ListItem("Barack", Color.BLACK));
        items.add(new ListItem("Szilva", Color.BLACK));
        items.add(new ListItem("Cseresznye", Color.BLACK));

        adapter = new CustomAdapter(this, items);
        listView.setAdapter(adapter);

        // Context menü regisztrálása
        registerForContextMenu(listView);
    }

    // Context menü létrehozása (Piros, Zöld, Sárga)
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 1, 0, "Piros");
        menu.add(0, 2, 0, "Zöld");
        menu.add(0, 3, 0, "Sárga");
    }

    // Context menü választás kezelése
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        ListItem selectedItem = items.get(info.position);

        if (item.getItemId() == 1) selectedItem.setColor(Color.RED);
        else if (item.getItemId() == 2) selectedItem.setColor(Color.GREEN);
        else if (item.getItemId() == 3) selectedItem.setColor(Color.YELLOW);

        adapter.notifyDataSetChanged();
        return true;
    }

    // Option menü létrehozása (Rendez, Töröl ikonokkal)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 4, 0, "Rendez")
                .setIcon(android.R.drawable.ic_menu_sort_alphabetically)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add(0, 5, 0, "Töröl")
                .setIcon(android.R.drawable.ic_menu_delete)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        return true;
    }

    // Option menü választás kezelése
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 4) {
            // Rendezés ABC szerint
            Collections.sort(items, new Comparator<ListItem>() {
                @Override
                public int compare(ListItem o1, ListItem o2) {
                    return o1.getText().compareToIgnoreCase(o2.getText());
                }
            });
            adapter.notifyDataSetChanged();
        } else if (item.getItemId() == 5) {
            // Összes törlése
            items.clear();
            adapter.notifyDataSetChanged();
        }
        return true;
    }
}