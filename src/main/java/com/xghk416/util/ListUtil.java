package com.xghk416.util;

import java.util.ArrayList;

public class ListUtil {
    public static ArrayList<String> StringsToArrayList(String[] list){
        ArrayList<String> transform= new ArrayList<>();
        for (String item :
                list) {
            transform.add(item);
        }
        return transform;
    }
}
