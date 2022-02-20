package com.example.gymapplication.ManagerActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.gymapplication.R;

public class workout_details extends AppCompatActivity {

    TextView id, name, employee_id, steps ;
    ImageView video ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_details);

        id =findViewById(R.id.txtId) ;
        name =findViewById(R.id.txtName) ;
        employee_id =findViewById(R.id.txtEmployeeid) ;
        steps =findViewById(R.id.txtSteps) ;
        video =findViewById(R.id.viVideo) ;



        Intent intent = getIntent() ;
        String idd =intent.getStringExtra("id") ;
        String namee =intent.getStringExtra("name") ;
        String employee_idd =intent.getStringExtra("employee_id") ;
        String stepss =intent.getStringExtra("steps") ;
        String videoo =intent.getStringExtra("video") ;
        Glide.with(this)
                .load(videoo)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(video) ;
        id.setText(idd);
        name.setText(namee);
        employee_id.setText(employee_idd);
        steps.setText(stepss);


    }
}