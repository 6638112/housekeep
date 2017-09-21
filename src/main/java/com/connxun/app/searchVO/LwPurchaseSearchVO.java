package com.connxun.app.searchVO;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-24 11:00
 * @Comments：
 */
public class LwPurchaseSearchVO extends CommonSearchVO {

    private int id;
    private String Name;
    private String courseName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return "%" + Name + "%";
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCourseName() {
        return "%" + courseName + "%";
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
