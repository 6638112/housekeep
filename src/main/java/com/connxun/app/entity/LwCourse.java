package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by ChengPeng on 2017/7/7.
 * 课程
 */
@Entity
@Table(name = "lw_course")
public class LwCourse implements Serializable{


    private static final long serialVersionUID = 4855392861394240319L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //课程编号
    private Integer courseNo;
    //课程名称
    private String name;
    //课程金额
    @JsonFormat(pattern = "##.00")
    private BigDecimal courseAmount;
    //课程 最终金额
    @JsonFormat(pattern = "##.00")
    private BigDecimal finalAmount;
    // 封面
    private String icon;
    //营销人数
    private Integer enrollment;
    //分类 0 课程 1套餐
    private Integer courseType;
    //真实人数
    private Integer realEnrollment;
    //备注
    private String content;
    //课程类型 0 直播 1 录播  2 面授
    private Integer type;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    //最后观看时间
    private Date viewEndDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    //停售时间
    private Date noSaleDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    //开课时间
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    // 结课时间
    private Date endDate;
    // 状态 0：未上架 1：销售中 2：已停售 3：已下架
    private Integer state;
    /*0正常   1 属于抢购状态*/
    private Integer status = 0;
    /*创建时间*/
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Column(updatable = false)
    private Date createDate;
    /*修改时间*/
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date updateDate;
    /*创建人*/
    @Column(updatable = false)
    private Integer createUser;
    /*创建人名字*/
    @Transient
    private String createUserName;
    /*修改人*/
    private Integer updateUser;
    /*修改人名字*/
    @Transient
    private String updateUserName;
    @Transient
    private List<LwCourseChapter> chapterList;


    //  排序
    private Integer sort;
    //    seo描述
    private String remark;
    //    分享图片
    private String shareUrl;
    //    关键词
    private String keyword;
    //    seo名称
    private String seoName;
    //    是否邮寄   0 否  1 是   默认0
    private Integer isSend;
    //     邮寄资料
    private String sendData;
    //     课时  套餐的中的几门课
    private String classHour;
    /*面授的优惠政策*/
    private String favourable;
    //老师id 数组
    @Transient
    private List<Integer> teacherIds;
    //老师nickName 集合
    @Transient
    private List<String> teacherNickNameList;
    //科目id 数组
    @Transient
    private List<Integer> subjectIds;
    //科目 Name 集合
    @Transient
    private List<String> subjectNameList;
    //科目  集合
    @Transient
    private List<LwSubject> subjectList;
    //科目  集合
    private String lwCourseIds;
    //科目  集合
    @Transient
    private List<LwCourse> lwCourseList;
    @Transient
    private List<LwTeacher> teacherList;
    @Transient
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date sysDate;
    //活动开始时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Transient
    private Date beginDate;
    //活动结束时间
    @Transient
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date stopDate;

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

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCourseAmount() {
        return courseAmount;
    }

    public void setCourseAmount(BigDecimal courseAmount) {
        this.courseAmount = courseAmount;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public Integer getRealEnrollment() {
        return realEnrollment;
    }

    public void setRealEnrollment(Integer realEnrollment) {
        this.realEnrollment = realEnrollment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getViewEndDate() {
        return viewEndDate;
    }

    public void setViewEndDate(Date viewEndDate) {
        this.viewEndDate = viewEndDate;
    }

    public Date getNoSaleDate() {
        return noSaleDate;
    }

    public void setNoSaleDate(Date noSaleDate) {
        this.noSaleDate = noSaleDate;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<LwCourseChapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<LwCourseChapter> chapterList) {
        this.chapterList = chapterList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSeoName() {
        return seoName;
    }

    public void setSeoName(String seoName) {
        this.seoName = seoName;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public String getClassHour() {
        return classHour;
    }

    public void setClassHour(String classHour) {
        this.classHour = classHour;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public List<String> getTeacherNickNameList() {
        return teacherNickNameList;
    }

    public void setTeacherNickNameList(List<String> teacherNickNameList) {
        this.teacherNickNameList = teacherNickNameList;
    }

    public List<Integer> getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(List<Integer> teacherIds) {
        this.teacherIds = teacherIds;
    }

    public List<Integer> getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(List<Integer> subjectIds) {
        this.subjectIds = subjectIds;
    }

    public List<String> getSubjectNameList() {
        return subjectNameList;
    }

    public void setSubjectNameList(List<String> subjectNameList) {
        this.subjectNameList = subjectNameList;
    }

    public List<LwTeacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<LwTeacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<LwSubject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<LwSubject> subjectList) {
        this.subjectList = subjectList;
    }

    public List<LwCourse> getLwCourseList() {
        return lwCourseList;
    }

    public void setLwCourseList(List<LwCourse> lwCourseList) {
        this.lwCourseList = lwCourseList;
    }

    public String getLwCourseIds() {
        return lwCourseIds;
    }

    public void setLwCourseIds(String lwCourseIds) {
        this.lwCourseIds = lwCourseIds;
    }

    public String getSendData() {
        return sendData;
    }

    public void setSendData(String sendData) {
        this.sendData = sendData;
    }

    public Date getSysDate() {
        return new Date();
    }

    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public String getFavourable() {
        return favourable;
    }

    public void setFavourable(String favourable) {
        this.favourable = favourable;
    }
}
