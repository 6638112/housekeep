package com.tls.sigcheck;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-22 11:45
 * @Comments：REST API公共错误码枚举类
 */
public enum ApiErrorCodeEnum {

    API_80001(80001, "消息文本安全打击。"),
    API_60002(60002, "HTTP解析错误 ，请检查HTTP请求URL格式。"),
    API_60003(80003, "HTTP请求JSON解析错误，请检查JSON格式 。"),
    API_60004(60004, "请求URL或JSON包体中帐号或签名错误 。"),
    API_60005(60005, "请求URL或JSON包体中帐号或签名错误 。"),
    API_60006(60006, "appid失效，请核对appid有效性 。"),
    API_60007(60007, "rest接口调用频率超过限制，请降低请求频率 。"),
    API_60008(60008, "服务请求超时或HTTP请求格式错误，请检查并重试 。"),
    API_60009(60009, "请求资源错误，请检查请求URL。"),
    API_60010(60010, "请求需要APP管理员权限，请检查接口调用权限。"),
    API_60011(60011, "appid请求频率超限，请降低请求频率。"),
    API_60012(60012, "REST接口需要带sdkappid，请检查请求URL中的sdkappid。"),
    API_60013(60013, "HTTP响应包JSON解析错误。"),
    API_60014(60014, "置换id超时。"),
    API_60015(60015, "请求包体帐号类型错误，请确认帐号为字符串格式。"),

    /*-------- 账号系统 --------*/
    API_70001(70001, "sig过期，请尝试重新生成。如果是刚生成，就过期，请检查有效期填写的是否过小，或者填的0。"),
    API_70002(70002, "sig长度为0，请检查传入的sig是否正确"),
    API_70003(70003, "sig校验失败，请确认下sig内容是否被截断，如缓冲区长度不够导致的内容截断。"),
    API_70004(70004, "sig校验失败，请确认下sig内容是否被截断，如缓冲区长度不够导致的内容截断 。"),
    API_70005(70005, "sig校验失败，可用工具自行验证生成的sig是否正确 。"),
    API_70006(70006, "sig校验失败，可用工具自行验证生成的sig是否正确"),
    API_70007(70007, "sig校验失败，可用工具自行验证生成的sig是否正确"),
    API_70008(70008, "sig校验失败，可用工具自行验证生成的sig是否正确"),
    API_70009(70009, "用业务公钥验证sig失败，请确认生成的 usersig 使用的私钥和 sdkappid 是否对应"),
    API_70010(70010, "sig校验失败，可用工具自行验证生成的sig是否正确"),
    API_70013(70013, "sig中identifier与请求时的identifier不匹配，请检查登录时填写的identifier与sig中的是否一致"),
    API_70014(70014, "sig中sdkappid与请求时的sdkappid不匹配，请检查登录时填写的sdkappid与sig中的是否一致"),
    API_70015(70015, "未找到该 appid 和账号类型对应的验证方式，请确认是否进行了帐号集成操作。"),
    API_70016(70016, "拉取到的公钥长度为0，请确认是否已经上传了公钥，如果是重新上传的公钥需要十分钟之后尝试"),
    API_70017(70017, "内部第三方票据验证超时"),
    API_70018(70018, "内部验证第三方票据失败"),
    API_70019(70019, "通过https方式验证的票据字段为空，请正确填写sig"),
    API_70020(70020, "sdkappid 未找到，请确认是否已经在腾讯云上配置"),
    API_70052(70052, "usersig 已经失效，请重新生成，再次尝试"),

    API_70101(70101, "请求包信息为空"),
    API_70102(70102, "请求包帐号类型错误"),
    API_70103(70103, "电话号码格式错误"),
    API_70104(70104, "邮箱格式错误"),
    API_70105(70105, "TLS 帐号格式错误"),
    API_70106(70106, "非法帐号格式类型"),
    API_70107(70107, "Identifer 没有注册"),
    API_70113(70113, "批量数量不合法"),
    API_70114(70114, "安全原因被限制"),
    API_70115(70115, "uin 不是对应 appid 的开发者 uin"),
    API_70140(70140, "sdkappid 和 acctype 不匹配"),
    API_70145(70145, "帐号类型错误"),
    API_70169(70169, "内部错误"),

    API_70201(70201, "内部错误"),
    API_70202(70202, "内部错误"),
    API_70203(70203, "内部错误"),
    API_70204(70204, "appid 没有对应的 acctype"),
    API_70205(70205, "查找 acctype 失败，请重试"),
    API_70206(70206, "请求中批量数量不合法"),
    API_70207(70207, "内部错误，请重试"),
    API_70208(70208, "内部错误，请重试"),
    API_70209(70209, "获取开发者 uin 标志失败"),
    API_70210(70210, "请求中 uin 为非开发者 uin"),
    API_70211(70211, "请求中 uin 非法"),
    API_70212(70212, "内部错误，请重试"),
    API_70213(70213, "访问内部数据失败，请重试"),
    API_70214(70214, "验证内部票据失败"),
    API_70221(70221, "登录状态无效，请使用 usersig 重新鉴权"),
    API_70222(70222, "内部错误，请重试"),
    API_70225(70225, "内部错误，请重试"),
    API_70308(70308, "内部错误，请重试"),

    API_70346(70346, "票据校验失败"),
    API_70347(70347, "票据因过期原因校验失败"),
    API_70348(70348, "内部错误，请重试"),

    API_70362(70362, "内部超时，请重试"),
    API_70401(70401, "内部错误，请重试"),

    API_70402(70402, "参数非法。请检查必填字段是否填充，或者字段的填充是否满足协议要求"),
    API_70403(70403, "发起操作者不是APP管理员，没有权限操作"),

    API_70050(70050, "因失败且重试次数过多导致被限制，请检查票据是否正确，一分钟之后再试。"),
    API_70051(70051, "帐号已被拉入黑名单");


    private Integer ErrorCode;
    private String ErrorInfo;

    ApiErrorCodeEnum(Integer errorCode, String errorInfo) {
        ErrorCode = errorCode;
        ErrorInfo = errorInfo;
    }

    public Integer getErrorCode() {
        return ErrorCode;
    }

    public static ApiErrorCodeEnum getErrorInfo(Integer errorCode) {
        for (ApiErrorCodeEnum authStateEnum :values()){
            if (authStateEnum.getErrorCode()==errorCode){
                return authStateEnum;
            }
        }
        return null;
    }

}