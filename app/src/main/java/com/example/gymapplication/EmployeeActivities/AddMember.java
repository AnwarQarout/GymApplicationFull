package com.example.gymapplication.EmployeeActivities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class AddMember extends AppCompatActivity {

    String server_url_insert = "http://10.0.2.2:80/gymproject/employee/addHabib.php";
    EditText edtUsername, edtPassword, edtName, edtPhone, edtHeight, edtWeight;
    String employee_id="" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
         employee_id = getIntent().getStringExtra("id") ;
        edtUsername = (EditText) findViewById(R.id.edtUserName);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtName = (EditText) findViewById(R.id.edtName);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtHeight = (EditText) findViewById(R.id.edtHeight);
        edtWeight = (EditText) findViewById(R.id.edtWeight);

        Button addButton = (Button) findViewById(R.id.addButt);
        addButton.setOnClickListener(view -> checkData());
    }

    void addMember() throws UnsupportedEncodingException {

        String employee_id1 = URLEncoder.encode(EmployeeHomeActivity.employee_id, "UTF8");
        String username1 = URLEncoder.encode(edtUsername.getText().toString(), "UTF8");
        String password1 = URLEncoder.encode(edtPassword.getText().toString(), "UTF8");
        String name1 = URLEncoder.encode(edtUsername.getText().toString(), "UTF8");
        String phone1 = URLEncoder.encode(edtPhone.getText().toString(), "UTF8");
        String height1 = URLEncoder.encode(edtHeight.getText().toString(), "UTF8");
        String weight1 = URLEncoder.encode(edtWeight.getText().toString(), "UTF8");

        String url = server_url_insert + "?employee_id=" + employee_id1 + "&user_name=" + username1 + "&password=" + password1 + "&name=" + name1 + "&phone=" + phone1 + "&height=" + height1 + "&weight=" + weight1 + "";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(AddMember.this, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(AddMember.this, "e" + e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddMember.this, "err" + error.toString(), Toast.LENGTH_LONG).show();
            }
        }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(AddMember.this);
        requestQueue.add(stringRequest);
        edtUsername.setText("");
        edtPassword.setText("");
        edtName.setText("");
        edtPhone.setText("");
        edtHeight.setText("");
        edtWeight.setText("");
        startActivity(new Intent(AddMember.this,MemberActivity.class));
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    void checkData(){
        if (isEmpty(edtUsername)) {
            edtUsername.setError("Enter User Name !!");
        }
        if (isEmpty(edtPassword)) {
            edtPassword.setError("Enter Password !!");
        }
        if (isEmpty(edtName)) {
            edtName.setError("Enter Name !!");
        }
        if (isEmpty(edtPhone)) {
            edtPhone.setError("Enter Phone !!");
        }
        if (isEmpty(edtHeight)) {
            edtHeight.setError("Enter Height !!");
        }
        if (isEmpty(edtWeight)) {
            edtWeight.setError("Enter Weight !!");
        }
        if (!isEmpty(edtUsername) && !isEmpty(edtPassword) && !isEmpty(edtName) && !isEmpty(edtPhone) && !isEmpty(edtHeight) && !isEmpty(edtWeight)){
           try {
               addMember();
           }catch (UnsupportedEncodingException e){
               e.printStackTrace();
           }
        }
    }
}
