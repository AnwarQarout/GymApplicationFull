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

public class workoutsDetails extends AppCompatActivity {
      TextView  na , st, vi ;
    ImageView imageView ;
    Button delete , edit ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts_details);
        delete  = findViewById(R.id.delete) ;
        edit  = findViewById(R.id.editworkout)  ;
        imageView = findViewById(R.id.imageView);
        edit =findViewById(R.id.editworkout) ;

        na =findViewById(R.id.workname) ;
        st=findViewById(R.id.workoutsSteps) ;
        Intent intent = getIntent() ;

        String employee_id= intent.getStringExtra("employee_id" );
        String name= intent.getStringExtra("name" );
        String steps= intent.getStringExtra("steps" );
        String video= intent.getStringExtra("video" );

        Glide.with(this).load(video).centerCrop().placeholder(R.drawable.ic_launcher_background).into(imageView);
        na.setText(name);
        st.setText(steps);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id= getIntent().getStringExtra("id" );
              deleteWorkout(id);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(workoutsDetails.this , EditWorkout.class) ;
                intent1.putExtra("id", getIntent().getStringExtra("id")) ;
                intent1.putExtra("employee_id",employee_id) ;
                intent1.putExtra("name", name) ;
                intent1.putExtra("steps",steps) ;
                intent1.putExtra("video", video) ;
                startActivity(intent1);
            }
        });

    }

    private  void deleteWorkout( String id){
        String url ="http://10.0.2.2:80/gymproject/employee/deletWorkouts.php";
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
                map.put("m_id","3");
                return map;
            }
        };
        requestQueue.add(stringRequest);
      Intent intent = new Intent(this,workouts.class) ;
      startActivity(intent);
    }



}