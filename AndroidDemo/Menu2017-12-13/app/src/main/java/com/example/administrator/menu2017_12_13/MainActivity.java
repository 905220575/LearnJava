package com.example.administrator.menu2017_12_13;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView tv_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_test = (TextView) findViewById(R.id.tv_test);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //将页面定义的menu配置到到activity中
        new MenuInflater(getApplication()).inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                tv_test.setTextColor(Color.RED);
                break;
            case R.id.blue:
                tv_test.setTextColor(Color.BLUE);
                break;
            case R.id.tenpx:
                tv_test.setTextSize(TypedValue.COMPLEX_UNIT_PX,10);
            case R.id.twentypx:
                tv_test.setTextSize(TypedValue.COMPLEX_UNIT_PX,20);
        }
        return super.onOptionsItemSelected(item);
    }

}
