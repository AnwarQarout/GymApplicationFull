package com.example.gymapplication.EmployeeActivities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.gymapplication.R;

public class EmployeeHomeActivity extends AppCompatActivity {
  public static String employee_id  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);
        Button btn1 = (Button) findViewById(R.id.butt1);
        Button btn2 = (Button) findViewById(R.id.butt2);
        Button btn3 = (Button) findViewById(R.id.butt3);
        employee_id = getIntent().getStringExtra("id") ;
        System.out.println("ff5f5f55f5f5f55f5f5f55f5f5"+employee_id);
        btn1.setOnClickListener(view -> openMember());
        btn2.setOnClickListener(view -> openMemberShip());

    }

    private void openMember() {
        Intent intent =new Intent(this, MemberActivity.class);
        intent.putExtra("id",employee_id) ;
        startActivity(intent);
    }

    public void openMemberShip(){
        Intent intent =new Intent(this, MemberShipActivity.class);
        intent.putExtra("id",employee_id) ;
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent=new Intent(this, com.example.gymapplication.UserActivities.loginActivity.class);
        startActivity(intent);
    }
}