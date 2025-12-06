package com.example.hf6;

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

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Adatok feltöltése a képernyőkép alapján
        List<TodoItem> todoList = new ArrayList<>();
        todoList.add(new TodoItem("Groceries", "Buy vegetables and fruits", "Pending", "2022.11.10"));
        todoList.add(new TodoItem("Workout", "Exercise at the gym", "Completed", "2022.11.07"));
        todoList.add(new TodoItem("Study", "Read chapter 3", "Completed", "2022.11.08"));
        todoList.add(new TodoItem("Meeting", "Discuss project updates", "Pending", "2022.11.09"));
        todoList.add(new TodoItem("Cleaning", "Clean the living room", "Pending", "2022.11.06"));
        todoList.add(new TodoItem("Coding", "Work on the website", "Completed", "2022.11.11"));
        todoList.add(new TodoItem("Appointment", "Visit the dentist", "Completed", "2022.11.12"));

        TodoAdapter adapter = new TodoAdapter(todoList);
        recyclerView.setAdapter(adapter);
    }
}
