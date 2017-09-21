package com.connxun.app.searchVO;

/**
 * Created by xiaoxiao on 2017/7/18.
 * 评价
 */
public class LwReviewSearchVO extends CommonSearchVO {


    /*评论内容*/
    private String reviewContent;
    private String name;
    private boolean isApp;
    private Integer reviewNo;
    private Integer courseNo;
    private Integer userNo;
    private Integer teacherNo;
//    时间排序 0 否
    private Integer datesort=0;
    /*星级评价*/
    private Integer starReview;
    /*手机号*/
    private String phone;
    /*课程名*/
    private String courseName;
    /*关键字*/
    private String keyword;

    public String getKeyword() {
        return keyword;
    }
    public String getKeywordParam() {
        return "%"+keyword+"%";
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCourseName() {
        return courseName;
    }
    public String getCourseNameParam() {
        return "%"+courseName+"%";
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPhone() {
        return phone;
    }
    public String getPhoneParam() {
        return "%"+phone+"%";
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }


    public String getNameParam() {
        return "%" + name + "%";
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isApp() {
        return isApp;
    }

    public void setApp(boolean app) {
        isApp = app;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public Integer getStarReview() {
        return starReview;
    }

    public void setStarReview(Integer starReview) {
        this.starReview = starReview;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Integer getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(Integer reviewNo) {
        this.reviewNo = reviewNo;
    }

    public Integer getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(Integer teacherNo) {
        this.teacherNo = teacherNo;
    }

    public Integer getDatesort() {
        return datesort;
    }

    public void setDatesort(Integer datesort) {
        this.datesort = datesort;
    }


}
