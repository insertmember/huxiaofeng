package com.tongna.base.utils;
import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;

/**
 * Created by hxf on 2016/8/4.
 */
public class ProgressBarUtil {
    public enum Style {
        STYLE_SPINNER, STYLE_HORIZONTAL
    }
    private Context mContext;
    private int progress;
    private String title;
    private String message;
    private Integer iconId;
    private ProgressDialog mDialog;
    private boolean isIndeterminate;
    private boolean isCancelable = true;
    private int progressMax;
    private Style style;

    public ProgressBarUtil(Context context) {
        mContext = context;
        progress = 0;
        mDialog = new ProgressDialog(context);
    }
    public ProgressBarUtil setStyle(ProgressBarUtil.Style style){
        this.style = style;
        return this;
    }
    public static ProgressBarUtil create(Context context) {
        return new ProgressBarUtil(context);
    }
//    public ProgressBarUtil setStyle(Style style) {
//        switch (style) {
//            case STYLE_SPINNER:
//                //设置进度条风格，风格为长形，有刻度的
//                mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                break;
//            case STYLE_HORIZONTAL:
//                mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                break;
//        }
//        setSpinner();
//        return this;
//    }

    public ProgressBarUtil setSpinner() {
        if(style == Style.STYLE_HORIZONTAL){
            mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        }else{
            mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//设置进度条风格，风格为长形，有刻度的
        //mDialog.setTitle(title);
//设置ProgressDialog 标题
        mDialog.setMessage(message);
//设置ProgressDialog 提示信息
        // mDialog.setIcon(R.mipmap.app_icon);
//设置ProgressDialog 标题图标
        mDialog.setProgress(59);
//设置ProgressDialog 进度条进度
        mDialog.setIndeterminate(false);
//设置ProgressDialog 的进度条是否不明确
        mDialog.setCancelable(true);
//设置ProgressDialog 是否可以按退回按键取消
        mDialog.show();
//让ProgressDialog显示
        show();
        return this;
    }
    public ProgressBarUtil setProgress(int progress) {
        mDialog.setProgress(progress);
        return this;
    }
    public ProgressBarUtil setProgressMax(int progressMax) {
        this.progressMax = progressMax;
        mDialog.setMax(progressMax);
        return this;
    }

    public void show() {
        if (null != mDialog && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    public void dismiss() {
        if (null != mDialog && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    public ProgressBarUtil setTitle(String title) {
        this.title = title;
        mDialog.setTitle(title);
        return this;
    }

    public ProgressBarUtil setMessage(String message) {
        this.message = message;
        mDialog.setMessage(message.toString());
        return this;
    }

    public ProgressBarUtil setIcon(Integer iconId) {
        this.iconId = iconId;
        mDialog.setIcon(iconId);
        return this;
    }

    public ProgressBarUtil setIndeterminate(boolean indeterminate) {
        isIndeterminate = indeterminate;
        mDialog.setIndeterminate(indeterminate);
        return this;
    }

    public ProgressBarUtil setCancelable(boolean cancelable) {
        isCancelable = cancelable;
        mDialog.setCancelable(cancelable);
        return this;
    }
}
