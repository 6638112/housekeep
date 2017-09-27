package com.tls.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-22 17:41
 * @Comments：tlsGroup实体
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsGroupEntity {

    //群组ID
    @JsonProperty("GroupId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String groupId;

    //群组名称
    @JsonProperty("Name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    //群组类型  Private/Public/聊天室ChatRoom/互动直播聊天室AVChatRoom——不允许直接邀请用户加入/在线成员广播大群BChatRoom
    @JsonProperty("Type")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;

    //群简介
    @JsonProperty("Introduction")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String introduction;

    //群公告
    @JsonProperty("Notification")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String notification;

    //群组头像
    @JsonProperty("FaceUrl")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String faceUrl;

    //群主ID
    @JsonProperty("Owner_Account")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String owner_Account;

    //群创建时间
    @JsonProperty("CreateTime")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer createTime;

    //群资料变更次数
    @JsonProperty("InfoSeq")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer infoSeq;

    //群组最后一次信息变更时间
    @JsonProperty("LastInfoTime")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer lastInfoTime;

    //群组内最后发消息的时间
    @JsonProperty("LastMsgTime")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer lastMsgTime;

    //群内下一条消息的Seq
    @JsonProperty("NextMsgSeq")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer nextMsgSeq;

    //最大群成员数量
    @JsonProperty("MaxMemberNum")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer maxMemberNum;

    //申请加群处理方式  FreeAccess
    @JsonProperty("ApplyJoinOption")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String applyJoinOption;


    public void setType(String type) {
        this.type = type;
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

    public String getOwner_Account() {
        return owner_Account;
    }

    public void setOwner_Account(String owner_Account) {
        this.owner_Account = owner_Account;
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

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getInfoSeq() {
        return infoSeq;
    }

    public void setInfoSeq(Integer infoSeq) {
        this.infoSeq = infoSeq;
    }

    public Integer getLastInfoTime() {
        return lastInfoTime;
    }

    public void setLastInfoTime(Integer lastInfoTime) {
        this.lastInfoTime = lastInfoTime;
    }

    public Integer getLastMsgTime() {
        return lastMsgTime;
    }

    public void setLastMsgTime(Integer lastMsgTime) {
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

    @Override
    public String toString() {
        return "TlsGroupEntity{" +
                "groupId='" + groupId + '\'' +
                ", name='" + name + '\'' +
                ", owner_Account='" + owner_Account + '\'' +
                ", type='" + type + '\'' +
                ", introduction='" + introduction + '\'' +
                ", notification='" + notification + '\'' +
                ", faceUrl='" + faceUrl + '\'' +
                ", owner_Account='" + owner_Account + '\'' +
                ", createTime=" + createTime +
                ", infoSeq=" + infoSeq +
                ", lastInfoTime=" + lastInfoTime +
                ", lastMsgTime=" + lastMsgTime +
                ", nextMsgSeq=" + nextMsgSeq +
                ", maxMemberNum=" + maxMemberNum +
                ", applyJoinOption='" + applyJoinOption + '\'' +
                '}';
    }
}
