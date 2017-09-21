package com.connxun.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by anna on 2017-07-30.
 */
@Entity
@Table(name = "lw_news_log")
public class LwNewsLog  implements Serializable {

    private static final long serialVersionUID = -8721271688654958830L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer newsNo;
    private Integer userNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNewsNo() {
        return newsNo;
    }

    public void setNewsNo(Integer newsNo) {
        this.newsNo = newsNo;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }
}
