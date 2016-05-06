package com.jingzhihulian.kyoucr.activity;

import com.jingzhihulian.kyoucr.fragment.Fragment1;
import com.jingzhihulian.kyoucr.fragment.Fragment2;
import com.jingzhihulian.kyoucr.fragment.Fragment3;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends FragmentActivity implements View.OnClickListener{
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        TextView textview1 = (TextView) findViewById(R.id.textview1);
        TextView textview2 = (TextView) findViewById(R.id.textview2);
        TextView textview3 = (TextView) findViewById(R.id.textview3);
        textview1.setOnClickListener(this);
        textview2.setOnClickListener(this);
        textview3.setOnClickListener(this);
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, new Fragment1());
        ft.commit();
    }


    @Override
    public void onClick(View v) {
        ft = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.textview1:
                ft.replace(R.id.content, new Fragment1());
                break;
            case R.id.textview2:
                ft.replace(R.id.content, new Fragment2());
                break;
            case R.id.textview3:
                ft.replace(R.id.content, new Fragment3());
                break;

        }
        ft.commit();
    }
}
