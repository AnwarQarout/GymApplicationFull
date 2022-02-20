package com.example.gymapplication.ManagerActivities;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymapplication.R;

public class MangerMainActivity extends AppCompatActivity {
    RecyclerView recycler;
    public static String manager_id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        manager_id = getIntent().getStringExtra("id") ;
        System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"+manager_id);

    }
    public void manageemployee(View view) {
        Intent intent=new Intent(this,Empolyee.class);
        startActivity(intent);

    }
    public void memberdetails(View view) {
        Intent intent=new Intent(this, Members.class);
        startActivity(intent);
    }
    public void nutrition_program(View view) {
        Intent intent=new Intent(this, nutrition_programs.class);
        startActivity(intent);
    }
    public void workouts(View view) {
        Intent intent=new Intent(this, workoutsfirst.class);
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent=new Intent(this, com.example.gymapplication.UserActivities.loginActivity.class);
        startActivity(intent);
    }
}