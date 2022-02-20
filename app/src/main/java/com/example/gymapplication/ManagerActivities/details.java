package com.example.gymapplication.ManagerActivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gymapplication.R;

import java.util.HashMap;

public class details extends AppCompatActivity {
    TextView id, name, username, password, phone,salary ;
    private String iddd =""  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
            id =findViewById(R.id.txtId) ;
            name =findViewById(R.id.txtName) ;
            username =findViewById(R.id.txtUsername) ;
            password =findViewById(R.id.txtPassword) ;
            phone =findViewById(R.id.txtPhone) ;
            salary=findViewById(R.id.txtSalary);
            Intent intent = getIntent() ;
            String idd =intent.getStringExtra("id") ;
            iddd = idd;
            String namee =intent.getStringExtra("name") ;
            String usernamee =intent.getStringExtra("user_name") ;
            String passwordd =intent.getStringExtra("password") ;
            String phonee =intent.getStringExtra("phone") ;
            String salaryy =intent.getStringExtra("salary")  ;
            id.setText(idd);
            name.setText(namee);
            username.setText(usernamee);
            password.setText(passwordd);
            phone.setText(phonee);
            salary.setText(salaryy);

    }


    public void edit(View view){

        Intent intent = new Intent(this, editform.class);
        intent.putExtra("id", iddd);
        startActivity(intent);
    }
}