package com.example.phngtrn.accountlogin.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.phngtrn.accountlogin.LoginSuccessfully;
import com.example.phngtrn.accountlogin.Presenter.PresenterXuLyDangNhap;
import com.example.phngtrn.accountlogin.R;

public class MainActivity extends AppCompatActivity implements ViewXulyDangNhap{

    Button btnSignin;
    EditText user, pass;
    CheckBox check;
    PresenterXuLyDangNhap presenter;
    SharedPreferences sharedPreferences;//khởi tạo file để lưu
    SharedPreferences.Editor editor;//khởi tạo sửa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignin = (Button)findViewById(R.id.sign_in);
        user = (EditText)findViewById(R.id.edittextuser);
        pass = (EditText)findViewById(R.id.edittextpassword);
        check = (CheckBox)findViewById(R.id.checkid);

        sharedPreferences = getSharedPreferences("savepass", MODE_PRIVATE);//tạo tên file lưu để ứng dụng dọc, và chê độ truy cập **ẩn danh

        user.setText(sharedPreferences.getString("USER", ""));//gán chuỗi dữ liệu từ làn thứ 2 vào ứng dụng khi đã lưu, và rỗng khi vào lần 1 hoặc gán rỗng khi k check
        pass.setText(sharedPreferences.getString("PASS",""));

        presenter = new PresenterXuLyDangNhap(MainActivity.this);



        Toast.makeText(MainActivity.this, "Development By Phương", Toast.LENGTH_LONG).show();




        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(user.getText().toString().equals(""))//so sánh chuỗi , lấy chuỗi getText(), hàm equals(""),so sánh chuỗi rỗng
//                {
//                    Toast.makeText(MainActivity.this, "Chưa nhập Username", Toast.LENGTH_SHORT).show();
//                }
//                else if(pass.getText().toString().equals(""))
//                {
//                    Toast.makeText(MainActivity.this, "Chưa nhập Password", Toast.LENGTH_SHORT).show();
//                }
//                else if (user.getText().toString().equals("tranthanhphuong") && pass.getText().toString().equals("123456"))
//                {
//                    Intent ditoi = new Intent(MainActivity.this, LoginSuccessfully.class);//Intent <biến> = new Intent(màn hình hiện tại.this, màn hình chuyển đến.class)
//                    startActivity(ditoi);//phương thức chạy hàm Intent
//                }
//                else
//                {
//                    Toast.makeText(MainActivity.this, "Mày sai quá rồi, đăng nhập lại đi nào !", Toast.LENGTH_SHORT).show();
//                }
                presenter.KiemTraInfoLogin(user.getText().toString(),pass.getText().toString());
            }
        });


    }

    @Override
    public void DangNhapThanhCong() {
        //Toast.makeText(this, "Đăng nhập thành công !", Toast.LENGTH_SHORT).show();
        if(check.isChecked()){
            editor = sharedPreferences.edit();//cấp quyền chỉnh sửa file bằng eidtor
            editor.putString("USER", user.getText().toString());//lấy user và lưu vào "<key>"
            editor.putString("PASS", pass.getText().toString());//lấy pass và lưu vào "<key>"
            editor.apply();//Sau khi put thì apply hoặc commit
        }


        Intent loginorther = new Intent(this, LoginSuccessfully.class);
        startActivity(loginorther);
    }

    @Override
    public void DangNhapThatBai() {
        Toast.makeText(this, "Đăng nhâp thất bại", Toast.LENGTH_SHORT).show();

    }
}
