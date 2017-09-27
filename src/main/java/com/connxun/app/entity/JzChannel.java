package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-15 15:09
 * @Comments：频道
 */
@Entity
@Table(name = "jz_channel")
public class JzChannel implements Serializable {

    private static final long serialVersionUID = 4855392861394240319L;

    //内部ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //频道ID
    @JsonProperty("channel_id")
    String channelId;
    //直播间名称
    @JsonProperty("channel_name")
    String channelName;
    //直播间状态 0:断流；1:开启；3:关闭
    @JsonProperty("channel_status")
    Integer channelStatus;
    //创建码
    @JsonProperty("create_mode")
    String createMode;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonProperty("create_time")
    Date createTime;
    //水印
    @JsonProperty("watermark_id")
    String watermarkId;

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

    public String getCreateMode() {
        return createMode;
    }

    public void setCreateMode(String createMode) {
        this.createMode = createMode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWatermarkId() {
        return watermarkId;
    }

    public void setWatermarkId(String watermarkId) {
        this.watermarkId = watermarkId;
    }
}
