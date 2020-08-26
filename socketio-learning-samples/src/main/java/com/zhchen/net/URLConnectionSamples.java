package com.zhchen.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/25
 */
public class URLConnectionSamples {

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://github.com/");
        URLConnection urlConnection = url.openConnection();
        // post
        // urlConnection.setDoOutput(true);
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String str;
        while (null != (str = br.readLine())) {
            System.out.println(str);
        }
        br.close();
    }

}
