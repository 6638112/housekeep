package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author：luoxiaosheng
 * @Date：2017-08-23 16:31
 * @Comments：
 */
@Entity
@Table(name = "lw_version")
public class LwVersion implements Serializable {
    private static final long serialVersionUID = 2292962510466970208L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //版本编号
    private String versionNo;
    //文件地址
    private String fileAddress;
    //下载次数
    private Integer downloadNo;

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
        if (downloadNo==null){
            downloadNo=0;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public Integer getDownloadNo() {
        return downloadNo;
    }

    public void setDownloadNo(Integer downloadNo) {
        this.downloadNo = downloadNo;
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

    @Override
    public String toString() {
        return "LwVersion{" +
                "id=" + id +
                ", versionNo='" + versionNo + '\'' +
                ", fileAddress='" + fileAddress + '\'' +
                ", downloadNo=" + downloadNo +
                ", createUser=" + createUser +
                ", createDate=" + createDate +
                ", updateUser=" + updateUser +
                ", updateDate=" + updateDate +
                ", remarks='" + remarks + '\'' +
                ", del_flag='" + del_flag + '\'' +
                '}';
    }
}
