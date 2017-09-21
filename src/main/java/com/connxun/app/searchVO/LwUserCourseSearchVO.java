package com.connxun.app.searchVO;


/**
 * 用户的课程
 * Created by Mac on 2017/7/5.
 */
public class LwUserCourseSearchVO extends CommonSearchVO {

    private Integer userNo;
    private Integer courseNo;
    private Integer state;
    private Integer type;
    private String courseName;

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    //    用户的课程  0 为未评价 1 评价
    private  Integer review;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCourseName() {
        return courseName;
    }
    public String getCourseNameParam() {
        return "%" + courseName + "%";
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
