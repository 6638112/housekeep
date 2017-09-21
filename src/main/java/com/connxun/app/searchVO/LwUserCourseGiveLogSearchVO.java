package com.connxun.app.searchVO;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-29 12:45
 * @Comments：课程赠课
 */
public class LwUserCourseGiveLogSearchVO extends CommonSearchVO{

    private String reason;
    private String courseName;

    private String phone;

    public String getPhone() {
        return phone;
    }
    public String getPhoneParam() {
        return "%"+phone+"%";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReason() {
        return reason;
    }
    public String getReasonParam() {
        return "%"+reason+"%";
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCourseName() {
        return courseName;
    }
    public String getCourseNameParam() {
        return "%"+courseName+"%";
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
