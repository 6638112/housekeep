package com.tls.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by anna on 2017-09-27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsMemberEntity {

    //群成员ID
    @JsonProperty("Member_Account")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String memberAccount;

    //群内角色
    @JsonProperty("Role")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String role;

    //群内角色
    @JsonProperty("JoinTime")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer joinTime;

    //该成员当前已读消息Seq
    @JsonProperty("MsgSeq")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer msgSeq;

    //消息屏蔽选项
    @JsonProperty("MsgFlag")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msgFlag;

    //最后发言时间
    @JsonProperty("LastSendMsgTime")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer lastSendMsgTime;

    //禁言截至时间
    @JsonProperty("ShutUpUntil")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer shutUpUntil;

    //群成员自定义字段
    @JsonProperty("AppMemberDefinedData")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<AppMemberDefinedData> appMemberDefinedData;

    //加人结果：0为失败；1为成功；2为已经是群成员
    @JsonProperty("Result")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String result;

    /*群成员自定义字段*/
    class AppMemberDefinedData{
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Integer joinTime) {
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

    public Integer getLastSendMsgTime() {
        return lastSendMsgTime;
    }

    public void setLastSendMsgTime(Integer lastSendMsgTime) {
        this.lastSendMsgTime = lastSendMsgTime;
    }

    public Integer getShutUpUntil() {
        return shutUpUntil;
    }

    public void setShutUpUntil(Integer shutUpUntil) {
        this.shutUpUntil = shutUpUntil;
    }

    public List<AppMemberDefinedData> getAppMemberDefinedData() {
        return appMemberDefinedData;
    }

    public void setAppMemberDefinedData(List<AppMemberDefinedData> appMemberDefinedData) {
        this.appMemberDefinedData = appMemberDefinedData;
    }


    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }



}
