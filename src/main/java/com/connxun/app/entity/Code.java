package com.connxun.app.entity;

/**
 * Created by Mac on 2017/5/16.
 */
public enum Code {
    //通用
    SUCCESS("200", "获取成功"),
    NOHTTP("201", "您的网络状况不佳或者断网导致申领失败！"),
    FAIL("1", "获取信息失败"),

    //    用户   100-199

    USERISNOT("101", "用户不存在"),
    LOGINFAIL("102", "您的密码错误!"),
    CAPTCHFAIL("103", "验证码错误"),
    TOKENFAIL("104", "token验证失败"),
    AUDITFAIL("105", "禁用"),
    AUDITING("106", "审核中"),
    SESSIONFAIL("107", "session失效"),
    PHONEREPEAT("108", "您的手机号已被注册!"),
    PHONEFAIL("109", "您的手机号还没有注册!"),
    BLACKLISTED("110", "禁止观看"),
    ISBLACK("113", "已加入黑名单"),
    NOBLACK("114", "未加入黑名单"),
    ISFOLLOW("111", "用户已经关注"),
    NOFOLLOW("112", "用户未关注"),
    ISSHOP("113", "用户已购买"),
    NOSHOP("114", "用户未购买"),
    ISCOLLECTION("115", "用户已收藏"),
    NOCOLLECTION("116", "用户未收藏"),
    NOADDRESS("117", "地址参数错误"),
    //  视频 600-699

    STREAMNAMEISNO("601", "直播流不存在"),

    PULLSUCCESS("200", ""),

    PUSHSUCCESS("", ""),

    PULLFAIL("", ""),

    PUSHFAIL("", ""),


    //代金券   1000-1100

    NOVOCHER("1000", "代金券不存在"),

    VOCHEROUT("1001", "申领失败，本次代金券已经被申领完了！"),

    VOCHERNOCOURSE("1002", "代金券无课程"),

    VOCHERNISUSER("1003", "申领失败，您已经申领过了"),

    VOCHER_NO_START("1004", "活动尚未开始，请看准申领时间哟！"),

    VOCHER_IS_END("1005", "申领失败，活动已过期或者可申领代金券数量为0！"),


    //    订单800-899
    NOORDER("801", "订单不存在"),
    //    课程900-999
    NOCOURSE("901", "课程不存在"),
    NOCOURSECHATER("902", "课程章节不存在"),


    //    其他1000-1099
    NEWVERSION("1001", "最新版本"),
    NOVERSION("1002", "请更新版本"),
    // 商品 700-799
    GOODSISNOT("701", "商品不存在");

    private String code;
    private String message;

    private Code(String code, String message) {
        this.code = code;
        this.message = message;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
