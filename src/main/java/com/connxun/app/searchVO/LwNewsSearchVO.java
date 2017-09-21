package com.connxun.app.searchVO;

/**
 * Created by anna on 2017-07-29.
 */
public class LwNewsSearchVO extends CommonSearchVO {

    private String header;
    private Integer state;

    public String getHeader() {
        return header;
    }
    public String getHeaderParam() {
        return "%"+header+"%";
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
