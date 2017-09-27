package com.tls.sigcheck;

import com.connxun.util.http.HttpUtil;
import com.connxun.util.json.JsonUtil;
import com.connxun.util.string.StringUtil;
import com.tls.entity.*;

import java.util.ArrayList;
import java.util.List;

import static com.tls.sigcheck.TlsConstantApi.*;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-22 11:38
 * @Comments：tls接口工具类
 * 注：Tls REST API仅支持POST方法，其请求包体为JSON格式
 */
public class TlsApiUtil {

    /*-------- 1.账号管理 --------*/
    /**
     * 账号相关私有错误码
     * 70402	参数非法。请检查必填字段是否填充，或者字段的填充是否满足协议要求。
     * 70403	发起操作者不是APP管理员，没有权限操作。
     * 70404	设置简单资料后端超时。
     */
    /**
     * 独立模式导入账号
     * @param identifier 用户名
     * @param usersig 用户加密sig
     * @param tlsAccountEntity tls账户实体
     * Identifier	String	必填	用户名，长度不超过 32 字节
     * Nick	String	选填	用户昵称
     * FaceUrl	String	选填	用户头像URL。
     * Type	Integer	选填	帐号类型，开发者默认无需填写，值0表示普通帐号，1表示机器人帐号。
     */
    public static TlsResultEntity accountImport(String identifier, String usersig, TlsAccountEntity tlsAccountEntity){

        /*拼接json*/
//        StringBuilder paramGroupList = new StringBuilder();
//        paramGroupList.append("{" );
//        if (StringUtil.isNotNullOrEmpty(paramIdentifier)){
//            paramGroupList.append("    \"Identifier\": \""+paramIdentifier+"\"");
//        }else{
//            return null;
//        }
//        if (StringUtil.isNotNullOrEmpty(nick)){
//            paramGroupList.append(" ,\"Nick\" : \""+nick+"\"" );
//        }
//        paramGroupList.append("}");

        String result= HttpUtil.getJsonFromUrlPost(D_ACCOUNT +
                "identifier=" + identifier +"&usersig=" + usersig +
                "&sdkappid="+SDKAPPID+"&random="+ StringUtil.buildRandom(6)+"&contenttype=json", JsonUtil.toStr(tlsAccountEntity));

        return (TlsResultEntity) JsonUtil.toObject(TlsResultEntity.class,result);
    }

    /**
     * 独立模式批量导入账号
     * @param identifier 用户名
     * @param usersig 用户加密sig
     * @param accounts tls账户名List<String>
     */
    public static TlsResultEntity accountMulImport(String identifier,String usersig,List<String> accounts){

//        TlsAccountEntity tlsAccountEntityMul=new TlsAccountEntity();
//        tlsAccountEntityMul.setAccount(accounts);
        TlsListEntity tlsListEntity=new TlsListEntity();
        tlsListEntity.setAccounts(accounts);

        String result= HttpUtil.getJsonFromUrlPost(D_MUL_ACCOUNT +
                "identifier=" + identifier +"&usersig=" + usersig +
                "&sdkappid="+SDKAPPID+"&random="+ StringUtil.buildRandom(6)+"&contenttype=json", JsonUtil.toStr(tlsListEntity));
        return (TlsResultEntity) JsonUtil.toObject(TlsResultEntity.class,result);
    }

    /**
     * 账号失效
     * @param identifier 用户名
     * @param usersig 用户加密sig
     * @param tlsAccountEntity tls账户
     * Identifier	String	必填	用户名，长度不超过 32 字节
     * Nick	String	选填	用户昵称
     * FaceUrl	String	选填	用户头像URL。
     * Type	Integer	选填	帐号类型，开发者默认无需填写，值0表示普通帐号，1表示机器人帐号。
     */
    public static TlsResultEntity accountKick(String identifier,String usersig, TlsAccountEntity tlsAccountEntity){
        String result= HttpUtil.getJsonFromUrlPost(D_LOGIN_KICK +
                "identifier=" + identifier +"&usersig=" + usersig +
                "&sdkappid="+SDKAPPID+"&random="+ StringUtil.buildRandom(6)+"&contenttype=json", JsonUtil.toStr(tlsAccountEntity));

        return (TlsResultEntity) JsonUtil.toObject(TlsResultEntity.class,result);
    }

