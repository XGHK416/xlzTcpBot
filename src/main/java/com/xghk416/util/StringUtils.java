package com.xghk416.util;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.Base64;

public class StringUtils {
	
	public static void main(String[] args) {
		byte[] bts = readFile("D:\\1.png");
		String base64Str = Base64.getEncoder().encodeToString(bts);
		System.out.println(bts);
		JSONObject json = new JSONObject();
		json.put("type", 106);
		json.put("msg", "[pic:"+ base64Str + "]");
		System.out.println(json);
		System.out.println("发送消息{\"msg\":\"[pic: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]111\",\"random\":-345236077,\"fromQQ\":794761226,\"selfQQ\":1789991699,\"type\":106,\"req\":2757}\r\n".length());
	}
	
	
	public static byte[] readFile(String fileName){
		InputStream in = null;
		try {
			in = new FileInputStream(new File(fileName));
			byte[] bts = new byte[in.available()];
			in.read(bts);
			return bts;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	

	//URL解码
	public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        	System.out.println("错误数据" + str);
            e.printStackTrace();
        }
        return result;
    }
	
	/**
	 * 16进制转换成为string类型字符串
	 * @param s
	 * @return
	 */
	public static String hexStringToString(String s) {
	    if (s == null || s.equals("")) {
	        return null;
	    }
	    s = s.replace(" ", "");
	    byte[] baKeyword = new byte[s.length() / 2];
	    for (int i = 0; i < baKeyword.length; i++) {
	        try {
	            baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    try {
	        s = new String(baKeyword, "UTF-8");
	        new String();
	    } catch (Exception e1) {
	        e1.printStackTrace();
	    }
	    return s;
	}
	
	
	public static String subStr(String str,String left,String right){
		if(!str.contains(left)){
			return null;
		}
		int a = str.indexOf(left);
		int b = str.length();
		if(!isEmpty(right)){
			int c = str.indexOf(right,a + left.length() + 1);
			if(c != -1){
				b = c;
			}
		}
		return str.substring(a + left.length(), b);
	}
	
	/**
	 * 判断文本是否没有值
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	
}
