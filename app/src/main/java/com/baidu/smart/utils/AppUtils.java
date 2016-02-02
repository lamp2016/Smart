
package com.baidu.smart.utils;

import android.net.Uri;

/**
 * Created by lishuai on 16/1/29.
 */
public class AppUtils {

    /**
     * fresco 设置图片非空判断
     * 
     * @param urlStr
     * @return
     */
    public static Uri parse(String urlStr) {
        Uri uri = null;
        if (urlStr == null) {
            uri = Uri.parse("");
        } else {
            uri = Uri.parse(urlStr);
        }
        return uri;
    }
}
