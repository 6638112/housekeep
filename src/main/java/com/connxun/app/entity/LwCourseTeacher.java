package com.connxun.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 1553280431@qq.com on 2017/7/14.
 * 老师 课程 关联表
 */
@Entity
@Table(name = "lw_course_teacher")
public class LwCourseTeacher implements Serializable {
    private static final long serialVersionUID = -7855872486552963412L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*id*/
    private Integer id;
    /*课程ID*/
    private Integer courseId;
    /*老师id*/
    private Integer teacherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
