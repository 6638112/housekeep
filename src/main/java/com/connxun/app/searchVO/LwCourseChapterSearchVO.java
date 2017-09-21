package com.connxun.app.searchVO;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

/**
 * 用户查询Vo
 * Created by Chengpeng on 2017/7/12.
 */
public class LwCourseChapterSearchVO extends CommonSearchVO {


    private Integer id;
    //    判断是否是手机和pc  1 为手机
    private Integer isApp;
    private Integer courseNo;
    private String title;
    private Integer sort;
    private Integer url;
    private String name;
    private String teacherNo;
    private String mediaType;
    private String type;
    private String preEnterTime;
    private String maxUsers;
    private String speakCameraTurnon;
    private String teacherNeedDetectDevice;
    private String studentNeedDetectDevice;
    //课程类型 0 直播 1 录播  2 面授
    private Integer courseType;


    private String courseName;
    //  0普通章节  1 试听章节 默认0
    private Integer chapterType;
    //开始时间
    private Date startDate;
    private Date endDate;


    private String studentCode;

    private String adminCode;

    private String teacherCode;
    //    时间排序 0 否  1是  3 后台排序
    // 4  pc ：sort asc  id asc
    private Integer dateSort = 0;

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    //    观看网址   暂定  根据百家云定义


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    @Column(updatable = false)
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date updateDate;
    @Column(updatable = false)
    private Integer createUser;
    private Integer updateUser;
    private String roomId;

    // 0为普通  1  默认
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getUrl() {
        return url;
    }

    public void setUrl(Integer url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPreEnterTime() {
        return preEnterTime;
    }

    public void setPreEnterTime(String preEnterTime) {
        this.preEnterTime = preEnterTime;
    }

    public String getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(String maxUsers) {
        this.maxUsers = maxUsers;
    }

    public String getSpeakCameraTurnon() {
        return speakCameraTurnon;
    }

    public void setSpeakCameraTurnon(String speakCameraTurnon) {
        this.speakCameraTurnon = speakCameraTurnon;
    }

    public String getTeacherNeedDetectDevice() {
        return teacherNeedDetectDevice;
    }

    public void setTeacherNeedDetectDevice(String teacherNeedDetectDevice) {
        this.teacherNeedDetectDevice = teacherNeedDetectDevice;
    }

    public String getStudentNeedDetectDevice() {
        return studentNeedDetectDevice;
    }

    public void setStudentNeedDetectDevice(String studentNeedDetectDevice) {
        this.studentNeedDetectDevice = studentNeedDetectDevice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsApp() {
        return isApp;
    }

    public void setIsApp(Integer isApp) {
        this.isApp = isApp;
    }

    public Integer getChapterType() {
        return chapterType;
    }

    public void setChapterType(Integer chapterType) {
        this.chapterType = chapterType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNameParam() {
        return "%" + courseName + "%";
    }

    public String getTitleNameParam() {
        return "%" + title + "%";
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getDateSort() {
        return dateSort;
    }

    public void setDateSort(Integer dateSort) {
        this.dateSort = dateSort;
    }
}
