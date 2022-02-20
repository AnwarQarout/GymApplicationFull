package com.example.gymapplication.EmployeeActivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.gymapplication.R;

import java.util.HashMap;

public class NutritionDetails extends AppCompatActivity {
    TextView name, type, membership;
    ImageView imageView;
    Button delete, edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_details);
        name = findViewById(R.id.nutritionname);
        type = findViewById(R.id.nutritionType);
        membership = findViewById(R.id.nutritionMembership);
        imageView = findViewById(R.id.nutimageView);
        delete = findViewById(R.id.deletenut);
        edit = findViewById(R.id.editnut);

        name.setText(getIntent().getStringExtra("name"));
        type.setText(getIntent().getStringExtra("type"));
        membership.setText("Membership: "+getIntent().getStringExtra("membership"));
        Glide.with(this).load(getIntent().getStringExtra("image")).centerCrop().placeholder(R.drawable.ic_launcher_background).into(imageView);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = getIntent().getStringExtra("id") ;
                delete(id);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NutritionDetails.this , EditNutrition.class) ;
                intent.putExtra("id",getIntent().getStringExtra("id")) ;
                intent.putExtra("employee_id",getIntent().getStringExtra("employee_id")) ;
                intent.putExtra("name",getIntent().getStringExtra("name")) ;
                intent.putExtra("type",getIntent().getStringExtra("type")) ;
                intent.putExtra("membership",getIntent().getStringExtra("membership")) ;
                intent.putExtra("image",getIntent().getStringExtra("image")) ;
                startActivity(intent);
            }
        });


    }


    private  void delete( String id){
        String url ="http://10.0.2.2:80/gymproject/employee/deleteNutrition.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response_del", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_del",""+error);
            }

        }){
            protected HashMap<String,String> getParams() throws AuthFailureError {
                HashMap<String,String> map = new HashMap<>();
                map.put("id",id);
                return map;
            }
        };
        requestQueue.add(stringRequest);
        Intent intent = new Intent(this, AllNutritions.class) ;
        startActivity(intent);


    }
}