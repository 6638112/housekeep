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
 * 交易流水记录表
 */
@Entity
@Table(name = "lw_tradingrecord")
public class LwTradingrecord implements Serializable {
    private static final long serialVersionUID = 9132804340728356549L;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    //支付流水号
    private String serialNumber;
    //订单号
    private String orderNumber;
    //订单总额
    @Column(updatable = false)
    private BigDecimal amount;
    //实际金额
    private BigDecimal actualAmount;
    //交易金额
    private BigDecimal tradeAmount;
    //退款金额
    private BigDecimal refundAmount;
    //外部交易流水号
    private String externSerialNumber;
    //交易平台（1：网银；2：支付宝 3:微信  4：积分）
    private Integer platform;
    //状态（0：已创建未支付；1：支付中待确认；2：支付成功；100：已关闭）
    private Integer status;
    //备注
    private String remark;
    //创建时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    //支付时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date payDate;
    //完成交易时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date finishDate;
    //支付人id
    private Integer payId;
    //支付人姓名
    private String payerName;
    //使用积分
    private Integer credits;

    /**
     * 新增时执行的函数
     */
    @PrePersist
    void preInsert() {
        if (createDate == null) {
            createDate = new Date();
        }
    }
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    public BigDecimal getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(BigDecimal tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getExternSerialNumber() {
        return externSerialNumber;
    }

    public void setExternSerialNumber(String externSerialNumber) {
        this.externSerialNumber = externSerialNumber;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
