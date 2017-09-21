package com.connxun.app.searchVO;

/**
 * 用户查询Vo
 * Created by Mac on 2017/6/11.
 */
public class LwUserSearchVO extends CommonSearchVO {

    private String openId;
    private String qqId;
    private String wbId;

    private String phone;
    private Integer UserNo;
    //    位置描述
    private String position;
    //纬度
    private String latitude;
    //    经度
    private String longitude;
    //    搜索
    private String search;
    private String icon;
    private Integer id;
    private String nickName;
    private Integer sex;
    //          老密码
    private String password;
    private String newPwd;
    //    注册规则ID
    private Integer invitationNo;
    //     注册邀请号
    private Integer inviteCode;
    //
    private Integer guide;
    // 扫码登录的验证code
    public String code;
    //    扫码登录的UUID
    public String codeUUID;

    private Integer integral;
    private Integer loginType;
    private Integer state;
    //    考区id
    private Integer testNo;

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getSearchParam() {
        return "%" + search + "%";

    }

    public String getNickNameParam() {
        return "%" + nickName + "%";

    }

    private String declaration;

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserNo() {
        return UserNo;
    }

    public void setUserNo(Integer userNo) {
        UserNo = userNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public Integer getInvitationNo() {
        return invitationNo;
    }

    public void setInvitationNo(Integer invitationNo) {
        this.invitationNo = invitationNo;
    }

    public Integer getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(Integer inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Integer getGuide() {
        return guide;
    }

    public void setGuide(Integer guide) {
        this.guide = guide;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeUUID() {
        return codeUUID;
    }

    public void setCodeUUID(String codeUUID) {
        this.codeUUID = codeUUID;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getQqId() {
        return qqId;
    }

    public void setQqId(String qqId) {
        this.qqId = qqId;
    }

    public String getWbId() {
        return wbId;
    }

    public void setWbId(String wbId) {
        this.wbId = wbId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTestNo() {
        return testNo;
    }

    public void setTestNo(Integer testNo) {
        this.testNo = testNo;
    }
}
