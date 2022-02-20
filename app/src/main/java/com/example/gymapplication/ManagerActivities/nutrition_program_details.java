package com.example.gymapplication.ManagerActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.gymapplication.R;

public class nutrition_program_details extends AppCompatActivity {
    TextView id, name, employee_id, type, membership ;
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_program_details);
        id =findViewById(R.id.txtId) ;
        name =findViewById(R.id.txtName) ;
        employee_id =findViewById(R.id.txtEmployeeid) ;
        type =findViewById(R.id.txtType) ;
        membership =findViewById(R.id.txtMembership) ;
        imageView=findViewById(R.id.nutimageview);

        Intent intent = getIntent() ;
        String idd =intent.getStringExtra("id") ;
        String employee_idd =intent.getStringExtra("employeeid") ;
        String namee =intent.getStringExtra("name") ;
        String typee =intent.getStringExtra("type") ;
        String membershipp =intent.getStringExtra("membership") ;
        String imagee =intent.getStringExtra("image")  ;
        Glide.with(this)
                .load(imagee)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView) ;

        id.setText(idd);
        employee_id.setText(employee_idd);
        name.setText(namee);
        type.setText(typee);
        membership.setText(membershipp);


    }
}