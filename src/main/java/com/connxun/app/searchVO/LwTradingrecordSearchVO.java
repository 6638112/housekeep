package com.connxun.app.searchVO;

import java.math.BigDecimal;

/**
 * Created by xiaoxiao on 2017/7/20.
 * 交易流水记录表
 */
public class LwTradingrecordSearchVO extends CommonSearchVO{
    //支付流水号
    private String serialNumber;
    //订单号
    private String orderNumber;
    //支付人姓名
    private String payerName;
    //外部交易流水号
    private String externSerialNumber;
    //状态（0：已创建未支付；1：支付中待确认；2：支付成功；100：已关闭）
    private Integer status;
    //交易金额
    private BigDecimal tradeAmount;


    public String getSerialNumber() {
        return serialNumber;
    }

    public String getSerialNumberParam() {
        return "%" + serialNumber + "%";
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getOrderNumberParam() {
        return "%" + orderNumber + "%";
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPayerName() {
        return payerName;
    }

    public String getPayerNameParam() {
        return "%" + payerName + "%";
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getExternSerialNumber() {
        return externSerialNumber;
    }

    public String getExternSerialNumberParam() {
        return "%" + externSerialNumber + "%";
    }

    public void setExternSerialNumber(String externSerialNumber) {
        this.externSerialNumber = externSerialNumber;
    }

}
