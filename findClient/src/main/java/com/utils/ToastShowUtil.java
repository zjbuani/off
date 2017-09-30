package com.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by fengx on 2017/9/20.
 */

public class ToastShowUtil {
    private static Toast mToast;
    public static void showToast(Context context, String content) {
        if (mToast ==null) {
            mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        }else {
            mToast.setText(content);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
