package com.connxun.cms.controller;

import com.connxun.app.entity.JzMember;
import com.connxun.app.searchVO.JzMemberSearchVO;
import com.connxun.app.service.JzMemberService;
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
 * @Date：2017-09-27 19:35
 * @Comments：群组成员
 */
@Controller
@RequestMapping("cms/member")
public class CmsJzMemberController  extends BaseController {

    @Autowired
    private JzMemberService jzMemberService;

    /**
     * 进入index页面，
     *
     * @return ModelAndView 页面路径和参数
     */
    @RequestMapping(value = {"", "index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("/cms/member/index");
        return mv;
    }

    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public ModelAndView toAdd(Integer type) {
        ModelAndView mv = new ModelAndView("/cms/member/add");

        return mv;
    }

    /**
     * 给datatables返回数据，按照格式   详情看http://datatables.club/manual/server-side.html
     *
     * @param searchVO 查询VO
     */
    @RequestMapping(value = "getList", method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult getList(JzMemberSearchVO searchVO) {
        DataTablesResult result = new DataTablesResult();
        List<JzMember> list = jzMemberService.getList(searchVO);
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
    public String save(JzMember jzMember) {
        int user_id = getCurrentUser().getUser_id();//调用父类的方法获取当前用户session
        if (StringUtil.isNullOrEmpty(jzMember.getId() + "")) {
//            JzMember.setCreateTime(new Date());//如果第一次数据，没有id  曾新增一个创建人
        }
//        JzMember.setUpdateUser(user_id);

        jzMemberService.save(jzMember);
        return "redirect:/cms/channel/index";
    }

    /**
     * 根据ID查询对象
     *
     * @param id 用户ID
     */
    @RequestMapping(value = "findOne", method = RequestMethod.GET)
    @ResponseBody
    public JzMember findOne(int id) {
        return jzMemberService.findOne(id);
    }

    /**
     * 根据id删除对象
     *
     * @param id 部门id
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public void delete(int id) {
        jzMemberService.delete(id);
    }

    /**
     * 查询所有
     */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<JzMember> findAll() {
        return jzMemberService.findAll();
    }

    /**
     * 跳转更新页面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "toUpdate", method = RequestMethod.GET)
    public ModelAndView toUpdate(Integer id) {
        JzMember lwTeacher = jzMemberService.findOne(id);
        ModelAndView mv = new ModelAndView("/cms/member/update");
        mv.addObject("jzMember", lwTeacher);
        return mv;

    }

    /**
     * 更新云端群组信息
     *
     * @return
     */
//    @RequestMapping(value = "sycQCloudGroup", method = RequestMethod.GET)
//    @ResponseBody
//    public JsonResult sycQCloudChannel() {
//        /*设置查询群组类型*/
//        TlsGetGroupEntity tlsGroupEntity = new TlsGetGroupEntity();
//        // TODO: 2017-09-27  群组类型做了限定
//        /*这里限定为为互动直播聊天 群组类型——不填则获取所有群组*/
//        tlsGroupEntity.setGroupType("AVChatRoom");
//
//        /*sig鉴权——这里必须要管理员账号，在properties中已经配置了live.admin项可以获取*/
//        OpeProperties opeProperties = new OpeProperties();
//        String adminAccount = opeProperties.GetValueByKey("","live.admin").trim();
//        /*获取群组ID list*/
//        TlsResultEntity tlsResultEntity = TlsApiUtil.groupList(adminAccount,
//                TlsSigUtil.genSig(adminAccount).getSig(), tlsGroupEntity);
//
//        if ("OK".equals(tlsResultEntity.getActionStatus())) {
//            List<TlsGroupEntity> tlsGroupEntities = tlsResultEntity.getGroupIdList();
//            /*提取群组ID list*/
//            List<String> groupIdList=new ArrayList<String>();
//            for (TlsGroupEntity t:
//                    tlsGroupEntities) {
//                groupIdList.add(t.getGroupId());
//            }
//            /*获取群组详细信息*/
//            TlsResultEntity tlsResultEntity2 = TlsApiUtil.getGroupInfo(adminAccount,
//                    TlsSigUtil.genSig(adminAccount).getSig(), groupIdList);
//            tlsGroupEntities=tlsResultEntity2.getGroupInfo();
//            /*群组信息转换*/
//            for (TlsGroupEntity t:
//                    tlsGroupEntities) {
//
//                JzMember JzMember=new JzMember();
//                /*部分参数复制*/
//                BeanUtils.copyProperties(t, JzMember);
//                /*UTC时间参数转换*/
//                JzMember.setCreateTime(DateUtil.getUTCtoGMT(t.getCreateTime()));
//                JzMember.setLastInfoTime(DateUtil.getUTCtoGMT(t.getLastInfoTime()));
//                JzMember.setLastMsgTime(DateUtil.getUTCtoGMT(t.getLastMsgTime()));
//                JzMemberService.save(JzMember);
//                /*同步导入群组成员*/
//
//            }
//            return new JsonResult(true, "同步更新云端数据成功" );
//
//        } else {
//            return new JsonResult(false, "同步更新云端数据失败" + tlsResultEntity.getErrorInfo());
//        }
//
//
//    }
}
