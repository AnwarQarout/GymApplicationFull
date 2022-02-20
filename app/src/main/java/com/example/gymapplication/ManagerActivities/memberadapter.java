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

class memberadpter extends RecyclerView.Adapter<memberadpter.ViewHolder> {
    private Context context;
    private List<member> items;


    public memberadpter(Context context, List<member> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v1 = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.member_card,
                parent,
                false);

        return new ViewHolder(v1);
    }
    public void add(member member) {
        this.items.add(member);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final member memberdetail = items.get(position);
        CardView cardView = holder.cardView;
        TextView name =  cardView.findViewById(R.id.memberName);
        name.setText("Member Name: "+memberdetail.getName());

        cardView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,memberDetails.class) ;
                intent.putExtra("id","Id: "+String.valueOf(memberdetail.getId())) ;
                intent.putExtra("name","Name: "+memberdetail.getName()) ;
                intent.putExtra("employeeid","Emplyee Id: "+String.valueOf(memberdetail.getEmployeeid()));
                intent.putExtra("user_name","User Name: "+memberdetail.getUsername()) ;
                intent.putExtra("password","Password: "+memberdetail.getPassword()) ;
                intent.putExtra("image",memberdetail.getImage()) ;
                intent.putExtra("phone","Phone: "+String.valueOf(memberdetail.getPhone()));
                intent.putExtra("height","Height: "+String.valueOf(memberdetail.getHeight())) ;
                intent.putExtra("weight","Weight: "+String.valueOf(memberdetail.getWeight()));
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