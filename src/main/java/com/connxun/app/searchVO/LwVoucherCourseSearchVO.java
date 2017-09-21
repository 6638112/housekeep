package com.connxun.app.searchVO;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-20 15:51
 * @Comments：
 */
public class LwVoucherCourseSearchVO extends CommonSearchVO {

    private int id;
    private Integer voucherId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }
}
