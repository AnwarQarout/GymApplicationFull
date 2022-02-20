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

public class employeeadapter
        extends RecyclerView.Adapter<employeeadapter.ViewHolder>{
    private Context context;
    private List<employee> items;


    public employeeadapter(Context context, List<employee> items){
        this.context = context;
        this.items = items;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.employeecaycle,parent,false);

        return new ViewHolder(v);
    }
    public void add(employee employee) {
        this.items.add(employee);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final employee employee = items.get(position);
        CardView cardView = holder.cardView;

        TextView txt = (TextView)cardView.findViewById(R.id.empName);
        txt.setText(employee.getName());
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){

                    Intent intent=new Intent(context, com.example.gymapplication.ManagerActivities.details.class);

                intent.putExtra("id","Id: "+String.valueOf(employee.getId()));
                intent.putExtra("manger_id","Manager Id: "+String.valueOf(employee.getMangerid()));
                intent.putExtra("user_name","User Name: "+employee.getUsername());
                intent.putExtra("password","Password: "+employee.getPassword());
                intent.putExtra("name","Name: "+employee.getName());
                intent.putExtra("phone","Phone: "+String.valueOf(employee.getPhone()));
                intent.putExtra("salary","Salary: "+String.valueOf(employee.getSalry()));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}

