package com.connxun.app.controller;


import com.connxun.app.entity.BeeCloud;
import com.connxun.app.entity.Code;
import com.connxun.app.entity.JsonEntity;
import com.connxun.app.entity.LwUser;
import com.connxun.app.searchVO.LwInvitationSearchVO;
import com.connxun.app.searchVO.LwUserSearchVO;
import com.connxun.app.service.LwUserService;
import com.connxun.util.aliyun.sendsms.AliyunSms;
import com.connxun.util.easemob.tool.JsonTool;
import com.connxun.util.redis.RedisUtil;
import com.connxun.util.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mac on 2017/6/11.
 */
@Controller
@RequestMapping(value = "/lwgk")
public class LwLoginController extends AppBaseController {
    private static Logger logger = LoggerFactory.getLogger("payLog");
    //0正常 1删除  2 禁用 3 审核中
    private final LwUserService lwUserService;
    private Integer orderDel;

    public Integer getOrderDel() {
        return orderDel;
    }

    public void setOrderDel(Integer orderDel) {
        this.orderDel = orderDel;
    }


//    @Autowired
//    private LwInvitationService lwInvitationService;
//    @Autowired
//    private LwOrderService lwOrderService;
//    @Autowired
//    private LwUserMsgService lwUserMsgService;


    @Autowired
    public LwLoginController(LwUserService lwUserService) {
        this.lwUserService = lwUserService;
    }

    @RequestMapping(value = "/nll")
    public void null_() {
        Object obj = null;
        obj.toString();
    }

    // 手机登录
//    todo 判断是否手机登录
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public JsonEntity login(HttpServletRequest request, HttpServletResponse response, String phone, String password, Integer isApp) {
       /* if (getOrderDel() == null) {
            CronTriggerRunner.orderDel();
            setOrderDel(1);

        }*/
        System.out.println(getOrderDel() + "========================================================");

        if (StringUtil.isNullOrEmpty(phone) || StringUtil.isNullOrEmpty(password)) {
            return booleanToJson(false, "参数错误");
        } else {

            LwUser user = lwUserService.getPhone(phone);

//      手机号校验
            if (user != null) {
//            用户状态
                if (user.getState() != 2) {
//                用户密码
                    if (user.getPassword().equals(StringUtil.getMD5(password))) {
                        lwUserService.updateLogin(user, request, isApp);

                        String ip = StringUtil.getIp(request);
                        user.setPassword(null);
                        user.setToken(StringUtil.getNonceStr());
                        request.getSession().setAttribute("userSession", user);
                        RedisUtil.set(user.getId() + "", user.getToken());
                        return objectToJson(user);
                    } else {
                        return ErrorCode(Code.LOGINFAIL);
                    }
                } else {
                    return ErrorCode(Code.AUDITFAIL);
                }
            } else {
                return ErrorCode(Code.PHONEFAIL);
            }
        }

    }

//    //    微信登录
//    @RequestMapping(value = "/openLogin", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonEntity openLogin(String openId) {
//        LwUserSearchVO searchVO = new LwUserSearchVO();
//        searchVO.setOpenId(openId);
//        searchVO.setLoginType(1);
//        LwUser user = thirdLogin(searchVO);
//        if (user != null) {
//            user.setPassword(null);
//            user.setToken(StringUtil.getNonceStr());
//            RedisUtil.set(user.getId() + "", user.getToken());
//            return objectToJson(user);
//
//        } else {
//            return booleanToJson(false);
//        }
//
//    }
//
//    //    微博登录
//    @RequestMapping(value = "/wbLogin", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonEntity wbLogin(String wbId) {
//        LwUserSearchVO searchVO = new LwUserSearchVO();
//        searchVO.setWbId(wbId);
//        searchVO.setLoginType(2);
//        LwUser user = thirdLogin(searchVO);
//        if (user != null) {
//            user.setPassword(null);
//            user.setToken(StringUtil.getNonceStr());
//            RedisUtil.set(user.getId() + "", user.getToken());
//            return objectToJson(user);
//
//        } else {
//            return booleanToJson(false);
//        }
//
//    }
//
//    //    qq登录
//    @RequestMapping(value = "/qqLogin", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonEntity qqLogin(String qqId) {
//        LwUserSearchVO searchVO = new LwUserSearchVO();
//
//        searchVO.setOpenId(qqId);
//        searchVO.setLoginType(3);
//        LwUser lwUser = thirdLogin(searchVO);
//        LwUser user = thirdLogin(searchVO);
//        if (user != null) {
//            user.setPassword(null);
//            user.setToken(StringUtil.getNonceStr());
//            RedisUtil.set(user.getId() + "", user.getToken());
//            return objectToJson(user);
//
//        } else {
//            return booleanToJson(false);
//        }
//
//    }
//
//    public LwUser thirdLogin(LwUserSearchVO searchVO) {
//        searchVO.setPage(0);
//        List<LwUser> list = lwUserService.getList(searchVO);
//        if (list.size() > 0) {
//            return list.get(0);
//        } else {
//            return null;
//        }
//
//
//    }

