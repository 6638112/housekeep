package com.connxun.app.searchVO;


/**
 * @Author：luoxiaosheng
 * @Date：2017-07-20 16:08
 * @Comments：
 */
public class LwVoucherLogSearchVO extends CommonSearchVO {

    private int id;
    private String voucherId;
    private String code;
    private String telephone;
    private String state;
    private Integer userNo;
    private Integer isApp;
    //用户代金券状态 0 显示  未使用
    private Integer datasort;
    //    代金券id
    private Integer voucherNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public String getCodeParam() {
        return "%" + code + "%";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTelephoneParam() {
        return "%" + telephone + "%";
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStateParam() {
        return "%" + state + "%";
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public Integer getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(Integer voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Integer getIsApp() {
        return isApp;
    }

    public void setIsApp(Integer isApp) {
        this.isApp = isApp;
    }

    public Integer getDatasort() {
        return datasort;
    }

    public void setDatasort(Integer datasort) {
        this.datasort = datasort;
    }
}
