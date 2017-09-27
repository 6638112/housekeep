package com.connxun.app.searchVO;

import io.swagger.annotations.ApiParam;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-26 14:19
 * @Comments：主播查询
 */
public class JzPlayerSearchVO extends CommonSearchVO{

    @ApiParam("频道名称")
    private String channelName;
    @ApiParam("主播名称")
    private String playerName;
    @ApiParam("主播状态")
    private Integer Status;

    public String getChannelName() {
        return channelName;
    }
    public String getChannelNameParam() {
        return "%"+channelName+"%";
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerNameParam() {
        return "%"+playerName+"%";
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }
}
