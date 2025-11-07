package com.example.hf3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.hf3.R;
import com.google.android.gms.analytics.ecommerce.Product;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private EditText editName, editPrice, editQuantity;
    private List<Product> productList = new ArrayList<>();

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editName = findViewById(R.id.text1);
        editPrice = findViewById(R.id.text2);
        editQuantity = findViewById(R.id.text3);

        Button btnAdd = findViewById(R.id.add);
        Button btnCancel = findViewById(R.id.cancel);

        // Add Product
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();
                String priceStr = editPrice.getText().toString().trim();
                String quantityStr = editQuantity.getText().toString().trim();

                if (name.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double price = Double.parseDouble(priceStr);
                int quantity = Integer.parseInt(quantityStr);

                Product product = new Product(name, price, quantity);
                productList.add(product);

                Toast.makeText(SecondActivity.this, "Product added successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        // Cancel (clear inputs)
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editPrice.setText("");
                editQuantity.setText("");
                Toast.makeText(SecondActivity.this, "Fields cleared!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
