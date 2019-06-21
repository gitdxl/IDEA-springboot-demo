package com.jdrx.springboot.demo.beans.commons.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by dengxuelong on 2017/11/8.
 */
public class MapUtils {
    /**
     * Map -> String
     * @param map
     * @return
     */
    public static String mapToString(Map map){
        StringBuilder sb = new StringBuilder("{");
        if (map != null) {
            for (Object o : map.keySet()) {
                Object value = map.get(o);
                if (value instanceof String){
                    String s = (String)value;
                    if ("".equals(s)){
                        sb.append(new StringBuilder(o.toString()).append(":").append("空串").append(","));
                    }else if(" ".equals(s)){
                        sb.append(new StringBuilder(o.toString()).append(":").append("空格").append(","));
                    }else if(s.length() > 50){
                        sb.append(new StringBuilder(o.toString()).append(":").append(s.length()).append("个字符").append(","));
                    }else{
                        sb.append(new StringBuilder(o.toString()).append(":").append(map.get(o).toString()).append(","));
                    }
                }else{
                    sb.append(new StringBuilder(String.valueOf(o)).append(":")
                            .append(String.valueOf(map.get(o).toString())).append(","));
                }
            }
        }
        if (sb.toString().endsWith(",")) {
            sb = new StringBuilder(sb.substring(0,sb.length()-1));
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("a","");
        map.put("c"," ");
        map.put("d","dff");
        map.put("aa","  ");
        map.put("vv","");
        map.put("cc"," ");
        System.out.println(mapToString(map));
    }
}
