package com.connxun.app.searchVO;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-20 15:50
 * @Comments：
 */
public class LwInviteBuySearchVO extends CommonSearchVO {
    private Integer id;
    private String actName;
    private String courseName;
    private Integer userNo;
    private boolean isApp;
    private Integer courseNo;
//    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActNameParam() {
        return "%" + actName + "%";
    }


    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getCourseNameParam() {
        return "%" + courseName + "%";
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

//    public Integer getState() {
//        return state;
//    }
//
//    public void setState(Integer state) {
//        this.state = state;
//    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getActName() {
        return actName;
    }

    public String getCourseName() {
        return courseName;
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
}
