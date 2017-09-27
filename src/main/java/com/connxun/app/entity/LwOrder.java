package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xiaoxiao on 2017/7/19.
 * 订单表
 */
@Entity
@Table(name = "lw_order")
public class LwOrder implements Serializable {

    private static final long serialVersionUID = 7319804363237070084L;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    //订单编号
    private String orderNumber;
    //  展示单号
    private String orderShow;
    //学生编号
    private Integer userNo;
    //学生名称
    private String userName;
    //外部编号
    private String externalNo;
    //商品名称
    private String goodsName;
    //订单金额
    private BigDecimal orderAmount;
    //邮费
    private BigDecimal freight;
    //是否使用积分
    private Integer isIntegral;
    //积分数量
    private Integer integralValue;
    //是否使用代金卷
    private Integer isVouchers;
    //代金卷编号
    @Transient
    private Integer vouchersId;
    //代金卷抵消金额
    private BigDecimal vouchersValue;
    //成交金额
    private BigDecimal finalAmount;
    //备注
    private String remark;
    //发货单号
    private String deliveryNumber;
    //发货公司
    private String deliveryCompany;
    //地址编号
    @Transient
    private Integer addressNo;
    //省
    private String province;
    //市
    private String city;
    //地址
    private String address;
    //邮编
    private String zipCode;
    //手机号
    private String phone;

    //     收货人
    private String consignee;
    //订单类型   1：课程
    private Integer type;
    //订单状态    0：已创建待付款    2：已发货  3 取消订单
    private Integer status;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Column(updatable = false)
    //创建时间
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    //付款时间
    private Date payDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    //发货时间
    private Date deliveryDate;
    /*导入行号*/
    @Transient
    private int row_index;
    /* 0 正常  1删除*/
    private int del_flag;


    /**
     * 新增时执行的函数er
     */
    @PrePersist
    void preInsert() {
        if (createDate == null) {
            createDate = new Date();
        }
    }

    public int getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

    public int getRow_index() {
        return row_index;
    }

    public void setRow_index(int row_index) {
        this.row_index = row_index;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderShow() {
        return orderShow;
    }

    public void setOrderShow(String orderShow) {
        this.orderShow = orderShow;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExternalNo() {
        return externalNo;
    }

    public void setExternalNo(String externalNo) {
        this.externalNo = externalNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public Integer getIsIntegral() {
        return isIntegral;
    }

    public void setIsIntegral(Integer isIntegral) {
        this.isIntegral = isIntegral;
    }

    public Integer getIntegralValue() {
        return integralValue;
    }

    public void setIntegralValue(Integer integralValue) {
        this.integralValue = integralValue;
    }

    public Integer getIsVouchers() {
        return isVouchers;
    }

    public void setIsVouchers(Integer isVouchers) {
        this.isVouchers = isVouchers;
    }

    public BigDecimal getVouchersValue() {
        return vouchersValue;
    }

    public void setVouchersValue(BigDecimal vouchersValue) {
        this.vouchersValue = vouchersValue;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(Integer addressNo) {
        this.addressNo = addressNo;
    }

    public Integer getVouchersId() {
        return vouchersId;
    }

    public void setVouchersId(Integer vouchersId) {
        this.vouchersId = vouchersId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    @Override
    public String toString() {
        return "LwOrder{" +
                "orderNumber='" + orderNumber + '\'' +
                ", orderShow='" + orderShow + '\'' +
                ", userNo=" + userNo +
                ", goodsName='" + goodsName + '\'' +
                ", orderAmount=" + orderAmount +
                ", isIntegral=" + isIntegral +
                ", integralValue=" + integralValue +
                ", isVouchers=" + isVouchers +
                ", vouchersId=" + vouchersId +
                ", vouchersValue=" + vouchersValue +
                ", finalAmount=" + finalAmount +

                ", del_flag=" + del_flag +
                '}';
    }
}
