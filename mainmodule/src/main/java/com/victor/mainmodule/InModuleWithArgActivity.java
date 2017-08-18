package com.victor.mainmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/test/activityWithArgs")
public class InModuleWithArgActivity extends AppCompatActivity {

    public static final void launch(String name, int age){
        ARouter.getInstance().build("/test/activityWithArgs")
                .withString("name", name)
                .withInt("age", age)
                .navigation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_module_with_arg);

        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", -1);
        TextView tvName = (TextView) findViewById(R.id.tv_name);
        TextView tvAge = (TextView) findViewById(R.id.tv_age);

        tvName.setText("name: " + name);
        tvAge.setText("age: " + age);
    }
}
