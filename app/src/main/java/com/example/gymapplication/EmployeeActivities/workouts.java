package com.example.gymapplication.EmployeeActivities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gymapplication.EmployeeActivities.Model.Workout;
import com.example.gymapplication.EmployeeActivities.Model.workoutAdabter;
import com.example.gymapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class workouts extends AppCompatActivity {
    public   String BASE_URL = "http://10.0.2.2:80/gymproject/employee/getworkouts.php?selectedMembership=";
    ArrayList<Workout> workouts = new ArrayList<>();
    RecyclerView recyclerView;
    public workoutAdabter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        recyclerView = findViewById(R.id.workoutsRecycle);
        BASE_URL = BASE_URL+MembershipMainActivity.selectedMembership;
        getWorkouts();
        recyclerView.setLayoutManager(new LinearLayoutManager(workouts.this));
        adapter = new workoutAdabter(this, workouts);
        recyclerView.setAdapter(adapter);


    }

    private void getWorkouts() {
        Handler handler = new Handler() ;
        handler.post(new Runnable() {
            @Override
            public void run() {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            System.out.println(BASE_URL);
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                int id = object.getInt("id");
                                int e_id = object.getInt("employee_id");
                                String name = object.getString("name");
                                String steps = object.getString("steps");
                                String video = object.getString("video");
                                Workout workout = new Workout(id, e_id, name, steps, video);
                                adapter.add(workout);
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(workouts.this, error.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
                Volley.newRequestQueue(workouts.this).add(stringRequest);
            }
        });
    }


    public void addWorkout(View view) {
        Intent intent = new Intent(this, AddWorkOuts.class);
        startActivity(intent);
    }
}