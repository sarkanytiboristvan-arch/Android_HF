package com.example.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv;

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

        Button btn = findViewById(R.id.button);

        tv = findViewById(R.id.cimke);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(myIntent);
            }
        });

        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tv.append("\n" + tv.getText());
            }
        });

        Log.d("Status: ", "MainActivity:onCreate");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("Status: ", "MainActivity:onRestoreInstanceState");
        outState.putString("cimke", tv.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv.setText(savedInstanceState.getString("cimke"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Status: ", "MainActivity:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Status: ", "MainActivity:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Status: ", "MainActivity:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Status: ", "MainActivity:onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Status: ", "MainActivity:onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Status: ", "MainActivity:onDestroy");
    }
}