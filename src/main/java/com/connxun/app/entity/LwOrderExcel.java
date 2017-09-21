package com.connxun.app.entity;

import java.io.Serializable;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-28 22:16
 * @Comments：订单导出实体
 */
public class LwOrderExcel implements Serializable {

    private static final long serialVersionUID = 9178294352821960944L;
    //订单编号
    private String orderNumber;
    //发货公司
    private String deliveryCompany;
    //发货单号
    private String deliveryNumber;
    //商品名称
    private String goodsName;
    /*数量*/
    private String num;
    //学生名称
    private String userName;
    //地址
    private String address;
    //手机号
    private String phone;
    /*发件人*/
    private String deliveryer;
    /*发件人电话*/
    private String deliveryPhone;
    /*发件人地址*/
    private String deliveryAddress;
    /*发件人邮编*/
    private String deliveryZipcode;
    /*代收货款*/
    private String deliveryCol;
    //备注
    private String remark;
    //邮编
    private String zipCode;
    /*买家电话*/
    private String telephone;
    /*保价金额*/
    private String supportValue;

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

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeliveryer() {
        return deliveryer;
    }

    public void setDeliveryer(String deliveryer) {
        this.deliveryer = deliveryer;
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryZipcode() {
        return deliveryZipcode;
    }

    public void setDeliveryZipcode(String deliveryZipcode) {
        this.deliveryZipcode = deliveryZipcode;
    }

    public String getDeliveryCol() {
        return deliveryCol;
    }

    public void setDeliveryCol(String deliveryCol) {
        this.deliveryCol = deliveryCol;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSupportValue() {
        return supportValue;
    }

    public void setSupportValue(String supportValue) {
        this.supportValue = supportValue;
    }
}
