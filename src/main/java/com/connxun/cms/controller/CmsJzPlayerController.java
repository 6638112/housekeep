package com.connxun.cms.controller;

import com.connxun.app.entity.JzPlayer;
import com.connxun.app.searchVO.JzPlayerSearchVO;
import com.connxun.app.service.JzPlayerService;
import com.connxun.common.controller.BaseController;
import com.connxun.util.datatables.DataTablesResult;
import com.connxun.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-26 15:27
 * @Comments：主播控制器
 */
@Controller
@RequestMapping("cms/player")
public class CmsJzPlayerController extends BaseController{

    @Autowired
    private JzPlayerService jzPlayerService;

    /**
     * 进入index列表页
     * @return
     */
    @RequestMapping(value = {"", "index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/cms/player/index");
        return mv;
    }

    /**
     * 跳转新增界面
     * @param type
     * @return
     */
    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd(Integer type) {
        ModelAndView mv = new ModelAndView("/cms/player/add");

        return mv;
    }

    /**
     * 给datatable返回json
     * @param searchVO 查询参数
     * @return
     */
    @RequestMapping(value = "getList", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult getList(JzPlayerSearchVO searchVO) {
        DataTablesResult result = new DataTablesResult();
        List<JzPlayer> list = jzPlayerService.getList(searchVO);
        result.setDraw(searchVO.getDraw());
        result.setRecordsFiltered(searchVO.getTotal());
        result.setRecordsTotal(searchVO.getTotal());
        result.setData(list);
        return result;
    }

    /**
     * 新增/修改
     * @param jzPlayer 实体entity
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(JzPlayer jzPlayer) {
        int user_id = getCurrentUser().getUser_id();//调用父类的方法获取当前用户session
        if (StringUtil.isNullOrEmpty(jzPlayer.getId() + "")) {
            jzPlayer.setCreateUser(user_id);
        }
        jzPlayer.setUpdateUser(user_id);

        jzPlayerService.save(jzPlayer);
        return "redirect:/cms/player/index";
    }

    /**
     * 根据ID查询对象
     * @param id 主播ID
     * @return
     */
    @RequestMapping(value = "findOne", method = RequestMethod.GET)
    @ResponseBody
    public JzPlayer findOne(int id) {
        return jzPlayerService.findOne(id);
    }

    /**
     * 根据id删除对象（逻辑删除）
     * @param id 主播ID
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public void delete(int id) {
        jzPlayerService.delete(id);
    }

    /**
     * 查询全部对象
     * @return list
     */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<JzPlayer> findAll() {
        return jzPlayerService.findAll();
    }

    /**
     * 跳转更新页面
     * @param id
     * @return
     */
    @RequestMapping(value = "toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(Integer id ) {
        JzPlayer lwTeacher = jzPlayerService.findOne(id);
        ModelAndView mv = new ModelAndView("/cms/player/update");
        mv.addObject("jzPlayer", lwTeacher);
        return mv;

    }

}
