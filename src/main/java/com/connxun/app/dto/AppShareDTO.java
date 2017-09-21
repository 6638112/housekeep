package com.connxun.app.dto;

import java.io.Serializable;

/**
 * Created by zosoft-java on 2017/7/26.
 */
public class AppShareDTO implements Serializable {


    private static final long serialVersionUID = -3229434886221945824L;
    //    图片路劲
    private String imgUrl;
    //    链接
    private String url;


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
