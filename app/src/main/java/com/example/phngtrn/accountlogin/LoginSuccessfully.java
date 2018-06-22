package com.example.phngtrn.accountlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.phngtrn.accountlogin.View.MainActivity;

public class LoginSuccessfully extends AppCompatActivity {
    Button comeback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successfully);
        comeback = (Button)findViewById(R.id.back);
        comeback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent quaylai = new Intent(LoginSuccessfully.this, MainActivity.class);
                startActivity(quaylai);
            }
        });
    }
}
