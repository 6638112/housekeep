package com.connxun.app.dto;

import java.io.Serializable;

/**
 * 学员最新的动态
 * Created by zosoft-java on 2017/7/31.
 */
public class NewStateDTO implements Serializable {

    private static final long serialVersionUID = -1480310559124117921L;
    private String userIcon;
    private String userPhone;
    private String courseName;
    //    0 刚刚购买  1 五星
    private Integer state;

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
