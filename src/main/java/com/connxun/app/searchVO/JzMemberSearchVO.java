package com.connxun.app.searchVO;

import io.swagger.annotations.ApiParam;

/**
 * Created by anna on 2017-09-27.
 */
public class JzMemberSearchVO extends CommonSearchVO {

    @ApiParam("群组ID")
    private String groupNo;
    @ApiParam("成员名称")
    private String MemberName;

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getMemberName() {
        return MemberName;
    }

    public String getMemberNameParam() {
        return "%"+MemberName+"%";
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }
}
