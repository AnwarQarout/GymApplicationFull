package com.example.gymapplication.EmployeeActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gymapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AddWorkOuts extends AppCompatActivity {
    EditText name, steps, video;
    Button add;
    public static final String BASE_URL = "http://10.0.2.2:80/gymproject/employee/addworkout.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work_outs);
        name = findViewById(R.id.addnutname);
        steps = findViewById(R.id.addnutmembership);
        video = findViewById(R.id.addtypeSpinner);

    }

    public void add(View view) throws UnsupportedEncodingException {
        if (!checkName() || !checksteps() || !checkvideo()) {
            String membership = URLEncoder.encode(MembershipMainActivity.selectedMembership, "UTF8");
            String employee_id = URLEncoder.encode(EmployeeHomeActivity.employee_id, "UTF8");
            String namee = URLEncoder.encode(name.getText().toString(), "UTF8");
            String step = URLEncoder.encode(steps.getText().toString(), "UTF8");
            String videoo = URLEncoder.encode(video.getText().toString(), "UTF8");
            String url = BASE_URL + "?employee_id=" + employee_id + "&name=" + namee + "&steps=" + step + "&video=" + videoo + "&membership=" + membership;
            System.out.println(url);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        System.out.println("response ------------------------------- " + response);
                        JSONObject jsonObject = new JSONObject(response);

                        Toast.makeText(AddWorkOuts.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(AddWorkOuts.this, "e" + e.toString(), Toast.LENGTH_LONG).show();
                    }

                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(AddWorkOuts.this, "err" + error.toString(), Toast.LENGTH_LONG).show();

                        }
                    }
            );
            RequestQueue requestQueue = Volley.newRequestQueue(AddWorkOuts.this);
            requestQueue.add(stringRequest);
            name.setText(" ");
            video.setText(" ");
            steps.setText(" ");
            Intent intent = new Intent(this, workouts.class);
            startActivity(intent);

        }
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

    public Boolean checksteps() {
        if (steps.getText().toString().isEmpty()) {
            steps.setError("please enter steps");
            return true;
        } else {
            steps.setError(null);
            return false;
        }
    }

    public Boolean checkvideo() {
        if (video.getText().toString().isEmpty()) {
            video.setError("please enter video url");
            return true;
        } else {
            video.setError(null);
            return false;
        }
    }
}