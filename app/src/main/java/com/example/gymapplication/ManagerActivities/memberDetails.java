package com.example.gymapplication.ManagerActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymapplication.R;

public class memberDetails extends AppCompatActivity {

    TextView id, name, employeeid,username, password, phone, image ,height,weight ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details);
        id =findViewById(R.id.txtId) ;
        name =findViewById(R.id.txtName) ;
        username =findViewById(R.id.txtUsername) ;
        password =findViewById(R.id.txtPassword) ;
        employeeid=findViewById(R.id.txtEmployeeid);
        phone =findViewById(R.id.txtPhone) ;
        height =findViewById(R.id.txtHeight);
        weight=findViewById(R.id.txtWeight);
        Intent intent = getIntent() ;
        String idd =intent.getStringExtra("id") ;
        String namee =intent.getStringExtra("name") ;
        String usernamee =intent.getStringExtra("user_name") ;
        String passwordd =intent.getStringExtra("password") ;
        String employeeidd =intent.getStringExtra("employeeid") ;
        String phonee =intent.getStringExtra("phone") ;
        String heightt =intent.getStringExtra("height");
        String weightt = intent.getStringExtra("weight");
        id.setText(idd);
        name.setText(namee);
        username.setText(usernamee);
        password.setText(passwordd);
        employeeid.setText(employeeidd);
        phone.setText(phonee);
        height.setText(heightt);
        weight.setText(weightt);

    }

}