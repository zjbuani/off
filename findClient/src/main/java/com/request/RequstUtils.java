package com.request;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.fengxun.base.MyApplication;


import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.*;

/**
 * Created by fengx on 2017/6/20.
 */

public class RequstUtils extends Http_Interface_Http_Implement {


    public static void loadPostSign(String url, final Map<String, String> userMap, Response.Listener listener) {
        StringRequest stringRequest = new StringRequest(Method.POST, url, listener, null) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.putAll(userMap);
                return map;
            }
        };
        Log.e("loadPostDateJson", stringRequest.toString());
       request(stringRequest);
    }

    public static void loadGetWeather(String url, Response.Listener<String> listener) {
        StringRequest request = new StringRequest(Request.Method.GET, url, listener, null);
        //设置取消取消http请求标签 Activity的生命周期中的onStiop()中调用
        request.setTag("volleyget");
        request(request);
    }
}
