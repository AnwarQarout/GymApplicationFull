package com.example.gymapplication.EmployeeActivities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

public class EditWorkout extends AppCompatActivity {
    EditText name, steps, video;
    Button update;

    public static final String BASE_URL = "http://10.0.2.2:80/gymproject/employee/editworkout.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_workout);
        name = findViewById(R.id.editworkoutname);
        steps = findViewById(R.id.editworkoutsteps);
        video = findViewById(R.id.editworkoutvideo);
        update = findViewById(R.id.Updatebtn);
        name.setText(getIntent().getStringExtra("name"));
        steps.setText(getIntent().getStringExtra("steps"));
        video.setText(getIntent().getStringExtra("video"));
        update.setOnClickListener(new View.OnClickListener() {
            String id = getIntent().getStringExtra("id");
            @Override
            public void onClick(View view) {
          new Handler().post(new Runnable() {
              @Override
              public void run() {
                  if (!checkName() || !checksteps() || !checkvideo()) {

                      String idd = null;
                      String namee = null;
                      String employee_id = null;
                      String videoo = null;
                      String step = null;

                      try {
                          idd = URLEncoder.encode(id, "UTF8");
                          employee_id = URLEncoder.encode(EmployeeHomeActivity.employee_id, "UTF8");
                          videoo = URLEncoder.encode(video.getText().toString(), "UTF8");
                          step = URLEncoder.encode(steps.getText().toString(), "UTF8");
                          namee = URLEncoder.encode(name.getText().toString(), "UTF8");
                      } catch (UnsupportedEncodingException e) {
                          e.printStackTrace();
                      }
                      String url = BASE_URL + "?id=" + id + "&employee_id=" + employee_id + "&name=" + namee + "&steps=" + step + "&video=" + videoo;


                      StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                          @Override
                          public void onResponse(String response) {
                              try {
                                  JSONObject jsonObject = new JSONObject(response);
                                  Toast.makeText(EditWorkout.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                              } catch (JSONException e) {
                                  e.printStackTrace();
                                  Toast.makeText(EditWorkout.this, "e" + e.toString(), Toast.LENGTH_LONG).show();
                              }

                          }
                      },
                              new Response.ErrorListener() {
                                  @Override
                                  public void onErrorResponse(VolleyError error) {
                                      Toast.makeText(EditWorkout.this, "err" + error.toString(), Toast.LENGTH_LONG).show();

                                  }
                              }
                      );
                      RequestQueue requestQueue = Volley.newRequestQueue(EditWorkout.this);
                      requestQueue.add(stringRequest);
                      name.setText(" ");
                      video.setText(" ");
                      steps.setText(" ");
                      Intent intent1 = new Intent(EditWorkout.this, workouts.class);
                      startActivity(intent1);

                  }
              }
          });
            }
        });
    }

    public void update(View view) throws UnsupportedEncodingException {

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