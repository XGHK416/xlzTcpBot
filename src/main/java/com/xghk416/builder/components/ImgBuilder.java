package com.xghk416.builder.components;

import com.xghk416.util.ImageUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

public class ImgBuilder {

    public static String UrlBuilder(String url) throws Exception {
        String base64 = ImageUtil.encodeImageToBase64(new URL(url));
        base64 = "[pic:"+ base64 + "]";//组装图片的格式
        return base64;
    }
    public static String BaseCodeBuilder(String base64) throws Exception {
        return "[pic:"+ base64 + "]";
    }

    public static String FileBuilder(String path){
            byte[] data = null;
            // 读取图片字节数组
            try {
                InputStream in = new FileInputStream(path);
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 对字节数组Base64编码
            Base64.Encoder encoder = Base64.getEncoder();
            String result = encoder.encodeToString(data);
            // 返回Base64编码过的字节数组字符
            return result;
    }
}
