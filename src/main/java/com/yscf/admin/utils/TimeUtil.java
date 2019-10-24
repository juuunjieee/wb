package com.yscf.admin.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    /**
     * 返回当前网络事件  YYYY-MM-dd HH:mm:ss
     * @param webUrl 网络服务url
     * @return String
     */
    public static String getNetworkTime(String webUrl) {
        try {
            URL url = new URL(webUrl);
            URLConnection conn = url.openConnection();
            conn.connect();
            long dateL = conn.getDate();
            Date date = new Date(dateL);
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            return dateFormat.format(date);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 返回当前网络时间
     * @param webUrl 网络服务url
     * @return Date
     */
    public static Date getNetworkTimeToDate(String webUrl) {
        try {
            URL url = new URL(webUrl);
            URLConnection conn = url.openConnection();
            conn.connect();
            long dateL = conn.getDate();
            Date date = new Date(dateL);
            return date;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        String webUrl = "http://www.baidu.com";//百度时间
//        String webTime = getNetworkTime(webUrl);
//        Date webTimeToDate = getNetworkTimeToDate(webUrl);
//        System.out.println(webTime);
//        System.out.println(webTimeToDate);
    }
}
