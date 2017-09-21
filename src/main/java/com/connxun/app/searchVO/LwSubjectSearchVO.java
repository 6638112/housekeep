package com.connxun.app.searchVO;

/**
 * Created by Mac on 2017/7/5.
 */
public class LwSubjectSearchVO extends CommonSearchVO {
    private String subject;
    private Integer type;
    /*1
    * 考区要有手动排序，考区在前端显示（接口），按手动输入序号由小到大排列，序号越小，越展现在前面
    * */
    private Integer dataSort=0;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDataSort() {
        return dataSort;
    }

    public void setDataSort(Integer dataSort) {
        this.dataSort = dataSort;
    }
}
