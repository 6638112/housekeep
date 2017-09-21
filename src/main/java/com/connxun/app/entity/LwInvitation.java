package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 邀請
 * Created by chengpeng on 2017/7/7.
 */
@Entity
@Table(name = "lw_invitation")
public class LwInvitation  implements Serializable {

    private static final long serialVersionUID = -4210504239446492812L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //注册规则人数
    private Integer userNum;
    //     已经邀请人数
    @Transient
    private Integer isNum;
    @Transient
    private Integer noNum;

    private Integer courseNo;
    //0 课程  1 套餐
    private Integer courseType;
    //    注册邀请的图片url;
    private Integer url;

    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Column(updatable = false)
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date updateDate;
    @Column(updatable = false)
    private Integer createUser;
    private Integer updateUser;
    //0 启用 1 停用
    private Integer state;
    @Transient
    private String courseName;

    //活动图片
    private String actPhoto;
    //活动介绍
    private String actIntroduce;
    //分享模板图片
    private String sharePhoto;
    /**
     * 新增时执行的函数
     */
    @PrePersist
    void preInsert() {
        if (updateDate == null) {
            updateDate = new Date();
        }
        if (createDate == null) {
            createDate = new Date();
        }
    }

    /**
     * 修改时执行的函数
     */
    @PreUpdate
    void preUpdate() {
        if (updateDate == null) {
            updateDate = new Date();
        }
    }


    public String getActPhoto() {
        return actPhoto;
    }

    public void setActPhoto(String actPhoto) {
        this.actPhoto = actPhoto;
    }

    public String getActIntroduce() {
        return actIntroduce;
    }

    public void setActIntroduce(String actIntroduce) {
        this.actIntroduce = actIntroduce;
    }

    public String getSharePhoto() {
        return sharePhoto;
    }

    public void setSharePhoto(String sharePhoto) {
        this.sharePhoto = sharePhoto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUrl() {
        return url;
    }

    public void setUrl(Integer url) {
        this.url = url;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getIsNum() {
        return isNum;
    }

    public void setIsNum(Integer isNum) {
        this.isNum = isNum;
    }

    public Integer getNoNum() {
        return noNum;
    }

    public void setNoNum(Integer noNum) {
        this.noNum = noNum;
    }
}
