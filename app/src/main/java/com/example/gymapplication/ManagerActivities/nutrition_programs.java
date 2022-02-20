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

public class nutrition_programs extends AppCompatActivity {
    private static  final String BASE_URL = "http://10.0.2.2:80/gymproject/manager/GetNutritionProgram.php";
    ArrayList<nutrition_programinf> nutrition_programinf  = new ArrayList<>() ;
    RecyclerView recyclerView  ;
    public nutrition_programadapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recycle);
        recyclerView = findViewById(R.id.all_recycler) ;

        getnutrition_program() ;
        recyclerView.setLayoutManager(new LinearLayoutManager(nutrition_programs.this));
        adapter = new nutrition_programadapter(this,nutrition_programinf) ;
        recyclerView.setAdapter(adapter);


    }
    private void getnutrition_program() {
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
                        String type = object.getString("type");
                        String membership = object.getString("membership");
                        String image = object.getString("image");




                        nutrition_programinf nutrition_programinf = new nutrition_programinf(id,employee_id,name,type,membership,image) ;

                        adapter.add(nutrition_programinf);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(nutrition_programs.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        Volley.newRequestQueue(nutrition_programs.this).add(stringRequest)  ;
    }
}