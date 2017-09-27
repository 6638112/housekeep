package com.tls.sigcheck;
import com.connxun.util.properties.OpeProperties;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-21 18:44
 * @Comments：Tls服务端API
 * 注：Tls REST API仅支持POST方法，其请求包体为JSON格式
 */
public class TlsConstantApi {

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
        OpeProperties opeProperties=new OpeProperties();
        SDKAPPID= opeProperties.GetValueByKey("","tls.sdkappid").trim();
    }

    /*-------- 1.账号管理接口 ---------*/
    //独立模式账号导入接口
    public static final String D_ACCOUNT=TLSAPI+"im_open_login_svc/account_import?";
    //独立模式批量导入账号
    public static final String D_MUL_ACCOUNT=TLSAPI+"im_open_login_svc/multiaccount_import?";
    //登录状态失效接口
    public static final String D_LOGIN_KICK=TLSAPI+"im_open_login_svc/kick?";

    /*-------- 2.单聊消息接口 ---------*/
    public static final String SENDMSG = TLSAPI+"openim/sendmsg?";
    public static final String BATCH_SENDMSG = TLSAPI+"openim/batchsendmsg?";
    public static final String IMPORT_MSG = TLSAPI+"openim/importmsg?";


    /*-------- 3.消息推送接口 ---------*/
    public static final String IM_PUSH = TLSAPI+"openim/im_push?";
    public static final String IM_GET_PUSH_REPORT = TLSAPI+"openim/im_get_push_report?";
    public static final String IM_SET_ATTR_NAME = TLSAPI+"openim/im_set_attr_name?";
    public static final String IM_GET_ATTR_NAME = TLSAPI+"openim/im_get_attr_name?";
    public static final String IM_SET_ATTR = TLSAPI+"openim/im_set_attr?";
    public static final String IM_REMOVE_ATTR = TLSAPI+"openim/im_remove_attr?";
    public static final String IM_GET_ATTR = TLSAPI+"openim/im_get_attr?";
    public static final String IM_ADD_TAG = TLSAPI+"openim/im_add_tag?";
    public static final String IM_REMOVE_TAG = TLSAPI+"openim/im_remove_tag?";
    public static final String IM_REMOVE_ALL_TAGS = TLSAPI+"openim/im_remove_all_tags?";

    /*-------- 4.群组管理接口 ---------*/
    public static final String GROUP_LIST = TLSAPI+"group_open_http_svc/get_appid_group_list?";
    public static final String CREATE_GROUP = TLSAPI+"group_open_http_svc/create_group?";
    public static final String GET_GROUP_INFO = TLSAPI+"group_open_http_svc/get_group_info?";
    public static final String GET_GROUP_MEMBER_INFO = TLSAPI+"group_open_http_svc/get_group_member_info?";
    public static final String MODIFY_GROUP_BASE_INFO = TLSAPI+"group_open_http_svc/modify_group_base_info?";
    public static final String ADD_GROUP_MEMBER = TLSAPI+"group_open_http_svc/add_group_member?";
    public static final String DELETE_GROUP_MEMBER = TLSAPI+"group_open_http_svc/delete_group_member?";
    public static final String MODIFY_GROUP_MEMBER_INFO = TLSAPI+"group_open_http_svc/modify_group_member_info?";
    public static final String DESTORY_GROUP = TLSAPI+"group_open_http_svc/destroy_group?";
    public static final String GET_JOINED_GROUP_LIST = TLSAPI+"group_open_http_svc/get_joined_group_list?";
    public static final String GET_ROLE_IN_GROUP = TLSAPI+"group_open_http_svc/get_role_in_group?";
    public static final String FORBID_SEND_MSG = TLSAPI+"group_open_http_svc/forbid_send_msg?";
    public static final String GET_GROUP_SHUTTED_UIN = TLSAPI+"group_open_http_svc/get_group_shutted_uin?";
    public static final String SEND_GROUP_MSG = TLSAPI+"group_open_http_svc/send_group_msg?";
    public static final String SEND_GROUP_SYSTEM_NOTIFICATION = TLSAPI+"group_open_http_svc/send_group_system_notification?";
    public static final String CHANGE_GROUP_OWNER = TLSAPI+"group_open_http_svc/change_group_owner?";
    public static final String IMPORT_GROUP = TLSAPI+"group_open_http_svc/import_group?";
    public static final String IMPORT_GROUP_MSG = TLSAPI+"group_open_http_svc/import_group_msg?";
    public static final String IMPORT_GROUP_MEMBER = TLSAPI+"group_open_http_svc/import_group_member?";
    public static final String SET_UNREAD_MSG_NUM = TLSAPI+"group_open_http_svc/set_unread_msg_num?";
    public static final String DELETE_GROUP_MSG_BY_SENDER = TLSAPI+"group_open_http_svc/delete_group_msg_by_sender?";
    public static final String SEARCH_GROUP = TLSAPI+"group_open_http_svc/search_group?";
    public static final String GROUP_MSG_GET_SIMPLE = TLSAPI+"group_open_http_svc/group_msg_get_simple?";

    /*-------- 5.资料管理接口 ---------*/

    /*-------- 6.关系链管理接口 ---------*/

    /*-------- 7.脏字管理 ---------*/

    /*-------- 8.数据下载 ---------*/

    /*-------- 9.在线状态 ---------*/

    /*-------- 10.全局禁言管理 ---------*/
}