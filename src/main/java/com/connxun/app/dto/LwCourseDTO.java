package com.connxun.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by zosoft-java on 2017/7/25.
 */
public class LwCourseDTO implements Serializable {

    private static final long serialVersionUID = 4989612385970232537L;
    private Integer id;

    //课程名称
    private String name;

    //课程 最终金额
    @JsonFormat(pattern = "##.00")
    private BigDecimal finalAmount;
    // 封面
    private String icon;
    //营销人数
    private Integer enrollment;
    //分类 0 课程 1套餐
    private Integer courseType;
    //活动开始时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date beginDate;
    //活动结束时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date stopDate;

    //课程类型 0 直播 1 录播  2 面授
    private Integer type;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    //最后观看时间
    private Date viewEndDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    //停售时间
    private Date noSaleDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    //开课时间
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    // 结课时间
    private Date endDate;
    // 状态 0：未上架 1：销售中 2：已停售 3：已下架
    private Integer state;
    /*0正常   1 属于抢购状态*/
    private Integer status = 0;


    //    是否邮寄   0 否  1 是   默认0
    private Integer isSend;
    //     邮寄资料
    private String sendData;
    //     课时  套餐的中的几门课
    private String classHour;
    //代金券状态 0 未使用 1 已使用 2 已作废
    private  Integer userVoucherState;
    private  Integer userVoucherId;

    private List<LwTeacherDTO> lwTeacherDTOS;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date sysDate;

    public Date getSysDate() {
        return new Date();
    }

    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getViewEndDate() {
        return viewEndDate;
    }

    public void setViewEndDate(Date viewEndDate) {
        this.viewEndDate = viewEndDate;
    }

    public Date getNoSaleDate() {
        return noSaleDate;
    }

    public void setNoSaleDate(Date noSaleDate) {
        this.noSaleDate = noSaleDate;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public String getSendData() {
        return sendData;
    }

    public void setSendData(String sendData) {
        this.sendData = sendData;
    }

    public String getClassHour() {
        return classHour;
    }

    public void setClassHour(String classHour) {
        this.classHour = classHour;
    }

    public List<LwTeacherDTO> getLwTeacherDTOS() {
        return lwTeacherDTOS;
    }

    public void setLwTeacherDTOS(List<LwTeacherDTO> lwTeacherDTOS) {
        this.lwTeacherDTOS = lwTeacherDTOS;
    }

    public Integer getUserVoucherState() {
        return userVoucherState;
    }

    public void setUserVoucherState(Integer userVoucherState) {
        this.userVoucherState = userVoucherState;
    }

    public Integer getUserVoucherId() {
        return userVoucherId;
    }

    public void setUserVoucherId(Integer userVoucherId) {
        this.userVoucherId = userVoucherId;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
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
}
