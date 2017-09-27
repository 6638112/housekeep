package com.connxun.app.searchVO;

import io.swagger.annotations.ApiParam;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-26 14:19
 * @Comments：主播申请表查询
 */
public class JzApplyPlayerSearchVO extends CommonSearchVO {

    @ApiParam("申请编号")
    private String applyNo;
    @ApiParam("申请人名称")
    private String applyerName;
    @ApiParam("申请结果")
    private Integer result;

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getApplyerName() {
        return applyerName;
    }

    public void setApplyerName(String applyerName) {
        this.applyerName = applyerName;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
