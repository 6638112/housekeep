package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by ChengPeng on 2017/7/7.
 */
@Entity
@Table(name = "lw_user_course")
public class LwUserCourse implements Serializable{

    private static final long serialVersionUID = 2451129710505846364L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer userNo;
    //课程类型 0 直播 1 录播  2 面授
    @Transient
    private Integer classType;
    private Integer courseNo;
    //分类 0 课程 1套餐
    private Integer courseType;
    //    用户的课程  0 为未评价 1 评价
    private Integer review = 0;
    //0  用户购买的课程          1 用户收藏的课程
    private Integer type;
    //支付金额   订单的
    private BigDecimal finalAmount;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Column(updatable = false)
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date updateDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Transient
    private Date noSaleDate;
    @Column(updatable = false)
    private Integer createUser;
    private Integer updateUser;
    @Transient
    private String courseName;
    @Transient
    private String name;
    @Transient
    private String content;

    //     课程图片
    @Transient
    private String icon;
    @Transient
    private String userIcon;
    @Transient
    private String userPhone;
    @Transient
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date startDate;


    @Transient
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date endDate;
    //     老师的名称  集合
    @Transient
    private List<LwTeacher> teacherList;
    //  课时
    @Transient
    private String classHour;

    // 学习人数
    @Transient
    private Integer enrollment;
    //最后观看时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Transient
    private Date viewEndDate;

    private Integer state = 0;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<LwTeacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<LwTeacher> teacherList) {
        this.teacherList = teacherList;
    }

    public String getClassHour() {
        return classHour;
    }

    public void setClassHour(String classHour) {
        this.classHour = classHour;
    }

    public Integer getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Date getViewEndDate() {
        return viewEndDate;
    }

    public void setViewEndDate(Date viewEndDate) {
        this.viewEndDate = viewEndDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNoSaleDate() {
        return noSaleDate;
    }

    public void setNoSaleDate(Date noSaleDate) {
        this.noSaleDate = noSaleDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }
}
