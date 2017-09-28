package com.connxun.app.controller;

import com.connxun.app.dto.JzChannelDTO;
import com.connxun.app.dto.JzRoomSigDTO;
import com.connxun.app.entity.JsonEntity;
import com.connxun.app.entity.JzChannel;
import com.connxun.app.entity.JzUser;
import com.connxun.app.searchVO.JzChannelSearchVO;
import com.connxun.app.service.JzChannelService;
import com.connxun.app.service.JzUserService;
import com.connxun.util.mail.PwdMailSender;
import com.connxun.util.qcloud.LiveAddressCreate;
import com.connxun.util.redis.RedisUtil;
import com.tls.sigcheck.TlsSigUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-18 14:14
 * @Comments：直播间（频道）管理
 */
@RestController
@RequestMapping(value = "/jz")
public class JzChannelController extends AppBaseController  {

    @Autowired
    private JzChannelService jzChannelService;
    @Autowired
    private JzUserService lwUserService;
    @Autowired
    private PwdMailSender pwdMailSender;

    // TODO: 2017-09-25 频道关联主播没做
    /**
     * 给datatables返回数据，按照格式   详情看http://datatables.club/manual/server-side.html
     * 前端用户请求频道列表
     * @param searchVO 查询VO
     */
    @ApiOperation(value="频道列表获取接口",notes = "前端用户获取频道列表")
    @RequestMapping(value = "getList", method = RequestMethod.GET)
    @ResponseBody
    public JsonEntity getList(JzChannelSearchVO searchVO) {

        searchVO.setChannelStatus(0);
        // TODO: 2017-09-20 添加返回频道主播——关联查询
        List<JzChannel> list = jzChannelService.getList(searchVO);
        if (list.size()>0){
            json = objectToJson(list);
            json.setExt(list.size() + "");
        }else {
            json=objectToJson(new ArrayList<>());
        }
        return json;
    }


    /**
     * 根据频道ID获取JzChannelDTO
     * @param channelId
     * @return
     */
    @ApiOperation(value="频道信息获取接口",notes = "前端用户获取频道信息")
    @RequestMapping(value = "getChannelById", method = RequestMethod.GET)
    @ResponseBody
    public JsonEntity getChannelById(@ApiParam(required = true, name = "channelId", value = "频道ID")Integer channelId) {

        JzChannel jzchannel = jzChannelService.findOne(channelId);
        JzChannelDTO jzChannelDTO = null;
        if (jzchannel!=null){
            jzChannelDTO=new JzChannelDTO();
            BeanUtils.copyProperties(jzchannel, jzChannelDTO);
            jzChannelDTO.setChannelUrl(LiveAddressCreate.getLivePlayAddress(jzChannelDTO.getChannelId(),0,0));
            json = objectToJson(jzChannelDTO);
        }else {
            json=objectToJson(new JzChannelDTO());
        }
        return json;
    }

    /**
     * 获取sig及其他验证参数
     * @param userId 用户ID
     * @param token
     * @return
     */
    @ApiOperation(value="获取sig及其他验证参数")
    @RequestMapping(value = "getSig", method = RequestMethod.GET)
    @ResponseBody
    public JsonEntity getSig(@ApiParam(required = true, name = "userId", value = "用户ID")Integer userId,
                             @ApiParam(required = true, name = "token", value = "token")String token) {
        //判断token是否正确
        if (RedisUtil.contain(userId + "")&&(token+"").equals(RedisUtil.get(userId+""))){

            JzUser sysUser = lwUserService.findOne(userId);
            JzRoomSigDTO jzRoomSigDTO=new JzRoomSigDTO();
            jzRoomSigDTO.setIdentifier(userId);
            jzRoomSigDTO.setIdentifierNick(sysUser.getNickName());
            jzRoomSigDTO.setUserSig(TlsSigUtil.genSig(userId+"").getSig());
            jzRoomSigDTO.setHeadurl("");
            json = objectToJson(jzRoomSigDTO);

        }else{
            json=objectToJson(null);
        }

        return json;
    }

}