    /**
     * 获取验证码
     *
     * @param phone //     * @param state 1 注册验证码   2 修改密码验证码  3 直接登录
     * @return
     */
    @RequestMapping(value = "/getCaptch", method = RequestMethod.GET)
    @ResponseBody
    public JsonEntity recaptch(String phone, int state) {
        System.out.println("----------------------------------");
        LwUser user = lwUserService.getPhone(phone);
        json = ErrorCode(Code.FAIL);
        if (state == 1) {

            if (user != null) {
                json = ErrorCode(Code.PHONEREPEAT);
            } else {
//            TODO 发送验证码
                String captcher = StringUtil.buildRandom(6) + "";
                AliyunSms.sendSms(phone, captcher);

                RedisUtil.set(phone + "1", captcher);
                System.out.println("===============" + RedisUtil.get(phone + "1") + "");
                json = objectToJson(captcher);


            }

        }
        if (state == 2) {
            if (user == null) {
                json = ErrorCode(Code.PHONEFAIL);
            } else {
//             TODO 发送验证码
                String captcher = StringUtil.buildRandom(6) + "";
                AliyunSms.sendSms(phone, captcher);

                RedisUtil.set(phone + "2", captcher);
                System.out.println("===============" + RedisUtil.get(phone + "2") + "");
                json = objectToJson(captcher);

            }

        }

        if (state == 3) {
            if (user == null) {
                json = ErrorCode(Code.PHONEFAIL);
            } else {
//            TODO 发送验证码
                String captcher = StringUtil.buildRandom(6) + "";
                AliyunSms.sendSms(phone, captcher);

                RedisUtil.set(phone + "3", captcher);
                System.out.println("===============" + RedisUtil.get(phone + "3") + "");
                json = objectToJson(captcher);

            }

        }
        return json;

    }

    @RequestMapping(value = "/regMsg", method = RequestMethod.POST)
    @ResponseBody
    public JsonEntity regMsg(Integer userNo) {
        LwUser lwUser = lwUserService.findOne(userNo);
        if (lwUser != null) {
            String msg = TempletUtil.reg(userNo + "");
        }
        return booleanToJson(true);

    }

