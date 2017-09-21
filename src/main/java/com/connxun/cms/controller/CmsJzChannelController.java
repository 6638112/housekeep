package com.connxun.cms.controller;


import com.connxun.app.entity.Jzchannel;
import com.connxun.app.jsonBean.ChannelListBean;
import com.connxun.app.searchVO.JzChannelSearchVO;
import com.connxun.app.service.JzChannelService;
import com.connxun.common.controller.BaseController;
import com.connxun.common.vo.JsonResult;
import com.connxun.util.datatables.DataTablesResult;
import com.connxun.util.json.JsonUtil;
import com.connxun.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.connxun.util.qcloud.LiveGetInfo.LiveChannelGetChannelList;

/**
 * 课程章节
 * Created by chengpeng on 2017/7/11.
 */
@Controller
@RequestMapping("cms/channel")
public class CmsJzChannelController extends BaseController {

    //0正常 1删除  
    @Autowired
    private JzChannelService jzChannelService;

    /**
     * 进入index页面，
     *
     * @return ModelAndView 页面路径和参数
     */
    @RequestMapping(value = {"", "index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/cms/channel/index");
        return mv;
    }
    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd(Integer type) {
        ModelAndView mv = new ModelAndView("/cms/channel/add");

        return mv;
    }

    /**
     * 给datatables返回数据，按照格式   详情看http://datatables.club/manual/server-side.html
     *
     * @param searchVO 查询VO
     */
    @RequestMapping(value = "getList", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult getList(JzChannelSearchVO searchVO) {
        DataTablesResult result = new DataTablesResult();
        List<Jzchannel> list = jzChannelService.getList(searchVO);
        result.setDraw(searchVO.getDraw());//每个字段在实体中都有注释
        result.setRecordsFiltered(searchVO.getTotal());//每个字段在实体中都有注释
        result.setRecordsTotal(searchVO.getTotal());//每个字段在实体中都有注释
        result.setData(list);//每个字段在实体中都有注释
        return result;
    }

    /**
     * 新增/修改
     *
     * @param
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Jzchannel jzchannel) {
        int user_id = getCurrentUser().getUser_id();//调用父类的方法获取当前用户session
        if (StringUtil.isNullOrEmpty(jzchannel.getId() + "")) {
            jzchannel.setCreate_mode(""+user_id);//如果第一次数据，没有id  曾新增一个创建人
        }
//        lwTeacher.setUpdateUser(user_id);

        jzChannelService.save(jzchannel);
        return "redirect:/cms/channel/index.do";
    }

    /**
     * 根据ID查询对象
     *
     * @param id 用户ID
     */
    @RequestMapping(value = "findOne", method = RequestMethod.GET)
    @ResponseBody
    public Jzchannel findOne(int id) {
        return jzChannelService.findOne(id);
    }

    /**
     * 根据id删除对象
     *
     * @param id 部门id
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public void delete(int id) {
        jzChannelService.delete(id);
    }

    /**
     * 查询所有
     */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Jzchannel> findAll() {
        return jzChannelService.findAll();
    }

    /**
     * 跳转更新页面
     * @param id
     * @return
     */
    @RequestMapping(value = "toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(Integer id ) {
        Jzchannel lwTeacher = jzChannelService.findOne(id);
        ModelAndView mv = new ModelAndView("/cms/channel/update");
        mv.addObject("lwTeacher", lwTeacher);
        return mv;

    }

    /**
     * 更新云端频道信息
     *
     * @return
     */
    @RequestMapping(value = "sycQCloudChannel", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult sycQCloudChannel() {
        String jsonResult=LiveChannelGetChannelList();
        ChannelListBean channelListBean=(ChannelListBean)JsonUtil.toObject(ChannelListBean.class,jsonResult);
        if (channelListBean.getRet()==0){
            List<Jzchannel> list=channelListBean.getOutput().getChannel_list();
            if (list.size()>0){
                for (Jzchannel jzchannel:
                     list) {
                    jzChannelService.save(jzchannel);
                }
            }
            return new JsonResult(true,"同步更新云端数据成功");
        }
        return new JsonResult(false,"同步更新云端数据失败");

    }
}
