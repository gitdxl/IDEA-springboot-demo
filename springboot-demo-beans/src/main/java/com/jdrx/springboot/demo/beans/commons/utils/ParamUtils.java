package com.jdrx.springboot.demo.beans.commons.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by dengxuelong on 2017/11/9.
 */
public class ParamUtils {
    /**
     * 为api/0/permission/role/queryRoleByPage接口随机生成参数列表
     * @return
     */
    public static HashMap createQueryRoleByPage() {
        int num = new Random().nextInt(2);
        HashMap map = new HashMap();
        HashSet<Integer> set = new HashSet();
        for (int i1 = 0; i1 <=num; i1++) {
            int seq = new Random().nextInt(2);
            set.add(seq);
        }
        for (Integer i : set) {
            String s = handle(i);
            String[] split = s.split(":");
            map.put(split[0],split[1]);
        }
        return map;
    }
    private static  String handle(int i){
        switch (i){
            case 0:return "providerId:"+new Random().nextInt(40)+60;
            case 1:return "organizationId:" + (new Random().nextInt(100000)+100000);
            case 2:return "roleType:" + new Random().nextInt(3);
            case 3:return "roleStatus:" + new Random().nextInt(2);
            case 4:return "deleteFlag:" + new Random().nextInt(2);
        }
        return "";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(MapUtils.mapToString(createQueryRoleByPage()));
        }
    }
}
