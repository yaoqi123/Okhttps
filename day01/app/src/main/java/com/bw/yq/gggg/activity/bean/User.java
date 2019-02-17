package com.bw.yq.gggg.activity.bean;

import java.util.ArrayList;

/**
 * @author yaoqi
 * @fileName User
 * @package com.bw.yq.gggg.activity.bean
 * @date 2019/2/14 10:18
 */
public class User {
   private String  msg;
    private  String   code;
      ArrayList<Users> data;

    public User(String msg, String code, ArrayList<Users> data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public User() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Users> getData() {
        return data;
    }

    public void setData(ArrayList<Users> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
