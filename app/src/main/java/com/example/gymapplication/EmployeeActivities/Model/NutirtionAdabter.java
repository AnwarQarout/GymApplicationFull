package com.example.gymapplication.EmployeeActivities.Model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gymapplication.EmployeeActivities.NutritionDetails;
import com.example.gymapplication.R;

import java.util.List;


public class NutirtionAdabter extends RecyclerView.Adapter<NutirtionAdabter.ViewHolder> {
    private Context context;
    private List<Nutrition> items;

    public NutirtionAdabter(Context context, List<Nutrition> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.nutrition_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Nutrition nutrition = items.get(position);
        CardView cardView = holder.cardView;
        ImageButton imageView =cardView.findViewById(R.id.nutImage) ;
        Glide.with(holder.cardView).load(nutrition.getImage()).centerCrop().placeholder(R.drawable.ic_launcher_background).into(imageView);
        TextView type = cardView.findViewById(R.id.nuttype) ;
        type.setText(nutrition.getType());
        TextView name = cardView.findViewById(R.id.nutname) ;
        name.setText(nutrition.getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NutritionDetails.class);
                intent.putExtra("id",String.valueOf(nutrition.getId())) ;
                intent.putExtra("employee_id",nutrition.getEmployee_id()) ;
                intent.putExtra("name",nutrition.getName()) ;
                intent.putExtra("image",nutrition.getImage()) ;
                intent.putExtra("type",nutrition.getType()) ;
                intent.putExtra("membership",nutrition.getMembership()) ;
                context.startActivity(intent);
            }
        });

    }

    public void add(Nutrition nutrition) {
        this.items.add(nutrition);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;

        }


    }
}
