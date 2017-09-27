package com.tls.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-23 17:28
 * @Comments：tls账号实体
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsAccountEntity {

    //必填	用户名，长度不超过 32 字节
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Identifier")
    String identifier;
    //选填	用户昵称
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Nick")
    String nick;
    //选填	用户头像URL。
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("FaceUrl")
    String faceUrl;
    //选填	帐号类型，开发者默认无需填写，值0表示普通帐号，1表示机器人帐号。
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Type")
    Integer type;


    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }



    @Override
    public String toString() {
        return "TlsAccountEntity{" +
                "identifier='" + identifier + '\'' +
                ", nick='" + nick + '\'' +
                ", faceUrl='" + faceUrl + '\'' +
                ", type=" + type +
                '}';
    }
}
