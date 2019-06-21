//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.jdrx.springboot.demo.beans.commons.factory;


import com.jdrx.springboot.demo.beans.enums.EApiStatus;
import com.jdrx.springboot.demo.beans.vo.ResposeVO;

public class ResponseFactory {
    public ResponseFactory() {
    }

    public static ResposeVO ok(Object obj) {
        ResposeVO vo = new ResposeVO();
        vo.setData(obj);
        vo.setMessage(EApiStatus.SUCCESS.getMessage());
        vo.setStatus(EApiStatus.SUCCESS.getStatus());
        return vo;
    }

    public static ResposeVO err(Object obj, EApiStatus status) {
        ResposeVO vo = new ResposeVO();
        vo.setData("");
        vo.setMessage(String.valueOf(obj));
        vo.setStatus(status.getStatus());
        return vo;
    }
}
