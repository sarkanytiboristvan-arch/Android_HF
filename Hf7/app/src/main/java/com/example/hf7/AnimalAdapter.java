package com.example.hf7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>{
    private Context context;
    private List<Animal> animalList;

    public AnimalAdapter(Context context, List<Animal> animalList) {
        this.context = context;
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_card, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal currentAnimal = animalList.get(position);

        holder.txtName.setText(currentAnimal.getName());
        holder.txtDescription.setText(currentAnimal.getDescription());
        holder.imgAnimal.setImageResource(currentAnimal.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, "Kiválasztva: " + currentAnimal.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtDescription;
        ImageView imgAnimal;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtBusName);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            imgAnimal = itemView.findViewById(R.id.imgAnimal);
        }
    }
}
