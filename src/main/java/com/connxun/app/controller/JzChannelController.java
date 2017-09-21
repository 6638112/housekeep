package com.connxun.app.controller;

import com.connxun.app.dto.JzChannelDTO;
import com.connxun.app.entity.JsonEntity;
import com.connxun.app.entity.Jzchannel;
import com.connxun.app.searchVO.JzChannelSearchVO;
import com.connxun.app.service.JzChannelService;
import com.connxun.util.qcloud.LiveAddressCreate;
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

    /**
     * 给datatables返回数据，按照格式   详情看http://datatables.club/manual/server-side.html
     *
     * @param searchVO 查询VO
     */
    @RequestMapping(value = "getList", method = RequestMethod.GET)
    @ResponseBody
    public JsonEntity getList(JzChannelSearchVO searchVO) {
        searchVO.setChannelStatus(0);
        List<Jzchannel> list = jzChannelService.getList(searchVO);
        if (list.size()>0){

            List<JzChannelDTO> jzChannelDTOList = new ArrayList<JzChannelDTO>();

            for (Jzchannel jzchannel:list){
                JzChannelDTO jzChannelDTO = new JzChannelDTO();
                BeanUtils.copyProperties(jzchannel, jzChannelDTO);
                jzChannelDTO.setChannel_url(LiveAddressCreate.getLivePlayAddress(jzChannelDTO.getChannel_id(),800,600));
                // TODO: 2017-09-20 添加返回频道主播

                jzChannelDTOList.add(jzChannelDTO);
            }
            json = objectToJson(jzChannelDTOList);
            json.setExt(list.size() + "");
        }else {
            json=objectToJson(new ArrayList<>());
        }
        return json;
    }

}
