package com.connxun.app.searchVO;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-20 15:51
 * @Comments：
 */
public class LwStartupPageSearchVO extends CommonSearchVO {
    //    0 启动页  1 轮播图   2 app分享  3 pc
    private Integer type;
    //    0 启用  1 停用
    private Integer state;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
//

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
