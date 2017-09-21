package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 课程章节
 * Created by ChengPeng on 2017/7/7.
 */
@Entity
@Table(name = "lw_course_chapter")
public class LwCourseChapter implements Serializable {


    private static final long serialVersionUID = -7433203934009371065L;
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer courseId;
    private String title;
    //课程类型 0 直播 1 录播  2 面授
    @Transient
    private Integer classType;
    //  0普通章节  1 试听章节 默认0
    private Integer chapterType = 0;
    //0:视频课 1:音频课
    private Integer mediaType = 0;
    //    1:一对一课 2:班课
    private Integer type = 2;
    /*开始时间*/
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date startDate;
    /*结束时间*/
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date endDate;
    //    房间最大人数  0 为最大
    private Integer maxUsers;
    // URL
    private String url;
    private Integer sort;
    // 时长
    private String timeLength;
    //     学生吗
    private String studentCode;
    //    管理员码
    private String adminCode;
    //    老师码
    private String teacherCode;
    //课程 最终金额
    @Transient
    private BigDecimal finalAmount;
    //    房间id
    private String roomId;
    //    提前 进入多少秒
    private Integer preEnterTime = 3600;
    //    学生发言时是否自动开启摄像头 1:开启 2:不开启 默认会开启
    private Integer speakCameraTurnon = 1;
    //    老师是否启用设备检测 1:启用 2:不启用 默认启用
    private Integer teacherNeedDetectDevice = 1;
    //    学生是否启用设备检测 1:启用 2:不启用 默认启用
    private Integer studentNeedDetectDevice = 1;

    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Column(updatable = false)
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date updateDate;
    @Column(updatable = false)
    private Integer createUser;
    private Integer updateUser;

    @Transient
    private String courseName;
    @Transient
    private String createUserName;
    /*修改人名字*/
    @Transient
    private String updateUserName;
/*一个小时之前   0 即将开始
* 一个小时之内开 1 进入教师
* 老师下课     2 正在转码
* url 不为空    3观看回放
*              4 免费
* */
    @Transient
    private  Integer chapterStatus;
    private int state = 0;

    /**
     * 新增时执行的函数
     */
    @PrePersist
    void preInsert() {
        if (updateDate == null) {
            updateDate = new Date();
        }
        if (createDate == null) {
            createDate = new Date();
        }
    }

    /**
     * 修改时执行的函数
     */
    @PreUpdate
    void preUpdate() {
        if (updateDate == null) {
            updateDate = new Date();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getMediaType() {
        return mediaType;
    }

    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(String timeLength) {
        this.timeLength = timeLength;
    }

    public Integer getChapterType() {
        return chapterType;
    }

    public void setChapterType(Integer chapterType) {
        this.chapterType = chapterType;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getPreEnterTime() {
        return preEnterTime;
    }

    public void setPreEnterTime(Integer preEnterTime) {
        this.preEnterTime = preEnterTime;
    }

    public Integer getSpeakCameraTurnon() {
        return speakCameraTurnon;
    }

    public void setSpeakCameraTurnon(Integer speakCameraTurnon) {
        this.speakCameraTurnon = speakCameraTurnon;
    }

    public Integer getTeacherNeedDetectDevice() {
        return teacherNeedDetectDevice;
    }

    public void setTeacherNeedDetectDevice(Integer teacherNeedDetectDevice) {
        this.teacherNeedDetectDevice = teacherNeedDetectDevice;
    }

    public Integer getStudentNeedDetectDevice() {
        return studentNeedDetectDevice;
    }

    public void setStudentNeedDetectDevice(Integer studentNeedDetectDevice) {
        this.studentNeedDetectDevice = studentNeedDetectDevice;
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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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


    public Integer getChapterStatus() {
        return chapterStatus;
    }

    public void setChapterStatus(Integer chapterStatus) {
        this.chapterStatus = chapterStatus;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }
}
