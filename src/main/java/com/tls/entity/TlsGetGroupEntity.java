package com.tls.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-25 10:13
 * @Comments：获取群组列表entity
 */
public class TlsGetGroupEntity {

    //要拉取的群组类型(选填)  不填为拉取所有，private/Public/聊天室ChatRoom/互动直播聊天室AVChatRoom/在线成员广播大群BChatRoom
    @JsonProperty("GroupType")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String groupType;

    //本次获取的群组ID数量的上限，不得超过10000。如果不填，默认为最大值10000。
    @JsonProperty("Limit")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer limit;

    //群太多时分页拉取标志，第一次填0，以后填上一次返回的值，返回的Next为0代表拉完了。
    @JsonProperty("Next")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer next;


    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "TlsGetGroupEntity{" +
                "groupType='" + groupType + '\'' +
                ", limit=" + limit +
                ", next=" + next +
                '}';
    }
}
