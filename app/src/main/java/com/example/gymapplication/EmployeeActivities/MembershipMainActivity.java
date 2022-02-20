package com.example.gymapplication.EmployeeActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymapplication.R;

public class MembershipMainActivity extends AppCompatActivity {
   public static   String selectedMembership ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membershipmainactivity);
        selectedMembership= getIntent().getStringExtra("selectedMembership") ;
        System.out.println("selectedMembership*********************"+selectedMembership);
    }
    public void workk(View view) {
        Intent intent = new Intent(this,workouts.class) ;
        startActivity(intent);
    }

    public void Nutrition(View view) {
        Intent intent = new Intent(this , AllNutritions.class) ;
        startActivity(intent);
    }
}