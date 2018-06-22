package com.example.phngtrn.accountlogin.Presenter;

import android.view.View;

import com.example.phngtrn.accountlogin.View.ViewXulyDangNhap;

public class PresenterXuLyDangNhap {
    ViewXulyDangNhap view ;

    public PresenterXuLyDangNhap(ViewXulyDangNhap view)
    {
        this.view = view;
    }

    public void KiemTraInfoLogin(String user, String password)
    {
        if(user.equals("tranthanhphuong") && password.equals("123456"))
        {
            view.DangNhapThanhCong();
        }
        else
        {
            view.DangNhapThatBai();
        }
    }
}
