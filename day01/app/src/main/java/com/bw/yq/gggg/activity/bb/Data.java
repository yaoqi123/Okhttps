package com.bw.yq.gggg.activity.bb;

import java.util.ArrayList;

/**
 * @author yaoqi
 * @fileName Data
 * @package com.bw.yq.gggg.activity.bb
 * @date 2019/2/13 21:05
 */
public class Data {
      Datas  result;
      private   String message;
     private String   status;


    public Data(Datas result, String message, String status) {
        this.result = result;
        this.message = message;
        this.status = status;
    }

    public Data() {
    }

    public Datas getResult() {
        return result;
    }

    public void setResult(Datas result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Data{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
