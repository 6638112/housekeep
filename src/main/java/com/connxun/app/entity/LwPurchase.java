package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-19 10:23
 * @Comments：课程抢购
 */
@Entity
@Table(name = "lw_purchase")
public class LwPurchase implements Serializable {

    private static final long serialVersionUID = -7321876914081477120L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //抢购名称
    private String name;
    //课程ID
    private Integer courseNo;

    //抢购开始时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date beginDate;
    //抢购结束时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date stopDate;

    //课程金额
    private BigDecimal price;

    //抢购状态  0 未发布 1 已发布  2 已作废
    private Integer state;


    //创建者
    @Column(updatable = false)
    private Integer createUser;
    //创建时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Column(updatable = false)
    private Date createDate;
    //更新者
    private Integer updateUser;
    //更新时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date updateDate;
    //活动介绍
    private String remarks;
    //删除标记
    private String del_flag;

    //已下单人数
    @Transient
    private String receive;
    //成功人数
    @Transient
    private String succeed;
    //课程名称
    @Transient
    private String courseName;

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
        if (del_flag == null) {
            del_flag = "0";
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
        if (del_flag == null) {
            del_flag = "0";
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
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


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getSucceed() {
        return succeed;
    }

    public void setSucceed(String succeed) {
        this.succeed = succeed;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
