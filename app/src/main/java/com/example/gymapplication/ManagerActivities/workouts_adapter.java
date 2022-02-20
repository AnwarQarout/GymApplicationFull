package com.example.gymapplication.ManagerActivities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapplication.R;

import java.util.List;

public class workouts_adapter extends RecyclerView.Adapter<workouts_adapter.ViewHolder>  {
    private Context context;
    private List<workoutinf> items;

    public workouts_adapter(Context context, List<workoutinf> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_workoutsfirst,
                parent,
                false);

        return new ViewHolder(v);
    }
    public void add(workoutinf workoutinf) {
        this.items.add(workoutinf);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final workoutinf workoutinff = items.get(position);
        CardView cardView = holder.cardView;
        TextView name =  cardView.findViewById(R.id.workouts);
        name.setText("Workout Type: "+workoutinff.getName());

        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, com.example.gymapplication.ManagerActivities.workout_details.class) ;
                intent.putExtra("id","Id: "+String.valueOf(workoutinff.getId()) ) ;
                intent.putExtra("employee_id","Employee Id: "+String.valueOf(workoutinff.getEmployee_id())) ;
                intent.putExtra("name","Name: "+workoutinff.getName()) ;
                intent.putExtra("steps","Steps: "+workoutinff.getSteps()) ;
                intent.putExtra("video",(workoutinff.getVideo())) ;
                context.startActivity(intent);
            }
        });
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
