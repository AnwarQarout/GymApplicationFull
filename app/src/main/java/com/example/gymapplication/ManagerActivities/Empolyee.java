package com.example.gymapplication.ManagerActivities;

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
import com.example.gymapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Empolyee extends AppCompatActivity {
    private static  final String BASE_URL = "http://10.0.2.2:80/gymproject/manager/GetAllEmployee.php";
    ArrayList<employee> employees  = new ArrayList<>() ;
    RecyclerView recyclerView  ;
    public com.example.gymapplication.ManagerActivities.employeeadapter adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empolyee);
        recyclerView = findViewById(R.id.employee_recycler) ;

        getEmployee() ;
        recyclerView.setLayoutManager(new LinearLayoutManager(Empolyee.this));
        adapter = new com.example.gymapplication.ManagerActivities.employeeadapter(this,employees) ;
        recyclerView.setAdapter(adapter);

    }

    private void getEmployee() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response) ;
                            for (int i = 0; i <array.length(); i++) {
                                JSONObject object = array.getJSONObject(i) ;
                                int id = object.getInt("id");
                                int manger_id = object.getInt("manger_id");
                                String user_name = object.getString("user_name");
                                String password = object.getString("password");
                                String name = object.getString("name");
                                int phone = object.getInt("phone");
                                double salary = object.getInt("salary");
                                employee employee = new employee(id,name,user_name,password,phone,manger_id,salary) ;

                                adapter.add(employee);
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(Empolyee.this, error.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
                Volley.newRequestQueue(Empolyee.this).add(stringRequest)  ;
            }
        });

    }




    public void addEmployee(View view) {
        Intent intent=new Intent(this, com.example.gymapplication.ManagerActivities.Add_Employee.class);
        startActivity(intent);

    }


}
