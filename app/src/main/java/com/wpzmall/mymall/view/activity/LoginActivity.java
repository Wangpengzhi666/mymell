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
import com.wpzmall.mymall.model.Bean.login.LoginBean;
import com.wpzmall.mymall.presenter.LoginPresenter;
import com.wpzmall.mymall.view.iview.ILoginView;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/11  17:43
 * <p>
 * 思路：
 */


public class LoginActivity extends Activity implements View.OnClickListener,ILoginView<LoginBean> {

    private ImageView imageLiftArrow;
    private EditText loginEditUsername;
    private EditText loginEditPassword;
    private TextView LoginTextLogin;
    private TextView loginTextZhuce;
    private TextView loginTextPassword;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setPresenter();

    }

    private void setPresenter() {
        mPresenter = new LoginPresenter();
        mPresenter.setmT(this);
    }

    private void initView() {

        imageLiftArrow = (ImageView) findViewById(R.id.image_lift_arrow);
        imageLiftArrow.setOnClickListener(this);
        loginEditUsername = (EditText) findViewById(R.id.login_edit_username);
        loginEditUsername.setOnClickListener(this);
        loginEditPassword = (EditText) findViewById(R.id.login_edit_password);
        loginEditPassword.setOnClickListener(this);
        LoginTextLogin = (TextView) findViewById(R.id.Login_text_login);
        LoginTextLogin.setOnClickListener(this);
        loginTextZhuce = (TextView) findViewById(R.id.login_text_zhuce);
        loginTextZhuce.setOnClickListener(this);
        loginTextPassword = (TextView) findViewById(R.id.login_text_password);
        loginTextPassword.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String username = loginEditUsername.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = loginEditPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Login_text_login:
                submit();
                String Username = loginEditUsername.getText().toString();
                String Password = loginEditPassword.getText().toString();
                mPresenter.getLoginData(Username,Password);
                break;
            case R.id.login_text_zhuce:
                Intent intent = new Intent(LoginActivity.this, RegisteredActivity.class);
                startActivity(intent);
                break;
            case R.id.login_text_password:
                break;
            case R.id.image_lift_arrow:
                Intent returnintent = new Intent(LoginActivity.this, MainActivity.class);
                returnintent.putExtra("key4",4);
                startActivity(returnintent);
                break;
        }
    }

    @Override
    public void callbackData(LoginBean loginBean) {
        Log.e("LogActivity   :  ",loginBean.getDatas().getError());
        Toast.makeText(LoginActivity.this,loginBean.getDatas().getError(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void callbackErrer(String errcode) {

    }
}
