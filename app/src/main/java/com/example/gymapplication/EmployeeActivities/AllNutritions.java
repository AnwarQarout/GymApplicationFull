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
import com.example.gymapplication.EmployeeActivities.Model.NutirtionAdabter;
import com.example.gymapplication.EmployeeActivities.Model.Nutrition;
import com.example.gymapplication.R;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AllNutritions extends AppCompatActivity {
    public String BASE_URL = "http://10.0.2.2:80/gymproject/employee/getNutrition.php?selectedMembership=";
    ArrayList<Nutrition> nutritions = new ArrayList<>();
    RecyclerView recyclerView;
    public NutirtionAdabter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_nutritions);
        BASE_URL = BASE_URL + MembershipMainActivity.selectedMembership;
        recyclerView = findViewById(R.id.nutritionRecycle);
        getNutrition();
        recyclerView.setLayoutManager(new LinearLayoutManager(AllNutritions.this));
        adapter = new NutirtionAdabter(this, nutritions);
        recyclerView.setAdapter(adapter);
    }


    private void getNutrition() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                int id = object.getInt("id");
                                int e_id = object.getInt("employee_id");
                                String name = object.getString("name");
                                String type = object.getString("type");
                                String membership = object.getString("membership");
                                String image = object.getString("image");
                                Nutrition nutrition = new Nutrition(id, e_id, name, type, membership, image);
                                adapter.add(nutrition);
                            }


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(AllNutritions.this, error.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
                Volley.newRequestQueue(AllNutritions.this).add(stringRequest);
            }
        });

    }

    public void addNutrition(View view) {
        Intent intent = new Intent(this, AddNutrition.class);
        startActivity(intent);
    }

}