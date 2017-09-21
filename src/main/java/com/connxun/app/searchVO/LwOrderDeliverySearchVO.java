package com.connxun.app.searchVO;

/**
 * @Author：luoxiaosheng
 * @Date：2017-08-03 11:11
 * @Comments：
 */
public class LwOrderDeliverySearchVO  extends CommonSearchVO {

    //内部编号
    private String orderNo="";
    //手机号
    private String phone="";
    //用户名称
    private String userName="";
    //商品名称
    private String goodsName="";
    //订单状态    0：已创建待付款 1：已付款待发货  2：已发货
    private String status="";
    //订单类型   1：课程
    private String type="";


    public String getOrderNo() {
        return orderNo;
    }
    public String getOrderNoParam() {
        return "%"+orderNo+"%";
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPhone() {
        return phone;
    }
    public String getPhoneParam() {
        return "%"+phone+"%";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }
    public String getUserNameParam() {
        return "%"+userName+"%";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsName() {
        return goodsName;
    }
    public String getGoodsNameParam() {
        return "%"+goodsName+"%";
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
