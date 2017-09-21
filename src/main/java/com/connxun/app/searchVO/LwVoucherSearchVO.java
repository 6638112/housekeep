package com.connxun.app.searchVO;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-20 15:51
 * @Comments：
 */
public class LwVoucherSearchVO extends CommonSearchVO {
    private int id;
    private String Name;
    private String prefix;
    private Integer type;
    private Integer state;
    private Integer userNo;
    private Integer isApp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public String getNameParam() {
        return "%" + Name + "%";

    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrefix() {
        return prefix;
    }


    public String getPrefixParam() {
        return "%" + prefix + "%";
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public Integer getIsApp() {
        return isApp;
    }

    public void setIsApp(Integer isApp) {
        this.isApp = isApp;
    }
}
