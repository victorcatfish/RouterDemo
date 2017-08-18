package com.victor.mainmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/fromweb/activity")
public class FromWebActivity extends AppCompatActivity {

    @Autowired(name = "name")
    String mName;
    @Autowired(name = "age")
    int mAge;
    @Autowired(name = "gender")
    boolean mGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_web);
        ARouter.getInstance().inject(this);

        TextView tvName = (TextView) findViewById(R.id.tv_from_web_name);
        TextView tvGender = (TextView) findViewById(R.id.tv_from_web_gender);
        TextView tvAge = (TextView) findViewById(R.id.tv_from_web_age);

        tvName.setText("姓名：" + mName);
        tvGender.setText("性别：" + mGender);
        tvAge.setText("年龄：" + mAge);
    }
}
