package com.connxun.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zosoft-java on 2017/7/27.
 */
public class LwOrderDTO implements Serializable {

    private static final long serialVersionUID = 7877570610657301706L;
    private  String orderNumber;
    //  展示单号
    private String orderShow;
    //成交金额
    private BigDecimal finalAmount;
    //发货单号
    private String deliveryNumber;
    private LwCourseDTO lwCourseDTO;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    //创建时间
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    //付款时间
    private Date payDate;
    private Integer total;
    //订单状态    0：已创建待付款 1：  2：已发货
    private Integer status;
    //发货公司
    private String deliveryCompany;
    public String getOrderShow() {
        return orderShow;
    }

    public void setOrderShow(String orderShow) {
        this.orderShow = orderShow;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public LwCourseDTO getLwCourseDTO() {
        return lwCourseDTO;
    }

    public void setLwCourseDTO(LwCourseDTO lwCourseDTO) {
        this.lwCourseDTO = lwCourseDTO;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }
}
