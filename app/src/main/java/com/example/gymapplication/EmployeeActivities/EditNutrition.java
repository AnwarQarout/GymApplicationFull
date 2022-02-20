package com.example.gymapplication.EmployeeActivities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gymapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class EditNutrition extends AppCompatActivity {
    EditText name, image;
    TextView membership;
    ArrayAdapter<String> adapter;
    ArrayList<String> types = new ArrayList<>();
    Spinner type;
    public static final String BASE_URL = "http://10.0.2.2:80/gymproject/employee/editNutrition.php";
    public static final String BASE_URL1 = "http://10.0.2.2:80/gymproject/employee/gettypes.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nutrition);
        name = findViewById(R.id.editnutname);
        type = findViewById(R.id.edittypeSpinner);
        image = findViewById(R.id.editnutimage);
        membership = findViewById(R.id.editmembership);
        Button update = findViewById(R.id.editbtn1) ;
        membership.setText("Membership: MassGain");
        name.setText(getIntent().getStringExtra("name"));
        image.setText(getIntent().getStringExtra("image"));
        getTypes();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, types);
        type.setAdapter(adapter);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Handler handler = new Handler() ;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!checkName() || !checkimage() ) {
                            String id  = getIntent().getStringExtra("id") ;
                            String employee_id = null ;
                            String namee = null ;
                            String typee = null ;
                            String membershippp = null ;
                            String imageee = null ;
                            try {
                                id = URLEncoder.encode(id, "UTF8");
                                employee_id = URLEncoder.encode(EmployeeHomeActivity.employee_id, "UTF8");
                                namee = URLEncoder.encode(name.getText().toString(), "UTF8");
                                typee = URLEncoder.encode(type.getSelectedItem().toString(), "UTF8");
                                membershippp = URLEncoder.encode(MembershipMainActivity.selectedMembership, "UTF8");
                                imageee = URLEncoder.encode(image.getText().toString(), "UTF8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                            String url = BASE_URL + "?id=" + id + "&employee_id=" + employee_id + "&type=" + typee + "&name=" + namee +"&membership=" + membershippp + "&image=" + imageee;


                            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        Toast.makeText(EditNutrition.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        Toast.makeText(EditNutrition.this, "e" + e.toString(), Toast.LENGTH_LONG).show();
                                    }

                                }
                            },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Toast.makeText(EditNutrition.this, "err" + error.toString(), Toast.LENGTH_LONG).show();

                                        }
                                    }
                            );
                            RequestQueue requestQueue = Volley.newRequestQueue(EditNutrition.this);
                            requestQueue.add(stringRequest);
                            name.setText(" ");
                            image.setText(" ");
                            Intent intent1 = new Intent(EditNutrition.this, workouts.class);
                            startActivity(intent1);
                        }
                    }
                });

            }
        });
    }

    public Boolean checkName() {
        if (name.getText().toString().isEmpty()) {
            name.setError("please enter name");
            return true;
        } else {
            name.setError(null);
            return false;
        }
    }

    public Boolean checkimage() {
        if (image.getText().toString().isEmpty()) {
            image.setError("please enter video url");
            return true;
        } else {
            image.setError(null);
            return false;
        }
    }

    private void getTypes() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        String type = object.getString("type");
                        adapter.add(type);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(EditNutrition.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(EditNutrition.this).add(stringRequest);
    }
}