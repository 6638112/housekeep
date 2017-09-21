package com.tls.sigcheck;

import com.connxun.util.properties.OpeProperties;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-21 18:44
 * @Comments：Tls服务端API
 * 注：Tls REST API仅支持POST方法，其请求包体为JSON格式
 */
public class TlsConstantAPI {

    /**
     * ver	协议版本号 。	固定为v4。
     * servicename	内部服务名，不同的servicename对应不同的服务类型。
     * command	命令字，与servicename组合用来标识具体的业务功能。
     * sdkappid	APP在云通信控制台上获取的Appid。
     * identifier	用户名，调用REST API时一般为APP管理员帐号。
     * usersig	用户名对应的签名。
     * random	标识当前请求的整数随机数参数。
     */
    //https://console.tim.qq.com/
    // $ver/$servicename/$command?sdkappid=$sdkappid&identifier=$identifier&usersig=$usersig&random=99999999&contenttype=json]

    //tlsapi前缀
    public static final String TLSAPI="https://console.tim.qq.com/v4/";
    //sdkappid
    public static final String SDKAPPID;

    static{
        SDKAPPID= OpeProperties.GetValueByKey("","tls.sdkappid").trim();
    }

    /*-------- 1.账号管理接口 ---------*/
    //独立模式账号导入接口
    public static final String D_ACCOUNT=TLSAPI+"im_open_login_svc/account_import?" +
            "usersig=xxx&identifier=admin&sdkappid=88888888&random=99999999&contenttype=json";

    //独立模式批量导入账号
    public static final String D_MUL_ACCOUNT=TLSAPI+"im_open_login_svc/multiaccount_import?" +
            "usersig=xxx&identifier=admin&sdkappid=88888888&random=99999999&contenttype=json";

    //登录状态失效接口
    public static final String D_LOGIN_KICK=TLSAPI+"im_open_login_svc/kick?" +
            "usersig=xxx&identifier=admin&sdkappid=88888888&random=99999999&contenttype=json";

    /*-------- 2.单聊消息接口 ---------*/

    /*-------- 3.消息推送接口 ---------*/

    /*-------- 4.群组管理接口 ---------*/

    /*-------- 5.资料管理接口 ---------*/

    /*-------- 6.关系链管理接口 ---------*/

    /*-------- 7.脏字管理 ---------*/

    /*-------- 8.数据下载 ---------*/

    /*-------- 9.在线状态 ---------*/

    /*-------- 10.全局禁言管理 ---------*/
}