    //注册
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    @ResponseBody
    public JsonEntity reg(HttpServletRequest request, HttpServletResponse response, String phone,
                          String password, String captch, Integer inviteCode) {
        JsonEntity json = new JsonEntity();
        LwInvitationSearchVO vo = new LwInvitationSearchVO();
        vo.setState(0);
        // todo 邀请码鉴定
        int guide = 0;
        int invitationNo = 0;
//        if (inviteCode != null) {
//            inviteCode = inviteCode - 10000;
//
//            LwUser lwUser = lwUserService.findOne(inviteCode);
//            if (lwUser != null) {
//                guide = inviteCode;
//
//                List<LwInvitation> lwInvitations = lwInvitationService.getList(vo);
//                if (lwInvitations != null && lwInvitations.size() > 0) {
//                    invitationNo = lwInvitations.get(0).getId();
//                }
//            }
//        }
        if (StringUtil.isNotNullOrEmpty(password) && StringUtil.isNotNullOrEmpty(phone)) {


            String sysCaptch = RedisUtil.get(phone + "1");
            if (!StringUtil.isNotNullOrEmpty(sysCaptch)) {
                json = ErrorCode(Code.FAIL);
            } else {
                if (sysCaptch.equals(captch)) {
                    LwUser user = new LwUser();
                    user.setPhone(phone);
                    user.setPassword(StringUtil.getMD5(password));
//                    领路人
                    user.setGuide(guide);
//                    注册规则ID
                    user.setIntegral(0);
                    user.setInvitationNo(invitationNo);
                    user.setIcon("/proPic/20170730/20170730102138563982.jpg");
//                    user.setInviteCode();
                    user = lwUserService.save(user);
                    if (user != null) {
//                        推送消息

                        user.setToken(StringUtil.getNonceStr());
                        /*清空redis中的验证码————保证每个验证码只能被使用一次*/
//                        RedisUtil.set(phone + "1", StringUtil.getNonceStr());
                        /*保存用户登录token*/
                        RedisUtil.set(user.getId() + "", user.getToken());
                        json = objectToJson(user);
                    }
                } else {
                    json = ErrorCode(Code.CAPTCHFAIL);
                }
            }
        } else {
            json = ErrorCode(Code.FAIL);
        }
        return json;

    }

    //修改密码

    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public JsonEntity updatePwd(HttpServletRequest request, HttpServletResponse response, String phone,
                                String password, String captch) {
        JsonEntity json = new JsonEntity();
        if (StringUtil.isNotNullOrEmpty(password) && StringUtil.isNotNullOrEmpty(phone)) {
            String sysCaptch = RedisUtil.get(phone + "2");
            LwUser user = lwUserService.getPhone(phone);
            if (sysCaptch.equals(captch) && user != null) {
                user.setPassword(password);
                user = lwUserService.save(user);
                if (user != null) {
                    user.setPassword(null);
                    user.setToken(StringUtil.getNonceStr());
                    RedisUtil.set(phone + "2", StringUtil.getNonceStr());
                    RedisUtil.set(user.getId() + "", user.getToken());

                    json = objectToJson(user);
                } else {
                    json = ErrorCode(Code.FAIL);
                }
            } else {
                json = ErrorCode(Code.CAPTCHFAIL);
            }
        } else {
            json = ErrorCode(Code.FAIL);
        }
        return json;

    }

