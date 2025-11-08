package com.example.hf5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ListItem> {

    private Context context;
    private ArrayList<ListItem> items;

    // Konstruktor
    public CustomAdapter(Context context, ArrayList<ListItem> items) {
        super(context, android.R.layout.simple_list_item_1, items);
        this.context = context;
        this.items = items;
    }

    // Ez a metódus rendereli minden egyes lista elemet
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Egyszerű layout használata (beépített Android layout)
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    android.R.layout.simple_list_item_1, parent, false);
        }

        // TextView megkeresése
        TextView textView = convertView.findViewById(android.R.id.text1);

        // Aktuális elem lekérése
        ListItem item = items.get(position);

        // Szöveg és szín beállítása
        textView.setText(item.getText());
        textView.setTextColor(item.getColor());

        return convertView;
    }
}
