package com.connxun.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 1553280431@qq.com on 2017/7/14.
 * 课程 科目 关联表
 */
@Entity
@Table(name = "lw_course_subject")
public class LwCourseSubject implements Serializable{
    private static final long serialVersionUID = -4355418686651026827L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*id*/
    private Integer id;
    /*课程ID*/
    private Integer courseId;
    /*老师id*/
    private Integer subjectId;


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

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }


}
