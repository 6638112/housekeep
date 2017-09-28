package com.connxun.app.searchVO;

import io.swagger.annotations.ApiParam;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-18 14:16
 * @Comments：
 */
public class JzChannelSearchVO extends CommonSearchVO {

    @ApiParam(required = false, name = "channelNo", value = "频道ID")
    private String channelNo;
    @ApiParam(required = false, name = "channelName", value = "频道名称")
    private String channelName;
    @ApiParam(required = false, name = "channelStatus", value = "频道状态")
    private Integer channelStatus;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getChannelNameParam() {
        return "%"+channelName+"%";
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
}
