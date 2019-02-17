package com.bw.yq.gggg.activity.bb;

/**
 * @author yaoqi
 * @fileName Datas
 * @package com.bw.yq.gggg.activity.bb
 * @date 2019/2/13 21:01
 */
public class Datas {
 private String   headPic;
    private String nickName;
    private String   phone;
    private String   sessionId;
    private String    sex;
    private String    userId;

    public Datas(String headPic, String nickName, String phone, String sessionId, String sex, String userId) {
        this.headPic = headPic;
        this.nickName = nickName;
        this.phone = phone;
        this.sessionId = sessionId;
        this.sex = sex;
        this.userId = userId;
    }

    public Datas() {
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Datas{" +
                "headPic='" + headPic + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", sex='" + sex + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
