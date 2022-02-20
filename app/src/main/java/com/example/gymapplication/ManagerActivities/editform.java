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

public class editform extends AppCompatActivity {
    String server_url_insert = "http://10.0.2.2:80/gymproject/manager/EditEmployee.php";
    EditText edtSalary;
    Button editButt;
     String id = "" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editform);
        edtSalary = findViewById(R.id.edtSalary);
        editButt = findViewById(R.id.editButt);
        id= getIntent().getStringExtra("id") ;

        String[] split = id.toString().split(":");
         id = split[1].trim();
        System.out.println("raed id"+id);
        editButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Edit();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void Edit() throws UnsupportedEncodingException{
        String id1=URLEncoder.encode(id,"UTF8");
        String salaryy=URLEncoder.encode(edtSalary.getText().toString(),"UTF8");

        String url=server_url_insert+ "?salary="+salaryy+"&id="+id1;
        Log.e("URL",url);

        RequestQueue queue = Volley.newRequestQueue(editform.this);

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Toast.makeText(editform.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(editform.this, "e" + e.toString(), Toast.LENGTH_LONG).show();

                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       Toast.makeText(editform.this,"ett"+ error.toString(),Toast.LENGTH_LONG).show();
                    }
                }

        );
        RequestQueue requestQueue=Volley.newRequestQueue(editform.this);
        requestQueue.add(request);

        edtSalary.setText(" ");
        Intent intent = new Intent(this , Empolyee.class) ;
        startActivity(intent);
    }

}