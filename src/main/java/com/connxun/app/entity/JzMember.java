package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-27 16:23
 * @Comments：群组成员entity
 */
@Entity
@Table(name = "jz_member")
public class JzMember implements Serializable{

    //内部ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //群成员ID
    private String memberAccount;
    //关联群ID
    private String groupId;

    //群内角色
    private String role;

    //加入时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date joinTime;

    //该成员当前已读消息Seq
    private Integer msgSeq;

    //消息屏蔽选项
    private String msgFlag;

    //最后发言时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastSendMsgTime;

    //禁言截至时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date shutUpUntil;


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Integer getMsgSeq() {
        return msgSeq;
    }

    public void setMsgSeq(Integer msgSeq) {
        this.msgSeq = msgSeq;
    }

    public String getMsgFlag() {
        return msgFlag;
    }

    public void setMsgFlag(String msgFlag) {
        this.msgFlag = msgFlag;
    }

    public Date getLastSendMsgTime() {
        return lastSendMsgTime;
    }

    public void setLastSendMsgTime(Date lastSendMsgTime) {
        this.lastSendMsgTime = lastSendMsgTime;
    }

    public Date getShutUpUntil() {
        return shutUpUntil;
    }

    public void setShutUpUntil(Date shutUpUntil) {
        this.shutUpUntil = shutUpUntil;
    }
}
