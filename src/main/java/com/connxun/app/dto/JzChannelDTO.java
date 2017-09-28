package com.connxun.app.dto;

import java.io.Serializable;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-20 09:41
 * @Comments：频道信息（拼接channelID）
 */
public class JzChannelDTO implements Serializable {

    //内部ID
    Integer id;
    //频道ID
    String channelId;
    //直播间名称
    String channelName;
    //直播间状态 0:断流；1:开启；3:关闭
    Integer channelStatus;
    //频道主播
    String channelPlayer;
    //频道链接
    String channelUrl;

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

    public String getChannelPlayer() {
        return channelPlayer;
    }

    public void setChannelPlayer(String channelPlayer) {
        this.channelPlayer = channelPlayer;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }
}
