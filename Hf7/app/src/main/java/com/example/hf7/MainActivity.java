package com.example.hf7;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AnimalAdapter adapter;
    List<Animal> animalList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        animalList = new ArrayList<>();
        animalList.add(new Animal("Octopus", "8 tentacled monster", R.drawable.octopus));
        animalList.add(new Animal("Pig", "Delicious in rolls", R.drawable.disznyo));
        animalList.add(new Animal("Sheep", "Great for jumpers", R.drawable.sheep));
        animalList.add(new Animal("Rabbit", "Nice in a stew", R.drawable.rabbit));
        animalList.add(new Animal("Snake", "Great for shoes", R.drawable.octopus2));
        animalList.add(new Animal("Spider", "Scary", R.drawable.dog));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AnimalAdapter(this, animalList);
        recyclerView.setAdapter(adapter);
    }
}
