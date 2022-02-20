package com.example.gymapplication.EmployeeActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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
import java.util.List;

public class MemberActivity extends AppCompatActivity {
    private static final String BASE_URL = "http://10.0.2.2:80/gymproject/employee/readHabib.php";
    String employee_id = "";
    List<Member> memberList;

    RecyclerView recyclerView;

    Button addButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        recyclerView = findViewById(R.id.member_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        employee_id = getIntent().getStringExtra("id");
        memberList = new ArrayList<>();
        addButt = (Button) findViewById(R.id.openAddForm);
        addButt.setOnClickListener(view -> openAdd());

        loadItems();
    }

    private void openAdd() {
        Intent intent = new Intent(this, AddMember.class);
        intent.putExtra("id",employee_id) ;
        startActivity(intent);
    }


    private void loadItems() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {

                                JSONObject object = array.getJSONObject(i);

                                int id = object.getInt("id");
                                int employee_id = object.getInt("employee_id");
                                String user_name = object.getString("user_name");
                                String password = object.getString("password");
                                String name = object.getString("name");
                                int phone = object.getInt("phone");
                                Double height = object.getDouble("height");
                                Double weight = object.getDouble("weight");


                                Member member = new Member(id, employee_id, user_name, password, name, phone, height, weight);
                                memberList.add(member);
                            }

                        } catch (Exception e) {

                        }

                        MemberAdapter adapter = new MemberAdapter(MemberActivity.this,
                                memberList);
                        recyclerView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MemberActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(MemberActivity.this).add(stringRequest);
    }
}