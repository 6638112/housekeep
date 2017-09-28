package com.connxun.app.searchVO;

import io.swagger.annotations.ApiParam;

/**
 * Created by anna on 2017-09-27.
 */
public class JzMemberSearchVO extends CommonSearchVO {

    @ApiParam("群组ID")
    private String groupNo;
    @ApiParam("成员名称")
    private String memberName;

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberNameParam() {
        return "%"+memberName+"%";
    }

    public void setMemberName(String memberName) {
        memberName = memberName;
    }
}
