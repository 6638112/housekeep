package com.connxun.app.dto;

import java.io.Serializable;

/**
 * Created by zosoft-java on 2017/7/26.
 */
public class LwStartupDTO  implements Serializable {
    private static final long serialVersionUID = -8399469945198653229L;
    private String imgUrl;
    //    链接
    private String url;
    private Integer voucherNo;
    //    课程ID
    private Integer courseNo;
    private String courseName;
    private Integer sort;
    //    0 课程   1 优惠   2 其他
    private Integer type;
    //    链接
    private String appurl;
    //分类 0 课程 1套餐
    private Integer courseType;
    //课程类型 0 直播 1 录播  2 面授
    private Integer classType;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(Integer voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAppurl() {
        return appurl;
    }

    public void setAppurl(String appurl) {
        this.appurl = appurl;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }
}
