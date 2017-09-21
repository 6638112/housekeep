package com.connxun.app.searchVO;

/**
 * 用户查询Vo
 * Created by Mac on 2017/7/7.
 */
public class LwCourseHatSearchVO extends CommonSearchVO {


    private Integer courseNo;

    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public String getCourseNameParam() {
        return "%"+courseName+"%";
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }
}
