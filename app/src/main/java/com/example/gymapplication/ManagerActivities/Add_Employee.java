package com.example.gymapplication.ManagerActivities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Add_Employee extends AppCompatActivity {
    String server_url_insert = "http://10.0.2.2:80/gymproject/manager/AddEmployee.php";
    EditText addName, addUserName, addPassword, addPhone, addSalary;
    Button addEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        // initializing our edittext and buttons

        addName = findViewById(R.id.addName);
        addUserName = findViewById(R.id.addUserName);
        addPassword = findViewById(R.id.addPassword);
        addPhone = findViewById(R.id.addPhone);
        addSalary = findViewById(R.id.addSalary);
        addEmp = findViewById(R.id.addEmp);

        addEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Add();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

            private void Add() throws UnsupportedEncodingException{
                String manger_id=URLEncoder.encode(MangerMainActivity.manager_id,"UTF8");
                String namee= URLEncoder.encode(addName.getText().toString(),"UTF8");
                String user_namee= URLEncoder.encode(addUserName.getText().toString(),"UTF8");
                String passwordd= URLEncoder.encode(addPassword.getText().toString(),"UTF8");
                String phonee=URLEncoder.encode(addPhone.getText().toString(),"UTF8");

                String salaryy=URLEncoder.encode(addSalary.getText().toString(),"UTF8");

                String url=server_url_insert+ "?manger_id="+manger_id+"&name="+namee+"&user_name="+user_namee+
                        "&password="+passwordd+"&phone="+phonee+"&salary="+salaryy+"";
                Log.e("URL",url);



        RequestQueue queue = Volley.newRequestQueue(Add_Employee.this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(Add_Employee.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Add_Employee.this, "e" + e.toString(), Toast.LENGTH_LONG).show();

                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Add_Employee.this, "error" + error.toString(), Toast.LENGTH_LONG).show();                    }
                }

);
        RequestQueue requestQueue=Volley.newRequestQueue(Add_Employee.this);
        requestQueue.add(request);
        addName.setText(" ");
        addUserName.setText(" ");
        addPassword.setText(" ");
        addPhone.setText(" ");
        addSalary.setText(" ");
        Intent in = new Intent(this , Empolyee.class) ;
        startActivity(in);
        }

    public void Add(View view) {
        Intent intent=new Intent(this,Add_Employee.class);
        startActivity(intent);
    }
}
