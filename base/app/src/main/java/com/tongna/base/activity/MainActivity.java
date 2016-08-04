package com.tongna.base.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tongna.base.R;
import com.tongna.base.activity.base.BaseActivity;
import com.tongna.base.utils.ProgressBarUtil;
import com.tongna.base.utils.ToastUtils;

public class MainActivity extends BaseActivity {
    ProgressBarUtil mBarHXF;
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        findViewById();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void findViewById() {
        button = (Button) findViewById(R.id.button);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress("测试标题", "测试消息", ProgressBarUtil.Style.STYLE_HORIZONTAL);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress("测试标题", "测试消息", ProgressBarUtil.Style.STYLE_SPINNER);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.toast(MainActivity.this, "网络状态=" + networkStatus, true);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar(button,"网络状态=" + networkStatus);
            }
        });

    }


}