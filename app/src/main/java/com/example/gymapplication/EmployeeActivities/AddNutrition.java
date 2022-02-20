package com.example.gymapplication.EmployeeActivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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

public class AddNutrition extends AppCompatActivity {
    ArrayAdapter<String> adapter  ;
    ArrayList<String> types = new ArrayList<>();
    EditText name, image ;
    TextView membership;

    Spinner type;
    public static final String BASE_URL = "http://10.0.2.2:80/gymproject/employee/addNutrition.php";
    public static final String BASE_URL1 = "http://10.0.2.2:80/gymproject/employee/gettypes.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nutrition);
        name = findViewById(R.id.addnutname);
        type = findViewById(R.id.addtypeSpinner);
        image = findViewById(R.id.addnutimage);
        membership = findViewById(R.id.membershipadd);
        membership.setText("Membership: " + MembershipMainActivity.selectedMembership);
        getTypes();
       adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,types);
        type.setAdapter(adapter);
    }


    public void add(View view) throws UnsupportedEncodingException {
        if (!checkName() || !checkimage()) {
            String membership = MembershipMainActivity.selectedMembership;
            String employee_id = URLEncoder.encode(EmployeeHomeActivity.employee_id, "UTF8");
            String namee = URLEncoder.encode(name.getText().toString(), "UTF8");
            String typee = URLEncoder.encode(type.getSelectedItem().toString(), "UTF8");
            String imagee = URLEncoder.encode(image.getText().toString(), "UTF8");
            String url = BASE_URL + "?employee_id=" + employee_id + "&name=" + namee + "&type=" + typee + "&image=" + imagee + "&membership=" + membership;
            Log.d("dsa", url);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        Toast.makeText(AddNutrition.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(AddNutrition.this, "e" + e.toString(), Toast.LENGTH_LONG).show();
                    }

                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(AddNutrition.this, "err" + error.toString(), Toast.LENGTH_LONG).show();

                        }
                    }
            );
            RequestQueue requestQueue = Volley.newRequestQueue(AddNutrition.this);
            requestQueue.add(stringRequest);
            name.setText(" ");
            image.setText(" ");
            Intent intent = new Intent(this, AllNutritions.class);
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
    public Boolean checkimage() {
        if (image.getText().toString().isEmpty()) {
            image.setError("please enter video url");
            return true;
        } else {
            image.setError(null);
            return false;
        }
    }

    private void getTypes(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        String type = object.getString("type");

                       adapter.add(type) ;
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(AddNutrition.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        Volley.newRequestQueue(AddNutrition.this).add(stringRequest);
    }

}