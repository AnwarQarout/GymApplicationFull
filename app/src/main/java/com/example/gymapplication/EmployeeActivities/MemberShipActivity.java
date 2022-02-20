package com.example.gymapplication.EmployeeActivities;

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
import java.util.List;

public class MemberShipActivity extends AppCompatActivity {
    private List<MemberShip> items = new ArrayList<>();
    private RecyclerView recycler;

    private static  final String BASE_URL = "http://10.0.2.2:80/gymproject/employee/read2Habib.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_ship);
        recycler = findViewById(R.id.membership_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        loadItems();
    }
    private void loadItems() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i<array.length(); i++){

                                JSONObject object = array.getJSONObject(i);

                                String name = object.getString("name");
                                MemberShip membership = new MemberShip(name);
                                items.add(membership);
                            }

                        }catch (Exception e){

                        }

                        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(MemberShipActivity.this, items);
                        recycler.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MemberShipActivity.this, error.toString(),Toast.LENGTH_LONG).show();
            }
        });

        Volley.newRequestQueue(MemberShipActivity.this).add(stringRequest);
    }
}