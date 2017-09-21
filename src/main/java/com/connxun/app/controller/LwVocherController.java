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


    @ApiOperation(value = "测试swagger", notes = "测试swagger")
//    @ApiParam(required = true, name = "test", value = "教程入参")
    @RequestMapping(value = "voucher/getList")
    public JsonEntity getList(@ApiParam(required = true, name = "searchVO", value = "教程入参") LwVoucherSearchVO searchVO) {
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

    @ApiOperation(value = "测试swagger2", notes = "测试swagger2")
//    @ApiParam(required = true, name = "test", value = "教程入参")
    @RequestMapping(value = "voucher/getList2",method = RequestMethod.GET)
    public JsonEntity getList2() {

        json.setResultCode("200");
        json.setMessage("qi请求成功");

        return json;
    }




}
