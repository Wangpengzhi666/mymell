package com.wpzmall.mymall.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.Registered.RegisteredBean;
import com.wpzmall.mymall.model.utils.MyTextUtils;
import com.wpzmall.mymall.presenter.RegPresenter;
import com.wpzmall.mymall.view.iview.IRegView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/12  11:59
 * <p>
 * 思路：
 *
 */


public class RegisteredActivity extends Activity implements IRegView<RegisteredBean>,View.OnClickListener{

    private ImageView imageLiftArrow;
    private EditText registeredUsername;
    private EditText registeredPassword;
    private EditText registeredTopassword;
    private EditText registeredEmail;
    private TextView registeredButton;
    private RegPresenter regPresenter;
    private String topassword;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        initView();
        setRegPresenter();

    }


    private void initView() {

        imageLiftArrow = (ImageView) findViewById(R.id.image_lift_arrow);
        imageLiftArrow.setOnClickListener(this);
        registeredUsername = (EditText) findViewById(R.id.registered_username);
        registeredUsername.setOnClickListener(this);
        registeredPassword = (EditText) findViewById(R.id.registered_password);
        registeredPassword.setOnClickListener(this);
        registeredTopassword = (EditText) findViewById(R.id.registered_topassword);
        registeredTopassword.setOnClickListener(this);
        registeredEmail = (EditText) findViewById(R.id.registered_email);
        registeredEmail.setOnClickListener(this);
        registeredButton = (TextView) findViewById(R.id.registered_button);
        registeredButton.setOnClickListener(this);
    }

    @Override
    public void callbackData(RegisteredBean registerBean) {
        Log.e("注册  :   " , registerBean.toString());
        Toast.makeText(this, "注册  :   " + registerBean.toString(), Toast.LENGTH_SHORT).show();
        Intent returnIntent = new Intent(RegisteredActivity.this, LoginActivity.class);
        startActivity(returnIntent);
        overridePendingTransition(R.anim.in2,R.anim.out2);
    }

    @Override
    public void callbackErrer(String errcode) {
        Toast.makeText(this, "注册  :   " + errcode.toString(), Toast.LENGTH_SHORT).show();

    }

    private void setRegPresenter() {
        regPresenter = new RegPresenter();
        regPresenter.setmT(this);

    }

    private void submit() {
        // validate
        String username = registeredUsername.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        password = registeredPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        topassword = registeredTopassword.getText().toString().trim();
        if (!password.equals(topassword)) {
            Toast.makeText(RegisteredActivity.this, "密码不一样", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(topassword)) {
            Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
            registeredTopassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub
                    if(hasFocus){
                        //获得焦点处理

                        password = registeredPassword.getText().toString().trim();
                    }
                    else {
                        //失去焦点处理
                        if (!password.equals(topassword)) {
                            Toast.makeText(RegisteredActivity.this, "密码不一样", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
            });
            return;

        }

        String email = registeredEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "请输入邮箱地址", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        regPresenter.getRegisterNwtWorkData(username, password, topassword,email);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_lift_arrow:
                Intent returnIntent = new Intent(RegisteredActivity.this, LoginActivity.class);
                startActivity(returnIntent);
                overridePendingTransition(R.anim.in2,R.anim.out2);
                break;
            case R.id.registered_button:
                submit();
                break;
        }
    }
}
