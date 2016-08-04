package com.tongna.base.activity.base;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tongna.base.R;
import com.tongna.base.utils.ProgressBarUtil;
import com.tongna.base.utils.ToastUtils;
/**
 * Created by hxf on 2016/7/6.
 */
public abstract class BaseActivity extends Activity {

    private ConnectivityManager connectivityManager;
    private NetworkInfo info;
    public static int networkStatus;
    public static final String NETWORKSTATE = "com.text.android.network.state";
    public   BroadcastReceiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Intent intent = new Intent();
//        intent.setClass(this, NetworkStateService.class);
//        startService(intent);

         mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // The action of this intent or null if none is specified.

                // action是行动的意思，也许是我水平问题无法理解为什么叫行动，我一直理解为标识

                String action = intent.getAction(); //当前接受到的广播的标识(行动)

                // 当当前接受到的广播的标识为网络状态的标识时做相应判断

                if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                    // 获取网络连接管理器

                    connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    // 获取当前网络状态信息

                    info = connectivityManager.getActiveNetworkInfo();
                    if (info != null && info.isAvailable()) {
                        //当NetworkInfo不为空且是可用的情况下，获取当前网络的Type状态

                        //根据NetworkInfo.getTypeName()判断当前网络

                        String name = info.getTypeName();
                        if (name.equals("WIFI")) {
                            networkStatus = 2;
                            Toast.makeText(context, "wifi已连接", Toast.LENGTH_SHORT).show();
                        } else {
                            networkStatus = 1;
                            Toast.makeText(context, "移动网已连接", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // NetworkInfo为空或者是不可用的情况下
                        networkStatus = 0;
                        Toast.makeText(context, "没有可用网络!\n请连接网络后刷新本界面", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent();
                        it.putExtra("networkStatus", networkStatus);
                        it.setAction(NETWORKSTATE);
                        sendBroadcast(it); //发送无网络广播给注册了当前服务广播的Activity

                    }
                }
            }
        };

    }
    public void toast(String hint){
        ToastUtils.toast(this,hint,true);
    }
    public void snackbar(View view,String hint){
        ToastUtils.snackbar(view,hint);
    }
    public ProgressBarUtil progress(String title, String message, ProgressBarUtil.Style style) {
        ProgressBarUtil progressBarUtil = ProgressBarUtil.create(this)
                .setStyle(style)
                .setMessage(message)
                .setTitle(title)
                .setIcon(R.mipmap.ic_launcher)
                .setSpinner();
        return progressBarUtil;

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mReceiver, mFilter);
    }

    abstract protected void initView();

    abstract protected void findViewById();

}
