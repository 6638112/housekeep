package com.connxun.app.searchVO;

/**
 * Created by anna on 2017-08-23.
 */
public class LwVersionSearchVO  extends CommonSearchVO  {
    private int id;
    private String versionNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public String getVersionNoParam() {
        return "%"+versionNo+"%";
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }
}
