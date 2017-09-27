package com.tls.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-25 10:00
 * @Comments：各类api调用封装的ListEntity
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsListEntity {

    //批量导入账号list
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Accounts")
    List<String> accounts;

    //获取群组详细资料list
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("GroupIdList")
    List<String> groupIdList;


    public List<String> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<String> groupIdList) {
        this.groupIdList = groupIdList;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }
}