    /*-------- 2.群组管理 --------*/
    /**
     * 获取APP中的所有群组的ID
     * @param identifier 用户ID
     * @param usersig 用户加密sig
     * @param tlsGetGroupEntity 群组实体
     */
    public static TlsResultEntity groupList(String identifier, String usersig, TlsGetGroupEntity tlsGetGroupEntity){

        if (tlsGetGroupEntity==null){
            tlsGetGroupEntity=new TlsGetGroupEntity();
        }
        String result= HttpUtil.getJsonFromUrlPost(GROUP_LIST +
                "identifier=" + identifier +"&usersig=" + usersig +
                "&sdkappid="+SDKAPPID+"&random="+ StringUtil.buildRandom(6)+"&contenttype=json", JsonUtil.toStr(tlsGetGroupEntity));

        return (TlsResultEntity) JsonUtil.toObject(TlsResultEntity.class,result);
    }

    /**
     * 创建群组
     * @param identifier 用户名
     * @param usersig 用户加密sig
     * @param tlsGroupEntity 群组实体
     */
    public static TlsResultEntity createGroup(String identifier, String usersig, TlsGroupEntity tlsGroupEntity){

        if (tlsGroupEntity==null){
            tlsGroupEntity=new TlsGroupEntity();
        }
        String result= HttpUtil.getJsonFromUrlPost(CREATE_GROUP +
                "identifier=" + identifier +"&usersig=" + usersig +
                "&sdkappid="+SDKAPPID+"&random="+ StringUtil.buildRandom(6)+"&contenttype=json", JsonUtil.toStr(tlsGroupEntity));

        return (TlsResultEntity) JsonUtil.toObject(TlsResultEntity.class,result);
    }

    /**
     * 获取群组详细资料
     * @param identifier 用户名
     * @param usersig 用户加密sig
     * @param groups 群组list
     */
    public static TlsResultEntity getGroupInfo(String identifier, String usersig, List<String> groups){

        TlsListEntity tlsListEntity=new TlsListEntity();
        tlsListEntity.setGroupIdList(groups);

        String result= HttpUtil.getJsonFromUrlPost(GET_GROUP_INFO +
                "identifier=" + identifier +"&usersig=" + usersig +
                "&sdkappid="+SDKAPPID+"&random="+ StringUtil.buildRandom(6)+"&contenttype=json", JsonUtil.toStr(tlsListEntity));

        return (TlsResultEntity) JsonUtil.toObject(TlsResultEntity.class,result);
    }


    /**
     * 增加群组成员
     * @param identifier 用户名
     * @param usersig 用户加密sig
     * @param tlsGroupEntity 群组实体
     */
    public static TlsResultEntity addGroupMember(String identifier, String usersig, TlsGroupEntity tlsGroupEntity){

        if (tlsGroupEntity==null){
            tlsGroupEntity=new TlsGroupEntity();
        }
        String result= HttpUtil.getJsonFromUrlPost(ADD_GROUP_MEMBER +
                "identifier=" + identifier +"&usersig=" + usersig +
                "&sdkappid="+SDKAPPID+"&random="+ StringUtil.buildRandom(6)+"&contenttype=json", JsonUtil.toStr(tlsGroupEntity));

        return (TlsResultEntity) JsonUtil.toObject(TlsResultEntity.class,result);
    }

    // TODO: 2017-09-22  消息推送。。。
    /*-------- 3.消息推送 --------*/

