package com.connxun.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zosoft-java on 2017/7/27.
 */
public class LwVoucherDTO implements Serializable {
    private static final long serialVersionUID = 3696114926834727266L;
    private Integer id;
    //代金券名称
    private String name;
    //代金券前缀
    private String prefix;
    //代金券面值
    private BigDecimal denomination;
    //代金券数量
    private Integer count;
    // 剩余数量
    private Integer surplus;
    //代金券code
    private String code;

    //代金券开始时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date beginDate;
    //代金券结束时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date stopDate;

    //代金券类型 0 不限时申领 1 限时申领
    private Integer type;

    //限时申领开始时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date applyBeginDate;
    //限时申领结束时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date applyStopDate;

    //代金券状态  0 未发布 1 已发布  2 已作废
    private Integer state;

    //分享模板图片
    private String actPhoto;
    //分享模板图片
    private String sharePhoto;
    //    用户代金券的状太
    private Integer userVoucherState;
    private Integer userVoucherId;
    //    课程的名称
    private String courseName;
    //活动介绍
    private String remarks;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date sysDate;

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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public BigDecimal getDenomination() {
        return denomination;
    }

    public void setDenomination(BigDecimal denomination) {
        this.denomination = denomination;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getApplyBeginDate() {
        return applyBeginDate;
    }

    public void setApplyBeginDate(Date applyBeginDate) {
        this.applyBeginDate = applyBeginDate;
    }

    public Date getApplyStopDate() {
        return applyStopDate;
    }

    public void setApplyStopDate(Date applyStopDate) {
        this.applyStopDate = applyStopDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getActPhoto() {
        return actPhoto;
    }

    public void setActPhoto(String actPhoto) {
        this.actPhoto = actPhoto;
    }

    public String getSharePhoto() {
        return sharePhoto;
    }

    public void setSharePhoto(String sharePhoto) {
        this.sharePhoto = sharePhoto;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSurplus() {
        return surplus;
    }

    public void setSurplus(Integer surplus) {
        this.surplus = surplus;
    }

    public Date getSysDate() {
        return new Date();
    }

    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }
}
