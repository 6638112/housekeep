package com.tls.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-22 11:42
 * @Comments：tls应答包实体
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsResultEntity {

    /*---------------- result基础字段 -----------------*/
    // 请求处理的结果，OK表示处理成功，FAIL表示失败，如果为FAIL，ErrorInfo带上失败原因。
    @JsonProperty("ActionStatus")
    private String actionStatus;
    // 错误码
    @JsonProperty("ErrorCode")
    private Integer errorCode;
    // 错误信息
    @JsonProperty("ErrorInfo")
    private String errorInfo;

    /*----------------- 账号管理result字段 -----------------*/
    // 账号管理——批量导入账号失败list
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("FailAccounts")
    List<String> failAccounts;

    /*----------------- 群组管理result字段 -----------------*/
    // 群组管理———获取群组ID 获取APP当前的群组总数
    @JsonProperty("TotalCount")
    private String totalCount;

    // 群组管理——获取群组ID LIST
    @JsonProperty("GroupIdList")
    private List<TlsGroupEntity> groupIdList;

    // 群组管理———获取群组ID 分页拉取的标志
    @JsonProperty("Next")
    private String next;

    // 群组管理——获取群组详细信息list
    @JsonProperty("GroupInfo")
    private List<TlsGroupEntity> groupInfo;


    /*----------------- end -----------------*/

    public List<String> getFailAccounts() {
        return failAccounts;
    }

    public void setFailAccounts(List<String> failAccounts) {
        this.failAccounts = failAccounts;
    }

    public String getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }


    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<TlsGroupEntity> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<TlsGroupEntity> groupIdList) {
        this.groupIdList = groupIdList;
    }

    public List<TlsGroupEntity> getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(List<TlsGroupEntity> groupInfo) {
        this.groupInfo = groupInfo;
    }


}