    public static void main(String[] args) {
        /*-------- 1.账号管理json --------*/
        String paramJson="{"+
                "   \"Identifier\":\"test0922\"," +
                "   \"Nick\":\"test0922\"" +
                "}";
        String paramMulJson="{"+
                "   \"Accounts\":[\"test0925\",\" test0924\"]"+
                "}";
        String paramkick="{"+
                "   \"Identifier\":\"test0922\""+
                "}";

        /*这测试使用固定管理员：admin，固定sig：。。。同理可传入参数*/
        /*账号导入*/
        TlsAccountEntity tlsAccountEntity=new TlsAccountEntity();
        tlsAccountEntity.setIdentifier("test1");

//        /*账号批量导入*/
//        List<String> list=new ArrayList<>();
//        list.add("test12");
//        list.add("test123");

//        TlsResultEntity tlsApiResultEntity=accountImport("admin","eJxlj0FPgzAAhe-8iqZXjWvBQjTZYVNnlk4DE0V3IQ0tpC6UAh10GP*7iksk8V2-7*XlfTgAABhvni5YllUHZVJz1AKCawARPP*DWkueMpN6Df8HhdWyESnLjWhGiAkhLkJTR3KhjMzlyWC8lGqCW75Px43f-uV3GV*5BE8VWYzw4S66Wd8HZh83NNZ1GVnbnSFKwnzVUkR9OrNJ1*822fsstMktXchlXFe75-K1WHeDXVGvL4YXb2iV3ZJtpWiUtMtDUIeLR-bWz*eTSSNLcTqEfOQHgT*91ImmlZUaBRdhgl0P-QQ6n84Xvq9emg__",
//                tlsAccountEntity);
//        TlsResultEntity tlsApiResultEntity=accountMulImport("admin","eJxlj0FPgzAAhe-8iqZXjWvBQjTZYVNnlk4DE0V3IQ0tpC6UAh10GP*7iksk8V2-7*XlfTgAABhvni5YllUHZVJz1AKCawARPP*DWkueMpN6Df8HhdWyESnLjWhGiAkhLkJTR3KhjMzlyWC8lGqCW75Px43f-uV3GV*5BE8VWYzw4S66Wd8HZh83NNZ1GVnbnSFKwnzVUkR9OrNJ1*822fsstMktXchlXFe75-K1WHeDXVGvL4YXb2iV3ZJtpWiUtMtDUIeLR-bWz*eTSSNLcTqEfOQHgT*91ImmlZUaBRdhgl0P-QQ6n84Xvq9emg__",
//                list );

        /*账号登录状态失效*/
//        TlsResultEntity tlsApiResultEntity=accountKick("admin",(TlsSigUtil.genSig("admin")).getSig(),tlsAccountEntity );

        /*-------- 2.群组管理json --------*/
        String paramGroupList="{\n" +
                "    \"Limit\": 1000,  \n" +
                "    \"Next\": 0,   \n" +
                "    \"GroupType\" : \"Public\" " +
                "}";
        // GroupType：拉取哪种群组形态，不填为拉取所有

        /*获取群组列表*/
//        TlsGetGroupEntity tlsGroupEntity=new TlsGetGroupEntity();
//        tlsGroupEntity.setGroupType("AVChatRoom");
//        TlsResultEntity tlsApiResultEntity=groupList("admin",(TlsSigUtil.genSig("admin")).getSig(),tlsGroupEntity );

        /*创建群组-基础形式*/
//        TlsGroupEntity tlsGroupEntity2=new TlsGroupEntity();
//        tlsGroupEntity2.setType("AVChatRoom");
//        tlsGroupEntity2.setName("g2017");
//        TlsResultEntity tlsApiResultEntity=createGroup("admin",(TlsSigUtil.genSig("admin")).getSig(),tlsGroupEntity2 );

        /*获取群组详细资料*/
        List<String> list=new ArrayList<>();
        list.add("@TGS#aFRASB5EX");
        list.add("@TGS#aUSE3E5EO");
        TlsResultEntity tlsApiResultEntity=getGroupInfo("admin",(TlsSigUtil.genSig("admin")).getSig(),list );


//        /*添加群组成员*/
//        TlsGroupEntity tlsGroupEntity2=new TlsGroupEntity();
//        tlsGroupEntity2.setGroupId("@TGS#23IEBB5E4");
//
//        List<TlsMemberEntity> list=new ArrayList<TlsMemberEntity>();
//        TlsMemberEntity member_account=new TlsMemberEntity();
//        member_account.setMember_Account("test12");
//        list.add(member_account);
//
//        member_account=new TlsMemberEntity();
//        member_account.setMember_Account("test123");
//        list.add(member_account);
//        tlsGroupEntity2.setMemberList(list);
//
//        TlsResultEntity tlsApiResultEntity=addGroupMember("admin",(TlsSigUtil.genSig("admin")).getSig(),tlsGroupEntity2 );



        System.out.println(tlsApiResultEntity.toString());
    }

}
