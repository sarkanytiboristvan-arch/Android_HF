package com.example.hf1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Szam1;
    private EditText Szam2;
    private TextView Eredmeny;
    private Button Osszeadas, Kivonas, Szorzas, Osztas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // XML elemek összekötése
        Szam1 = findViewById(R.id.number1);
        Szam2 = findViewById(R.id.number2);
        Eredmeny = findViewById(R.id.eredmeny);
        Osszeadas = findViewById(R.id.osszeadas);
        Kivonas = findViewById(R.id.kivonas);
        Szorzas = findViewById(R.id.szorzas);
        Osztas = findViewById(R.id.osztas);

        // Egyszerűbb listener hozzárendelések
        Osszeadas.setOnClickListener(v -> muvelet("+"));
        Kivonas.setOnClickListener(v -> muvelet("-"));
        Szorzas.setOnClickListener(v -> muvelet("*"));
        Osztas.setOnClickListener(v -> muvelet("/"));
    }

    // A művelet logikája egy helyen
    private void muvelet(String tipus) {
        try {
            double num1 = Double.parseDouble(Szam1.getText().toString());
            double num2 = Double.parseDouble(Szam2.getText().toString());
            double result = 0;

            switch (tipus) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/":
                    if (num2 == 0) throw new ArithmeticException("Nullával nem lehet osztani!");
                    result = num1 / num2;
                    break;
            }

            Eredmeny.setText("Eredmény: " + result);

        } catch (NumberFormatException e) {
            Eredmeny.setText("Hiba: Érvénytelen számbevitel!");
        } catch (ArithmeticException e) {
            Eredmeny.setText("Hiba: " + e.getMessage());
        } catch (Exception e) {
            Eredmeny.setText("Ismeretlen hiba történt!");
        }
    }
}
