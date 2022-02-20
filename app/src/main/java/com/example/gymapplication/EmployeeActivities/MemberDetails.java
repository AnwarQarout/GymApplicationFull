package com.example.gymapplication.EmployeeActivities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gymapplication.R;

import java.util.HashMap;

public class MemberDetails extends AppCompatActivity {
    TextView name,user_name,phone,height,weight;
    ImageView image;
    Button deleteButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details2);

        user_name = findViewById(R.id.details_userName);
        name = findViewById(R.id.details_name);
        phone = findViewById(R.id.details_phone);
        height = findViewById(R.id.details_height);
        weight = findViewById(R.id.details_weight);

        deleteButt = findViewById(R.id.deleteButt);
        deleteButt.setOnClickListener(view -> {
            AlertDialog diaBox = AskOption();
            diaBox.show();
        });

        Intent intent =getIntent();
        String user_namee = intent.getStringExtra("user_name");
        String namee = intent.getStringExtra("name");
        String phonee = intent.getStringExtra("phone");
        String heightt = intent.getStringExtra("height");
        String weightt = intent.getStringExtra("weight");

        user_name.setText(user_namee);
        name.setText(namee);
        phone.setText(phonee);
        height.setText(heightt);
        weight.setText(weightt);

    }

    private  void deleteMember(final String id){
    new Handler().post(new Runnable() {
        @Override
        public void run() {
            String url ="http://10.0.2.2:80/gymproject/employee/deleteHabib.php";
            RequestQueue requestQueue = Volley.newRequestQueue(MemberDetails.this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("response_del", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("error_del",""+error);
                }

            }){
                @NonNull
                protected HashMap<String,String> getParams() throws AuthFailureError{
                    HashMap<String,String> map = new HashMap<>();
                    map.put("id",id);
                    return map;
                }
            };

            requestQueue.add(stringRequest);
            startActivity(new Intent(MemberDetails.this,MemberActivity.class));
        }
    });

    }

    @NonNull
    private AlertDialog AskOption()
    {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(this)
                // set message, title, and icon
                .setTitle("Delete Member !!")
                .setMessage("Are you sure ? ")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        String id = getIntent().getStringExtra("id");
                        deleteMember(id);
                        dialog.dismiss();
                    }

                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();

        return myQuittingDialogBox;
    }

}