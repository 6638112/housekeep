package com.connxun.app.jsonBean;

import com.connxun.app.entity.JzChannel;

import java.util.List;

/**
 * Created by anna on 2017-09-18.
 */
public class Output {

    //总个数
    private int all_count;
    //列表
    private List<JzChannel> channel_list;

    public int getAll_count() {
        return all_count;
    }

    public void setAll_count(int all_count) {
        this.all_count = all_count;
    }

    public List<JzChannel> getChannel_list() {
        return channel_list;
    }

    public void setChannel_list(List<JzChannel> channel_list) {
        this.channel_list = channel_list;
    }
}
