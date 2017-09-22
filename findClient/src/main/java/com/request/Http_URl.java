package com.request;

/**
 * Created by fengx on 2017/6/20.
 */

public  interface Http_URl     {
       String LOCAL_URI ="http://192.168.0.100:8421";
       String REMOTE_URI ="http://1n7o321771.51mypc.cn:12804";
       String  WEATHER     = "https://api.seniverse.com/v3/weather/daily.json?key=g0np7ibg5obi2r0g&location=shanghai&language=zh-Hans&unit=c&start=0&days=1";

    //用户登陆接口
      String SIGNIN=  "http://139.196.5.153:8080/gos/gosapp/login";
    //请求项目列表
      String BUILDLIST = "/buildingList";
    //请求楼层和分区数组
      String BUILDFLOORS = "/buildingFloors";
    //向服务器请求项目指定范围内的照明系统的总体参数
      String LIGHTSYSTEM ="/lightSystem";
    //向服务器请求项目指定范围内照明系统的设备参数列表
      String LIGHTLIST ="/lightList";


}
