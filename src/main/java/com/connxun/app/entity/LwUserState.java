package com.connxun.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/*最新动态*/
@Entity
@Table(name = "lw_user_state")
public class LwUserState implements Serializable {
    private static final long serialVersionUID = -185455816993723950L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userIcon;
    private String userPhone;
    private String courseName;
    //    0 刚刚购买  1 五星
    private Integer state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
