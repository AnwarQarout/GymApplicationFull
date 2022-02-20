package com.example.gymapplication.ManagerActivities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gymapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class workoutsfirst extends AppCompatActivity {
    private static  final String BASE_URL = "http://10.0.2.2:80/gymproject/manager/GetAllWorkouts.php";
    ArrayList<workoutinf> workouts  = new ArrayList<>() ;
    RecyclerView recyclerView  ;
    public com.example.gymapplication.ManagerActivities.workouts_adapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recycle);
        recyclerView = findViewById(R.id.all_recycler) ;

        getWorkouts() ;
        recyclerView.setLayoutManager(new LinearLayoutManager(workoutsfirst.this));
        adapter = new com.example.gymapplication.ManagerActivities.workouts_adapter(this,workouts) ;
        recyclerView.setAdapter(adapter);


    }
    private void getWorkouts() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response) ;
                    for (int i = 0; i <array.length(); i++) {
                        JSONObject object = array.getJSONObject(i) ;
                        int id = object.getInt("id");
                        int employee_id = object.getInt("employee_id");
                        String name = object.getString("name");
                        String steps = object.getString("steps");
                        String video = object.getString("video");



                        workoutinf workoutinf = new workoutinf(id,employee_id,name,steps,video) ;

                        adapter.add(workoutinf);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(workoutsfirst.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        Volley.newRequestQueue(workoutsfirst.this).add(stringRequest)  ;
    }

}