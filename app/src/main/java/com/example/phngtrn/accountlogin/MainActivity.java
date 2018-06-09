package com.example.phngtrn.accountlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSignin;
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Development By Phương", Toast.LENGTH_LONG).show();

        btnSignin = (Button)findViewById(R.id.sign_in);
        user = (EditText)findViewById(R.id.edittextuser);
        pass = (EditText)findViewById(R.id.edittextpassword);


        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.getText().toString().equals(""))//so sánh chuỗi , lấy chuỗi getText(), hàm equals(""),so sánh chuỗi rỗng
                {
                    Toast.makeText(MainActivity.this, "Chưa nhập Username", Toast.LENGTH_SHORT).show();
                }
                else if(pass.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Chưa nhập Password", Toast.LENGTH_SHORT).show();
                }
                else if (user.getText().toString().equals("tranthanhphuong") && pass.getText().toString().equals("123456"))
                {
                    Intent ditoi = new Intent(MainActivity.this, LoginSuccessfully.class);//Intent <biến> = new Intent(màn hình hiện tại.this, màn hình chuyển đến.class)
                    startActivity(ditoi);//phương thức chạy hàm Intent
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Mày sai quá rồi, đăng nhập lại đi nào !", Toast.LENGTH_SHORT).show();
                }




            }
        });


    }
}