    //    验证码登录
    @RequestMapping(value = "/loginCaptch", method = RequestMethod.GET)
    @ResponseBody
    public JsonEntity loginCaptch(String phone, String captch) {

        LwUser lwUser = lwUserService.getPhone(phone);
        if (lwUser != null) {
            String sysCaptch = "123456";
//            String sysCaptch = RedisUtil.get(phone + "3", String.class);
            if (sysCaptch.equals(captch)) {
                json = objectToJson(lwUser);

            } else {
                json = ErrorCode(Code.CAPTCHFAIL);
            }
        } else {
            json = ErrorCode(Code.PHONEFAIL);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/tokenFail")
    public JsonEntity tokenFail() {

        return ErrorCode(Code.TOKENFAIL);
    }

    //    pc端请求 返回时间 与UUID
    @RequestMapping(value = "/requestCode", method = RequestMethod.GET)
    @ResponseBody
    public JsonEntity requestCode() {
        Map<String, String> map = new HashMap<String, String>();
        long time = System.currentTimeMillis();
        String uuid = StringUtil.getMD5_2(String.valueOf(time + StringUtil.getNonceStr()));
        map.put("code", String.valueOf(time));
        map.put("codeUUID", uuid);
        RedisUtil.set(String.valueOf(time), uuid);

        return objectToJson(map);
    }
//    pc 端轮训

    @RequestMapping(value = "/loginCode", method = RequestMethod.GET)
    @ResponseBody
    public JsonEntity loginCode(LwUserSearchVO vo) {
        String userNo = RedisUtil.get(vo.getCode()) + "";


        json = objectToJson(false);
        if (StringUtil.isInteger(userNo)) {
            LwUser lwUser = lwUserService.findOne(Integer.parseInt(userNo));
            if (lwUser != null) {
                RedisUtil.set(vo.getCode(), "");
                lwUser.setPassword(null);
                lwUser.setQqId(null);
                lwUser.setWbId(null);
                lwUser.setOpenId(null);
                String token = RedisUtil.get(userNo + "");
                lwUser.setToken(token);
                RedisUtil.set(lwUser.getId() + "", lwUser.getToken(), 86400);
                json = objectToJson(lwUser);


            }
        }
        return json;

    }


    @RequestMapping("/getRedisValue")
    @ResponseBody
    public JsonEntity getRedisValue(HttpServletRequest request, HttpServletResponse response, String userNo) {
        String token = RedisUtil.get(userNo);

        return objectToJson(token);

    }

    //    邀请码 是否存在
    @RequestMapping(value = "isInvite")
    @ResponseBody
    public JsonEntity isInvite(Integer inviteCode) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        LwUser lwUser = lwUserService.isInvite(inviteCode);
        if (lwUser != null) {
            map.put("state", 1);
            json = objectToJson(map);

        } else {

            map.put("state", 0);
            json = objectToJson(map);
        }

        return json;
    }


//    @ResponseBody
//    @RequestMapping(value = "/webhook")
//    public void webhook(HttpServletRequest request, HttpServletResponse response) {
//        StringBuffer json = new StringBuffer();
//        String line = null;
//        try {
//            request.setCharacterEncoding("utf-8");
//            BufferedReader reader = request.getReader();
//            while ((line = reader.readLine()) != null) {
//                json.append(line);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        BeeCloud beeCloud = new BeeCloud();
//        System.out.println("---------" + json.toString());
//        try {
//            beeCloud = (BeeCloud) JsonTool.read(json.toString(), BeeCloud.class);
//            System.out.println("----=========*********------" + beeCloud.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        logger.info("beeCloud_________" + beeCloud.toString());
//        // TODO: 2017-09-19
//        if (StringUtil.isNotNullOrEmpty(beeCloud.getSignature())) {
//
//            String state = lwOrderService.addwebhook(beeCloud.getSignature(), beeCloud.getTransaction_id()
//                    , beeCloud.getTransaction_type(), beeCloud.getChannel_type(), beeCloud.getTransaction_fee());
//            response.setHeader("Content-type", "text/html;charset=UTF-8");//向浏览器发送一个响应头，设置浏览器的解码方式为UTF-8
//            OutputStream stream = null;
//            try {
//                stream = response.getOutputStream();
//                stream.write(state.getBytes("UTF-8"));
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }


    @ResponseBody
    @RequestMapping(value = "/webhookTest")
    public void webhookTest(HttpServletRequest request, HttpServletResponse response) {
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            request.setCharacterEncoding("utf-8");
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeeCloud beeCloud = new BeeCloud();
        System.out.println("---------" + json.toString());
        try {
            beeCloud = (BeeCloud) JsonTool.read(json.toString(), BeeCloud.class);
            System.out.println("----------" + beeCloud.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (true) {
            String state = "success";

            response.setHeader("Content-type", "text/html;charset=UTF-8");//向浏览器发送一个响应头，设置浏览器的解码方式为UTF-8

            OutputStream stream = null;
            try {
                stream = response.getOutputStream();
                stream.write(state.getBytes("UTF-8"));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
