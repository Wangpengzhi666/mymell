package com.wpzmall.mymall.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.wpzmall.mymall.R;
import com.wpzmall.mymall.view.Event.MessageEvent;
import com.wpzmall.mymall.view.frgament.CartFragment;
import com.wpzmall.mymall.view.frgament.ClassFragment;
import com.wpzmall.mymall.view.frgament.HomeFragment;
import com.wpzmall.mymall.view.frgament.UserFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout MainFragment;
    private RadioButton HomeRadioButton;
    private RadioButton ClassRadioButton;
    private RadioButton CartRadioButton;
    private RadioButton UserRadioButton;
    private RadioGroup MainRadioGroup;
    private HomeFragment homeFragment;
    private ClassFragment classFragment;
    private CartFragment cartFragment;
    private UserFragment userFragment;
    //默认显示的值
    private int Display = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //登录页面跳转回来的值
        int key4 =  this.getIntent().getIntExtra("key4",4);
        if (key4 == 4){
            Display = key4;
        }

        //详情页跳回购物车
        int details = this.getIntent().getIntExtra("Details", 3);
        if (details == 3){
            Display = details;
            Toast.makeText(this, Display + "", Toast.LENGTH_SHORT).show();
        }

        initView();
        initDefultView();
    }

    private void initView() {

        MainFragment = (FrameLayout) findViewById(R.id.MainFragment);
        HomeRadioButton = (RadioButton) findViewById(R.id.HomeRadioButton);
        ClassRadioButton = (RadioButton) findViewById(R.id.ClassRadioButton);
        CartRadioButton = (RadioButton) findViewById(R.id.CartRadioButton);
        UserRadioButton = (RadioButton) findViewById(R.id.UserRadioButton);
        MainRadioGroup = (RadioGroup) findViewById(R.id.MainRadioGroup);
        switch (Display){
            case 1:
                break;
            case 2:
                break;
            case 3:
                HomeRadioButton.setChecked(false);
                ClassRadioButton.setChecked(false);
                CartRadioButton.setChecked(true);
                UserRadioButton.setChecked(false);
                break;
            case 4:
                HomeRadioButton.setChecked(false);
                UserRadioButton.setChecked(true);
                break;
        }
        HomeRadioButton.setOnClickListener(this);
        ClassRadioButton.setOnClickListener(this);
        CartRadioButton.setOnClickListener(this);
        UserRadioButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.HomeRadioButton:
                select(0);
                HomeRadioButton.setTextColor(ContextCompat.getColor(this,R.color.main));
                HomeRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_home_press),null,null);
                ClassRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                ClassRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_class),null,null);
                CartRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                CartRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_cart),null,null);
                UserRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                UserRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_user),null,null);
                break;
            case R.id.ClassRadioButton:
                select(1);
                HomeRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                HomeRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_home),null,null);
                ClassRadioButton.setTextColor(ContextCompat.getColor(this,R.color.main));
                ClassRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_class_press),null,null);
                CartRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                CartRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_cart),null,null);
                UserRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                UserRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_user),null,null);
                break;
            case R.id.CartRadioButton:
                select(2);
                HomeRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                HomeRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_home),null,null);
                ClassRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                ClassRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_class),null,null);
                CartRadioButton.setTextColor(ContextCompat.getColor(this,R.color.main));
                CartRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_cart_press),null,null);
                UserRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                UserRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_user),null,null);
                break;
            case R.id.UserRadioButton:
                select(3);
                HomeRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                HomeRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_home),null,null);
                ClassRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                ClassRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_class),null,null);
                CartRadioButton.setTextColor(ContextCompat.getColor(this,R.color.nav));
                CartRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_cart),null,null);
                UserRadioButton.setTextColor(ContextCompat.getColor(this,R.color.main));
                UserRadioButton.setCompoundDrawablesWithIntrinsicBounds(null,ContextCompat.getDrawable(this,R.mipmap.ic_nav_user_press),null,null);
                break;
        }

    }


    private void select(int i) {
        FragmentManager fm = getSupportFragmentManager();  //获得Fragment管理器
        FragmentTransaction ft = fm.beginTransaction(); //开启一个事务

        hidtFragment(ft);   //隐藏Fragment的方法，先判断fragment是否为空，如果不为空则隐藏Fragment

        switch (i) {//点击切换fragment,如果fragment为空，则创建，如果不为空，就显示
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.MainFragment, homeFragment);
                } else {
                    ft.show(homeFragment);
                }
                break;
            case 1:
                if (classFragment == null) {
                    classFragment = new ClassFragment();
                    ft.add(R.id.MainFragment, classFragment);
                } else {
                    ft.show(classFragment);
                }
                break;
            case 2:
                if (cartFragment == null) {
                    cartFragment = new CartFragment();
                    ft.add(R.id.MainFragment, cartFragment);
                } else {
                    ft.show(cartFragment);
                }
                break;
            case 3:
                if (userFragment == null) {
                    userFragment = new UserFragment();
                    ft.add(R.id.MainFragment, userFragment);
                } else {
                    ft.show(userFragment);
                }
                break;
        }
        ft.commit();   //提交事务

    }

    private void hidtFragment(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);

        }
        if (classFragment != null) {
            fragmentTransaction.hide(classFragment);

        }
        if (cartFragment != null) {
            fragmentTransaction.hide(cartFragment);

        }
        if (userFragment != null) {
            fragmentTransaction.hide(userFragment);

        }
    }

    private void initDefultView() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        homeFragment = new HomeFragment();
        ft.add(R.id.MainFragment, homeFragment);
        ft.commit();
    }
}