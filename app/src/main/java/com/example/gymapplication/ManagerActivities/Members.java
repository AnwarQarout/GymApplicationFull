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

public class Members extends AppCompatActivity {
    private static  final String BASE_URL = "http://10.0.2.2:80/gymproject/manager/GetAllMembers.php";
    ArrayList<member> member  = new ArrayList<>() ;
    RecyclerView recyclerView  ;
    public com.example.gymapplication.ManagerActivities.memberadpter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recycle);
        recyclerView = findViewById(R.id.all_recycler) ;

        getMembers() ;
        recyclerView.setLayoutManager(new LinearLayoutManager(Members.this));
        adapter = new com.example.gymapplication.ManagerActivities.memberadpter(this,member) ;
        recyclerView.setAdapter(adapter);


    }
    private void getMembers() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response) ;
                    for (int i = 0; i <array.length(); i++) {
                        JSONObject object = array.getJSONObject(i) ;
                        int id = object.getInt("id");
                        int employee_id = object.getInt("employee_id");
                        String user_name = object.getString("user_name");
                        String password = object.getString("password");
                        String name = object.getString("name");
                        int phone = object.getInt("phone");
                        String image = object.getString("image");
                        double height = object.getDouble("height");
                        double weight = object.getDouble("weight");



                        member member = new member(id,employee_id,user_name,password,name,phone,image,height,weight) ;

                        adapter.add(member);
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Members.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        Volley.newRequestQueue(Members.this).add(stringRequest)  ;
    }
}