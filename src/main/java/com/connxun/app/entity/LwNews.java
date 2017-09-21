package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-29 17:48
 * @Comments：消息实体类
 */
@Entity
@Table(name = "lw_news")
public class LwNews  implements Serializable {
    private static final long serialVersionUID = -8567159216195064868L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //icon
    private Integer iconId;
    //标题
    private String header;
    //内容
    private String contents;
    //状态 0 未审核 1 已发送
    private Integer state;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
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
}
