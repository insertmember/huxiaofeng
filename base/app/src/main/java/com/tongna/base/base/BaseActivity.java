package com.tongna.base.base;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

/**
 * Created by hxf on 2016/7/6.
 */
public abstract class BaseActivity extends Activity{
    public ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void toast(String text,boolean isShort,int  styley){

    }

    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.show();
        } else {
            if (!progressDialog.isShowing()) {
                progressDialog.show();
            }
        }
    }

    //隐藏ProgressDialog
    public void cancelProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
    abstract protected void initView();
    abstract protected void findViewById();
}
