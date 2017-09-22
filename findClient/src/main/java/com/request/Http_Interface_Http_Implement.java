package com.request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.fengxun.base.MyApplication;

import java.util.Map;

/**
 * Created by fengx on 2017/6/21.
 */

public abstract class Http_Interface_Http_Implement implements Http_URl {

    public static void loadPostSign(String url, Map<String, String> userMap, Response.Listener listener) {
    }

    public static void loadGetWeather(String url, Response.Listener<String> listener) {
    }

    public static void request(StringRequest stringRequest) {
        MyApplication.getHttpQueues().add(stringRequest);
    }

    ;


}
