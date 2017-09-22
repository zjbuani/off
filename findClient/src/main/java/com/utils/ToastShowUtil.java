package com.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by fengx on 2017/9/20.
 */

public class ToastShowUtil {
    public static void showToast(Context context,String content){
        Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
    }
}
