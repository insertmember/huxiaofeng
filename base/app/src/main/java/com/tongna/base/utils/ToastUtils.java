package com.tongna.base.utils;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tongna.base.R;
/**
 * Created by hxf on 2016/8/4.
 */
public class ToastUtils {
    public static void toast(Context context, String hint, boolean isLong) {
        if (context != null) {
            if (isLong) {
                Toast.makeText(context, hint, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, hint, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void snackbar(final View rootView,String hint) {
        if (null == rootView) {
            return;
        }
        Snackbar snackbar = Snackbar.make(rootView, hint, Snackbar.LENGTH_LONG).setAction("", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setSnackbarMessageTextColor(snackbar, Color.parseColor("#FFFFFF"));
        snackbar.show();
    }

    public static void setSnackbarMessageTextColor(Snackbar snackbar, int color) {
        View view = snackbar.getView();
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(color);
    }
}
