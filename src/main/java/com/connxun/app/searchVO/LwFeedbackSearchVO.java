package com.connxun.app.searchVO;

/**
 * Created by Mac on 2017/7/5.
 */
public class LwFeedbackSearchVO extends CommonSearchVO {

    private String feedback;
    private Integer userNo;
    private  String url;
    private  String phone;

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }


    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
