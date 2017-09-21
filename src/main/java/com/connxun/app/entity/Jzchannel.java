package com.connxun.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Jzchannel implements Serializable {

    private static final long serialVersionUID = 4855392861394240319L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Integer id;

    String channel_id;
    //直播间名称
    String channel_name;
    //直播间状态 0:断流；1:开启；3:关闭
    Integer channel_status;
    //创建码
    String create_mode;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date create_time;
    //水印
    @JsonIgnore
    String watermark_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getCreate_mode() {
        return create_mode;
    }

    public void setCreate_mode(String create_mode) {
        this.create_mode = create_mode;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getWatermark_id() {
        return watermark_id;
    }

    public void setWatermark_id(String watermark_id) {
        this.watermark_id = watermark_id;
    }
}
