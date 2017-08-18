package com.victor.takeawaymodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/takeaway/activity")
public class TakeAwayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);

        String name = getIntent().getStringExtra("name");
        String addr = getIntent().getStringExtra("addr");
        TextView tvName = (TextView) findViewById(R.id.tv_name);
        TextView tvAddr = (TextView) findViewById(R.id.tv_addr);

        tvName.setText("收货人：" + name);
        tvAddr.setText("收货地址：" + addr);
    }
}
