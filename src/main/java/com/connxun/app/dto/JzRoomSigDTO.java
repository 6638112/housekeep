package com.connxun.app.dto;

import java.io.Serializable;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-25 18:12
 * @Comments：用户进入直播间后所需Sig等参数
 */
public class JzRoomSigDTO implements Serializable {

    //用户ID
    Integer identifier;
    //当前用户昵称，选填
    String identifierNick;
    //当前用户身份凭证，必须是字符串类型，选填
    String userSig;
    //当前用户默认头像，选填
    String headurl;


    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getIdentifierNick() {
        return identifierNick;
    }

    public void setIdentifierNick(String identifierNick) {
        this.identifierNick = identifierNick;
    }

    public String getUserSig() {
        return userSig;
    }

    public void setUserSig(String userSig) {
        this.userSig = userSig;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }
}
