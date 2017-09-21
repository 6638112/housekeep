package com.connxun.app.dto;

import java.io.Serializable;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-20 09:41
 * @Comments：json频道信息（拼接channelID）
 */
public class JzChannelDTO implements Serializable {

    //频道ID
    String channel_id;
    //直播间名称
    String channel_name;
    //直播间状态 0:断流；1:开启；3:关闭
    Integer channel_status;
    //频道主播
    String channel_player;
    //频道链接
    String channel_url;

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public Integer getChannel_status() {
        return channel_status;
    }

    public void setChannel_status(Integer channel_status) {
        this.channel_status = channel_status;
    }

    public String getChannel_player() {
        return channel_player;
    }

    public void setChannel_player(String channel_player) {
        this.channel_player = channel_player;
    }

    public String getChannel_url() {
        return channel_url;
    }

    public void setChannel_url(String channel_url) {
        this.channel_url = channel_url;
    }
}
