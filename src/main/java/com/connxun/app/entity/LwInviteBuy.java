package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-19 10:23
 * @Comments：购课邀请活动
 */
@Entity
@Table(name = "lw_invite_buy")
public class LwInviteBuy implements Serializable {

    private static final long serialVersionUID = -7371560101641829447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //活动名称
    private String actName;
    //课程编号
    private Integer courseNo;
    //条件
    private Integer cond;
    //活动开始时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date beginDate;
    //活动结束时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date stopDate;
    //活动状态  0 未发布 1 进行中 2 已过期
    private Integer state;
    //分享模板图片
    private String sharePhoto;

    //创建者
    @Column(updatable = false)
    private Integer createUser;
    //创建时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Column(updatable = false)
    private Date createDate;
    //更新者
    private Integer updateUser;
    //更新时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date updateDate;
    //说明
    private String remarks;
    //删除标记
    private String del_flag;
    //     课时  套餐的中的几门课
    @Transient
    private String classHour;
    //课程名称
    @Transient
    private String courseName;
    //课程 最终金额
    @Transient
    private BigDecimal finalAmount;
    @Transient
    private String courseIcon;
    //参加活动人数
    @Transient
    private String effectNum;
    //达标人数
    @Transient
    private String reachNum;
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
        if (del_flag==null){
            del_flag="0";
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
        if (del_flag==null){
            del_flag="0";
        }
    }

    public String getEffectNum() {
        return effectNum;
    }

    public void setEffectNum(String effectNum) {
        this.effectNum = effectNum;
    }

    public String getReachNum() {
        return reachNum;
    }

    public void setReachNum(String reachNum) {
        this.reachNum = reachNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public Integer getCond() {
        return cond;
    }

    public void setCond(Integer cond) {
        this.cond = cond;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSharePhoto() {
        return sharePhoto;
    }

    public void setSharePhoto(String sharePhoto) {
        this.sharePhoto = sharePhoto;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseIcon() {
        return courseIcon;
    }

    public void setCourseIcon(String courseIcon) {
        this.courseIcon = courseIcon;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getClassHour() {
        return classHour;
    }

    public void setClassHour(String classHour) {
        this.classHour = classHour;
    }
}
