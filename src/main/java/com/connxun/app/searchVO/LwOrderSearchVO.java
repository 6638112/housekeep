package com.connxun.app.searchVO;

/**
 * Created by xiaoxiao on 2017/7/20.
 * 订单
 */
public class LwOrderSearchVO extends CommonSearchVO {
    /*0 手机端查询 关联发货表
    * */
    private int dataSort;
    //订单编号
    private String orderNumber;
    //学生编号
    private Integer userNo;
    //用户名称
    private String userName;
    //外部编号
    private String externalNo;
    //商品名称
    private String goodsName;
    //是否使用积分
    private Integer isIntegral;
    //是否使用代金卷
    private Integer isVouchers;
    //发货单号
    private String deliveryNumber;
    //省
    private String province;
    //市
    private String city;
    //手机号
    private String phone;
    //订单类型   1：课程
    private String type;
    //订单状态    0：已创建待付款 1：已付款待发货  2：已发货
    private String status;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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

    public String getUserNameParam() {
        return "%" + userName + "%";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExternalNo() {
        return externalNo;
    }

    public String getExternalNoParam() {
        return "%" + externalNo + "%";
    }

    public void setExternalNo(String externalNo) {
        this.externalNo = externalNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getGoodsNameParam() {
        return "%" + goodsName + "%";
    }


    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getIsIntegral() {
        return isIntegral;
    }

    public void setIsIntegral(Integer isIntegral) {
        this.isIntegral = isIntegral;
    }

    public Integer getIsVouchers() {
        return isVouchers;
    }

    public void setIsVouchers(Integer isVouchers) {
        this.isVouchers = isVouchers;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
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

    public String getPhone() {
        return phone;
    }

    public String getPhoneParam() {
        return "%" + phone + "%";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDataSort() {
        return dataSort;
    }

    public void setDataSort(int dataSort) {
        this.dataSort = dataSort;
    }
}
