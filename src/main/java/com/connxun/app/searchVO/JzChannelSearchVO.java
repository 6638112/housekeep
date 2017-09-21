package com.connxun.app.searchVO;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-18 14:16
 * @Comments：
 */
public class JzChannelSearchVO extends CommonSearchVO {

    private Integer id;
    private String channelNo;
    private String channelName;
    private Integer channelStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
