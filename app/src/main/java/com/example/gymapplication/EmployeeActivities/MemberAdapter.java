package com.example.gymapplication.EmployeeActivities;

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

public class MemberAdapter
        extends RecyclerView.Adapter<MemberAdapter.ViewHolder>{
    private Context mCtx;
    private List<Member> memberList;


    public MemberAdapter(Context mCtx, List<Member> memberList){
        this.mCtx = mCtx;
        this.memberList = memberList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_member,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Member member = memberList.get(position);
        CardView cardView = holder.cardView;

        TextView txt = (TextView)cardView.findViewById(R.id.textName);
        txt.setText(member.getName());
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent  intent = new Intent(mCtx,MemberDetails.class);

                intent.putExtra("id",String.valueOf(member.getId()));
                intent.putExtra("employee_id",String.valueOf(member.getEmployee_id()));
                intent.putExtra("user_name",member.getUser_name());
                intent.putExtra("password",member.getPassword());
                intent.putExtra("name",member.getName());
                intent.putExtra("phone",String.valueOf(member.getPhone()));
                intent.putExtra("height",String.valueOf(member.getHeight()) );
                intent.putExtra("weight", String.valueOf(member.getWeight()));
                mCtx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}
