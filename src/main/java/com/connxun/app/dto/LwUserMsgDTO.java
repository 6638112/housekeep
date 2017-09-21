package com.connxun.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zosoft-java on 2017/7/28.
 */
public class LwUserMsgDTO implements Serializable {
    private static final long serialVersionUID = 2455845985909241189L;
    private int id;

    private String msg;
    private Integer state;
    private String title;
    private Integer iconNo;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date createDate;
    /*0 课程  1 代金券 2订单列表 3 注册邀请 4我的代金券  5购课邀请     9 不跳*/
    private Integer type;
    /*课程id*/
    private Integer courseNo;
    /*代金券id*/
    private Integer voucherNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIconNo() {

        return iconNo;
    }

    public void setIconNo(Integer iconNo) {
        this.iconNo = iconNo;
    }

    public Date getCreateDate() {

        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public Integer getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(Integer voucherNo) {
        this.voucherNo = voucherNo;
    }
}
