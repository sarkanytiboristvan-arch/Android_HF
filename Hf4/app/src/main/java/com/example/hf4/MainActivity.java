package com.example.hf4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Valuták listája különböző országokkal
        ArrayList<CurrencyItem> currencies = new ArrayList<>();
        currencies.add(new CurrencyItem("EUR", "Euro", "Európai Unió", R.drawable.flag_of_europe, 4.95, 5.05));
        currencies.add(new CurrencyItem("USD", "Dollár", "USA", R.drawable.usd, 4.50, 4.60));
        currencies.add(new CurrencyItem("GBP", "Font", "Nagy-Britannia", R.drawable.gbp, 5.80, 5.95));
        currencies.add(new CurrencyItem("CHF", "Frank", "Svájc", R.drawable.cfh, 5.20, 5.35));

        // ListView beállítása
        ListView listView = findViewById(R.id.currencyListView);
        CurrencyAdapter adapter = new CurrencyAdapter(this, currencies);
        listView.setAdapter(adapter);

        // Kattintás kezelése
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CurrencyItem currency = currencies.get(position);
                String message = currency.getName() + "\nVételi ár: " + currency.getBuyRate() + " RON";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}