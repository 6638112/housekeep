package com.tls.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-25 10:00
 * @Comments：各类api调用封装的listentity
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsListEntity {

    //批量导入账号list
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Accounts")
    List<String> accounts;




    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }
}
