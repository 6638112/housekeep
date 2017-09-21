package com.connxun.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-20 14:19
 * @Comments：代金券课程
 */
@Entity
@Table(name = "lw_voucher_course")
public class LwVoucherCourse implements Serializable {
    private static final long serialVersionUID = 1259018759690672412L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //代金券ID
    private Integer voucherId;
    //课程ID
    private Integer courseNo;

    @Transient
    private String courseName;
    @Transient
    private String courseType;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
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

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
}
