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

public class nutrition_programadapter extends RecyclerView.Adapter<nutrition_programadapter.ViewHolder> {
    private Context context;
    private List<nutrition_programinf> items;

    public nutrition_programadapter(Context context, List<nutrition_programinf> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_nutrition_programs,
                parent,
                false);

        return new ViewHolder(v);
    }
    public void add(nutrition_programinf nutrition_programinf) {
        this.items.add(nutrition_programinf);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final nutrition_programinf nutrition_programinff = items.get(position);
        CardView cardView = holder.cardView;
        TextView name =  cardView.findViewById(R.id.programs);
        name.setText("Nutrition Type: "+nutrition_programinff.getName());

        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,nutrition_program_details.class) ;
                intent.putExtra("id","Id: "+String.valueOf(nutrition_programinff.getId()) ) ;
                intent.putExtra("employeeid","Emplyee Id: "+String.valueOf(nutrition_programinff.getEmployee_id())) ;
                intent.putExtra("name","Name: "+nutrition_programinff.getName()) ;
                intent.putExtra("membership","Member Ship: "+nutrition_programinff.getMembership()) ;
                intent.putExtra("type","Type: "+(nutrition_programinff.getType())) ;
                intent.putExtra("image",(nutrition_programinff.getImage()));
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
