package com.jdrx.springboot.roleTest;

/**
 * Created by dengxuelong on 2017/11/10.
 */
public enum UrlEnums {
    baseUrl("http://192.168.40.250:8989/permission/"),
    SUPPLIER_BASE_URL("http://192.168.40.250:8989/supplier/"),
    PORTAL_BASE_URL("http://192.168.40.250:8989/portal/"),
    PORTAL_TOKEN("eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IiIsIm5hbWUiOiJ5ZjAwMSIsInVzZXJGdWxsTmFtZSI6InlmMDAxIiwidGVuYW50SWQiOiIyMDA1MzYiLCJ0ZW5hbnRTeW1ib2wiOiJ4eHgiLCJpZCI6IjIwMjA2MCIsImV4cCI6MTUxMzAzNzkwMiwiZW1haWwiOiIifQ.UrS6oTXpLgqQ_3Vl-GhquAWDTJSMRT7EqhQCGNrjtvk"),
    MSG_BASE_URL("http://192.168.40.250:8989/msg/"),
    MSG_TOKEN("eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE2MDA1MiIsIm5hbWUiOiJqZHJ4IiwidXNlckZ1bGxOYW1lIjoi5bCP5piOZmFpdGhfYmlhbjE0MCIsInRlbmFudElkIjoiMTQxIiwidGVuYW50U3ltYm9sIjoiamRyeF9kYiIsImlkIjoiMTc5IiwiZXhwIjoxNTEyODY4MzM0LCJlbWFpbCI6IjE4NkBxcS5jb20ifQ.rGXEDENxagZmg8b62yZcncK-_iA6NYtmJKUuBuj2vtE"),
    TOKEN("eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6Ijk5OTk5OTk5OSIsIm5hbWUiOiJqZHJ4IiwidXNlckZ1bGxOYW1lIjoi5bCP5piOZmFpdGhfYmlhbiIsInRlbmFudElkIjoiMTQxIiwidGVuYW50U3ltYm9sIjoiamRyeF9kYiIsImlkIjoiMTc5IiwiZXhwIjoxNTExNjU5MTIyLCJlbWFpbCI6Ijc3ODg4NzdAcXEuY29tIn0.2NiRiZgooXpb37WMHRXtzISL3jWy1p8N-h2WoFP48ho");
    private String value;
    private UrlEnums(String v){
        this.value = v;
    }
    public String getValue(){
        return value;
    }
}
