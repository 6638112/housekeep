package com.tls.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

    //错误编码
    @JsonProperty("ErrorCode")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;

    //错误信息
    @JsonProperty("ErrorInfo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorInfo;

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

    //群组成员
    @JsonProperty("MemberList")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TlsMemberEntity> memberList;

    //群组维度的自定义字段
    @JsonProperty("AppDefinedData")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AppDefinedData> appDefinedData;

    //增加群组成员——是否静默加人（选填）0：非静默加人；1：静默加人。不填该字段默认为0。
    @JsonProperty("Silence")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer silence;

    /*群组维度的自定义字段*/
    class AppDefinedData{
        ///key
        @JsonProperty("Key")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String key;

        //value
        @JsonProperty("Value")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


    public Integer getSilence() {
        return silence;
    }

    public void setSilence(Integer silence) {
        this.silence = silence;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getType() {
        return type;
    }

    public List<TlsMemberEntity> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<TlsMemberEntity> memberList) {
        this.memberList = memberList;
    }

    public List<AppDefinedData> getAppDefinedData() {
        return appDefinedData;
    }

    public void setAppDefinedData(List<AppDefinedData> appDefinedData) {
        this.appDefinedData = appDefinedData;
    }

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
                ", lastInfoTime=" + lastInfoTime +
                ", lastMsgTime=" + lastMsgTime +
                ", nextMsgSeq=" + nextMsgSeq +
                ", maxMemberNum=" + maxMemberNum +
                ", applyJoinOption='" + applyJoinOption + '\'' +
                '}';
    }
}
