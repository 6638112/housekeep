package com.connxun.app.controller;


import com.connxun.app.dto.LwVoucherDTO;
import com.connxun.app.entity.JsonEntity;
import com.connxun.app.entity.LwVoucher;
import com.connxun.app.searchVO.LwVoucherSearchVO;
import com.connxun.app.service.LwVoucherService;
import com.connxun.util.redis.RedisClient;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 优惠券
 * Created by Mac on 2017/7/5.
 */
//@Api(value = "LwVocherController", description = "代金券api")
@RestController
@RequestMapping(value = "/lw")
public class LwVocherController extends AppBaseController {

    @Autowired
    private RedisClient redisClient;
    @Autowired
    private  LwVoucherService lwVoucherService;


    @ApiOperation(value = "代金券list获取", notes = "前端用户获取代金券")
    @RequestMapping(value = "voucher/getList", method = RequestMethod.GET)
    public JsonEntity getList(@ApiParam(required = true, name = "searchVO", value = "基础查询参数") LwVoucherSearchVO searchVO) {
//        RedisUtil.set("WWWWW","123");
        redisClient.set("QQQQQ","123123");
        searchVO.setState(1);
        searchVO.setIsApp(1);
        List<LwVoucher> lwVouchers = lwVoucherService.getList(searchVO);
        int size = lwVouchers.size();
        if (size > 0) {
            List<LwVoucherDTO> lwVoucherDTOS = new ArrayList<LwVoucherDTO>();

            for (LwVoucher lwVoucher : lwVouchers) {
                LwVoucherDTO lwVoucherDTO = new LwVoucherDTO();
                BeanUtils.copyProperties(lwVoucher, lwVoucherDTO);
                lwVoucherDTOS.add(lwVoucherDTO);

            }
            json = objectToJson(lwVoucherDTOS);
            json.setExt(size + "");
        } else {
            json = objectToJson(new ArrayList<>());
        }
        return json;
    }


}
