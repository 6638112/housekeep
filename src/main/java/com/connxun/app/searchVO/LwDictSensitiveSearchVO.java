package com.connxun.app.searchVO;

/**
 * Created by xiaoxiao on 2017/7/17.
 * 敏感词
 */
public class LwDictSensitiveSearchVO extends CommonSearchVO{
    private String value;

    public String getValue() {
        return value;
    }

    public String getValueParam() {
        return "%" + value + "%";
    }

    public void setValue(String value) {
        this.value = value;
    }
}
