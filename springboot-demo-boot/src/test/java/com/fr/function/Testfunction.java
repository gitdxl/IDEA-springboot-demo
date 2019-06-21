package com.fr.function;

import com.fr.script.AbstractFunction;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Objects;

public class Testfunction extends AbstractFunction {
    @Override
    public String run(Object[] objects) {
        if (objects.length != 2) {
            return "";
        }
        //包含所有参数的字符串
        String params = (String) objects[0];
        //要获取参数的参数名
        String targetParam = (String) objects[1];
        try {
            //解密
            Base64.Decoder decoder = Base64.getDecoder();
            params = new String(decoder.decode(params),"UTF-8");
            String[] paramArray = params.split(",");
            for (String param : paramArray) {
                String[] p = param.split("=");
                if (p[0].equals(targetParam)) {
                    return p[1];
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(Float.valueOf(Float.NaN).equals(Float.valueOf(Float.NaN)));
        String s = "company_no=52,oId=52,user_id=61,operation=write,df_id=3073,company_id=52,tenant_id=52,category=出厂水日报";
        Base64.Encoder encoder = Base64.getEncoder();
        s = encoder.encodeToString(s.getBytes("UTF-8"));
        Object o[] = {s,"d"};
        System.out.println(new Testfunction().run(o));
    }
//Y29tcGFueV9ubz01MixvSWQ9NTIsdXNlcl9pZD02MSxvcGVyYXRpb249d3JpdGUsZGZfaWQ9MzA3Myxjb21wYW55X2lkPTUyLHRlbmFudF9pZD01MixjYXRlZ29yeT3lh7rljoLmsLTml6XmiqU=
}
