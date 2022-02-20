package com.example.gymapplication.EmployeeActivities.Model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.gymapplication.R;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.gymapplication.EmployeeActivities.workoutsDetails;

import java.util.List;


public class workoutAdabter extends RecyclerView.Adapter<workoutAdabter.ViewHolder> {
    private Context context;
    private List<Workout> items;

    public workoutAdabter(Context context, List<Workout> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_workout_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Workout workout = items.get(position);

        CardView cardView = holder.cardView;
        TextView name = cardView.findViewById(R.id.workoutname);
        name.setText(workout.workout_name );
        ImageView video = cardView.findViewById(R.id.workoutImagecard) ;
        Glide.with(holder.cardView).load(workout.getVideo()).placeholder(R.drawable.ic_launcher_background).into(video);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, workoutsDetails.class) ;
                intent.putExtra("id",String.valueOf(workout.getId()))  ;
                intent.putExtra("employee_id",String.valueOf(workout.getEmployee_id())) ;
                intent.putExtra("name",workout.getWorkout_name())  ;
                intent.putExtra("steps",workout.getSteps()) ;
                intent.putExtra("video",workout.getVideo()) ;
                context.startActivity(intent);
            }
        });
    }

    public void add(Workout workout) {
        this.items.add(workout);
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
