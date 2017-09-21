package com.connxun.app.dto;

import java.io.Serializable;

/**
 * Created by zosoft-java on 2017/7/25.
 */
public class LwTeacherDTO  implements Serializable {
    private static final long serialVersionUID = -489850470453650738L;
    private Integer id;
    //    头像
    private String icon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String nickName;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
