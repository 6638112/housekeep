package com.connxun.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by xiaoxiao on 2017/7/17.
 * 敏感词表
 */
@Entity
@Table(name = "lw_dict_sensitive")
public class LwDictSensitive implements Serializable {

    private static final long serialVersionUID = 6876217285084645969L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*编号*/
    private Integer id;
    /*敏感词*/
    private String value;
    /*是否启用 0: 否   1：是*/
    private Integer isOpen;
    /*导入行号*/
    @Transient
    private int rowIndex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
}
