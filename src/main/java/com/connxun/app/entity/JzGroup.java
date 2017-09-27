package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-26 10:18
 * @Comments：群组entity
 */
@Entity
@Table(name = "jz_group")
public class JzGroup implements Serializable {

    //内部ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //群组ID
    private String groupId;
    //群组名称
    private String name;
    //群组类型  Private/Public/聊天室ChatRoom/互动直播聊天室AVChatRoom——不允许直接邀请用户加入/在线成员广播大群BChatRoom
    private String type;
    //群简介
    private String introduction;
    //群公告
    private String notification;
    //群组头像
    private String faceUrl;
    //群主ID
    private String owner_Account;
    //群创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    //群组最后一次信息变更时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date lastInfoTime;
    //群组内最后发消息的时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM.dd HH:mm:ss", timezone = "GMT+8")
    private Date lastMsgTime;
    //群内下一条消息的Seq
    private Integer nextMsgSeq;
    //最大群成员数量
    private Integer maxMemberNum;
    //申请加群处理方式  FreeAccess（自由加入），NeedPermission（需要验证），DisableApply（禁止加群）
    private String applyJoinOption;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getOwner_Account() {
        return owner_Account;
    }

    public void setOwner_Account(String owner_Account) {
        this.owner_Account = owner_Account;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastInfoTime() {
        return lastInfoTime;
    }

    public void setLastInfoTime(Date lastInfoTime) {
        this.lastInfoTime = lastInfoTime;
    }

    public Date getLastMsgTime() {
        return lastMsgTime;
    }

    public void setLastMsgTime(Date lastMsgTime) {
        this.lastMsgTime = lastMsgTime;
    }

    public Integer getNextMsgSeq() {
        return nextMsgSeq;
    }

    public void setNextMsgSeq(Integer nextMsgSeq) {
        this.nextMsgSeq = nextMsgSeq;
    }

    public Integer getMaxMemberNum() {
        return maxMemberNum;
    }

    public void setMaxMemberNum(Integer maxMemberNum) {
        this.maxMemberNum = maxMemberNum;
    }

    public String getApplyJoinOption() {
        return applyJoinOption;
    }

    public void setApplyJoinOption(String applyJoinOption) {
        this.applyJoinOption = applyJoinOption;
    }
}
