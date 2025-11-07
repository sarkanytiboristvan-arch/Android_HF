package com.example.hf3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText Email, Password;
    private Button btnLogin, btnSignUp, btnHome;

    private final String correctEmail = "admin@gmail.com";
    private final String correctPass = "1234";

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

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        btnSignUp = findViewById(R.id.sign);
        btnHome = findViewById(R.id.home);

//        LOGIN GOMB
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String pass = Password.getText().toString();

                if (email.equals(correctEmail) && pass.equals(correctPass)) {
                    Toast.makeText(MainActivity.this, "Login succesful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

       // SIGN UP gomb
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity("Sign Up");
            }
        });

        // HOME gomb
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity("Home");
            }
        });
    }

    // Egy segédfüggvény, ami elindítja a második Activity-t és átadja az adatot
    private void openSecondActivity(String from) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("source", from);
        startActivity(intent);
    }

}
