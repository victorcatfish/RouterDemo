package com.victor.mainmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnInModule;
    private Button mBtnInModuleArgs;
    private Button mBtnOutModule;
    private Button mBtnToTakeAway;
    private Button mBtnToWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnInModule = (Button) findViewById(R.id.btn_in_module);
        mBtnInModuleArgs = (Button) findViewById(R.id.btn_in_module_args);
        mBtnOutModule = (Button) findViewById(R.id.btn_to_group_buy);
        mBtnToTakeAway = (Button) findViewById(R.id.btn_to_take_away);
        mBtnToWeb = (Button) findViewById(R.id.btn_to_web);

        initListener();
    }

    private void initListener() {
        mBtnInModule.setOnClickListener(this);
        mBtnInModuleArgs.setOnClickListener(this);
        mBtnOutModule.setOnClickListener(this);
        mBtnToTakeAway.setOnClickListener(this);
        mBtnToWeb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_in_module){
            ARouter.getInstance().build("/test/activity").navigation();
        } else if (id == R.id.btn_in_module_args){
            InModuleWithArgActivity.launch("Victor", 28);
        } else if (id == R.id.btn_to_group_buy){
            ARouter.getInstance().build("/groupbuy/Activity").navigation();
        } else if (id == R.id.btn_to_take_away) {
            ARouter.getInstance().build("/takeaway/activity")
                    .withString("name", "隔壁老王")
                    .withString("addr", "就在你隔壁咯")
                    .navigation();
        } else if (id == R.id.btn_to_web) {
            WebActivity.launch();
        }
    }
}
