package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-19 10:23
 * @Comments：代金券
 */
@Entity
@Table(name = "lw_voucher")
@NamedStoredProcedureQueries({
        //name是JPA中的存储过程的名字, procedureName是数据库存储过程的名字
        @NamedStoredProcedureQuery(name = "proc_voucher_deleteById", procedureName = "proc_voucher_deleteById", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class)
        }),
        @NamedStoredProcedureQuery(name = "in_and_out_test", procedureName = "test_pkg.in_and_out_test", parameters = {
//                @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
//                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam1", type = String.class)
        })
})
public class LwVoucher  implements Serializable {

    private static final long serialVersionUID = 2408279040452070965L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //代金券名称
    private String name;
    //代金券前缀
    private String prefix;
    //代金券面值
    private BigDecimal denomination;
    //代金券数量
    private Integer count;
    //代金券剩余数量
    private Integer number;

    //代金券开始时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date beginDate;
    //代金券结束时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date stopDate;

    //代金券类型 0 非营销申领 1 不限时申领 2限时申领
    private Integer type;

    //限时申领开始时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date applyBeginDate;
    //限时申领结束时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date applyStopDate;

    //代金券状态  0 未发布 1 已发布  2 已作废
    private Integer state;
    @Transient
    private Integer userVoucherState;
    @Transient
    private Integer userVoucherId;

    //活动图片
    private String actPhoto;
    //分享模板图片
    private String sharePhoto;

    //创建者
    @Column(updatable = false)
    private Integer createUser;
    //创建时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    private Date createDate;
    //更新者
    private Integer updateUser;
    //更新时间
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm", timezone = "GMT+8")
    @Column(updatable = false)
    private Date updateDate;
    //活动介绍
    private String remarks;
    //删除标记
    private String del_flag;
    //全站标识  0 非全站 1 全站
    private Integer wholesite;

    //代金券已领取人数
    @Transient
    private String receive;
    //代金券已使用人数
    @Transient
    private String used;
    //课程名称
    @Transient
    private String courseName;
    //课程列表
    @Transient
    private List<LwCourse> lwCourseList;
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
        if (del_flag==null){
            del_flag="0";
        }
        if (wholesite==null){
            wholesite=0;
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
        if (del_flag==null){
            del_flag="0";
        }
        if (wholesite==null){
            wholesite=0;
        }
    }

    public Integer getWholesite() {
        return wholesite;
    }

    public void setWholesite(Integer wholesite) {
        this.wholesite = wholesite;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<LwCourse> getLwCourseList() {
        return lwCourseList;
    }

    public void setLwCourseList(List<LwCourse> lwCourseList) {
        this.lwCourseList = lwCourseList;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public BigDecimal getDenomination() {
        return denomination;
    }

    public void setDenomination(BigDecimal denomination) {
        this.denomination = denomination;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getApplyBeginDate() {
        return applyBeginDate;
    }

    public void setApplyBeginDate(Date applyBeginDate) {
        this.applyBeginDate = applyBeginDate;
    }

    public Date getApplyStopDate() {
        return applyStopDate;
    }

    public void setApplyStopDate(Date applyStopDate) {
        this.applyStopDate = applyStopDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getActPhoto() {
        return actPhoto;
    }

    public void setActPhoto(String actPhoto) {
        this.actPhoto = actPhoto;
    }

    public String getSharePhoto() {
        return sharePhoto;
    }

    public void setSharePhoto(String sharePhoto) {
        this.sharePhoto = sharePhoto;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getUserVoucherState() {
        return userVoucherState;
    }

    public void setUserVoucherState(Integer userVoucherState) {
        this.userVoucherState = userVoucherState;
    }

    public Integer getUserVoucherId() {
        return userVoucherId;
    }

    public void setUserVoucherId(Integer userVoucherId) {
        this.userVoucherId = userVoucherId;
    }


    @Override
    public String toString() {
        return "LwVoucher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", denomination=" + denomination +
                ", count=" + count +
                ", number=" + number +
                ", beginDate=" + beginDate +
                ", stopDate=" + stopDate +
                ", type=" + type +
                ", applyBeginDate=" + applyBeginDate +
                ", applyStopDate=" + applyStopDate +
                ", state=" + state +
                ", userVoucherState=" + userVoucherState +
                ", userVoucherId=" + userVoucherId +
                ", actPhoto='" + actPhoto + '\'' +
                ", sharePhoto='" + sharePhoto + '\'' +
                ", createUser=" + createUser +
                ", createDate=" + createDate +
                ", updateUser=" + updateUser +
                ", updateDate=" + updateDate +
                ", remarks='" + remarks + '\'' +
                ", del_flag='" + del_flag + '\'' +
                ", wholesite=" + wholesite +
                ", receive='" + receive + '\'' +
                ", used='" + used + '\'' +
                ", courseName='" + courseName + '\'' +
                ", lwCourseList=" + lwCourseList +
                '}';
    }
}
