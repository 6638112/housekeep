package com.connxun.app.dto;

import com.connxun.app.entity.JzPlayer;

import java.io.Serializable;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-20 09:41
 * @Comments：频道信息（拼接channelID）
 */
public class JzChannelDTO implements Serializable {

    //内部ID
    Integer id;
    //频道ID(云端)
    String channelId;
    //直播间名称
    String channelName;
    //直播间状态 0:断流；1:开启；3:关闭
    Integer channelStatus;
    //群组ID(云端)
    String groupId;
    //频道主播
    JzPlayer channelPlayer;
    //频道iframe链接
    String channelUrl;
    //对接视频播放的bizId
    String bizId;




    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getChannelStatus() {
        return channelStatus;
    }

    public void setChannelStatus(Integer channelStatus) {
        this.channelStatus = channelStatus;
    }

    public JzPlayer getChannelPlayer() {
        return channelPlayer;
    }

    public void setChannelPlayer(JzPlayer channelPlayer) {
        this.channelPlayer = channelPlayer;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }
}
