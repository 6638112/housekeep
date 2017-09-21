package com.connxun.app.dto;

import java.io.Serializable;

/**
 * Created by zosoft-java on 2017/7/28.
 */
public class LwUserTestDTO implements Serializable {
    private static final long serialVersionUID = -5253162388604692876L;
    private int id;

    private String subject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
