package com.xghk416.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class ImageUtil {
    public static String encodeImageToBase64(URL url) throws Exception {
        //��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦��
//        System.out.println("ͼƬ��·��Ϊ:" + url.toString());
            //������
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            //��������ʽΪ"GET"
            conn.setRequestMethod("GET");
            //��ʱ��Ӧʱ��Ϊ5��
            conn.setConnectTimeout(5 * 1000);
            //ͨ����������ȡͼƬ����
            InputStream inStream = conn.getInputStream();
            //�õ�ͼƬ�Ķ��������ݣ��Զ����Ʒ�װ�õ����ݣ�����ͨ����
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            //����һ��Buffer�ַ���
            byte[] buffer = new byte[1024];
            //ÿ�ζ�ȡ���ַ������ȣ����Ϊ-1������ȫ����ȡ���
            int len = 0;
            //ʹ��һ����������buffer������ݶ�ȡ����
            while ((len = inStream.read(buffer)) != -1) {
            //���������buffer��д�����ݣ��м����������ĸ�λ�ÿ�ʼ����len�����ȡ�ĳ���
                outStream.write(buffer, 0, len);
            }
            //�ر�������
            inStream.close();
            byte[] data = outStream.toByteArray();
            //���ֽ�����Base64����
            Base64.Encoder encoder = Base64.getEncoder();
            String base64 = encoder.encodeToString(data);
//            System.out.println("�����ļ�[{}]�����base64�ַ���:[{}]"+url.toString()+base64);
            return base64;//����Base64��������ֽ������ַ���
        }catch (FileNotFoundException fne){
            fne.printStackTrace();
            throw new Exception("�ļ�û�ҵ�");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new Exception("ͼƬ�ϴ�ʧ��,����ϵ�ͷ�!");
        }
    }
}
