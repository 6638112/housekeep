package com.tls.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-25 11:03
 * @Comments：增加群组list
 */
public class TlsGroupAddMemberEntity {

    //群组ID
    @JsonProperty("GroupId")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String groupId;

    //群组ID
    @JsonProperty("MemberList")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Member_Account> memberList;

    // 是否静默加人（选填）0：非静默加人；1：静默加人。不填该字段默认为0。
    @JsonProperty("Silence")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer silence;

    public static class Member_Account{
        //群成员ID
        @JsonProperty("Member_Account")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String member_Account;

        //加人结果：0为失败；1为成功；2为已经是群成员
        @JsonProperty("Result")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String result;

        public String getMember_Account() {
            return member_Account;
        }

        public void setMember_Account(String member_Account) {
            this.member_Account = member_Account;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return "Member_Account{" +
                    "member_Account='" + member_Account + '\'' +
                    ", result='" + result + '\'' +
                    '}';
        }
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Member_Account> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member_Account> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "TlsGroupAddMemberEntity{" +
                "groupId='" + groupId + '\'' +
                ", memberList=" + memberList +
                ", silence=" + silence +
                '}';
    }
}
