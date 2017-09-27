package com.connxun.app.service;


import com.connxun.app.entity.JzUser;
import com.connxun.app.repositories.JzUserRepository;
import com.connxun.app.searchVO.JzUserSearchVO;
import com.connxun.common.service.BaseService;
import com.connxun.util.string.StringUtil;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Mac on 20Lw17/6/11.
 */
@Service
public class JzUserService implements BaseService<JzUser, Integer> {

    private final JzUserRepository JzUserRepository;

    @Autowired
    public JzUserService(JzUserRepository JzUserRepository) {
        this.JzUserRepository = JzUserRepository;
    }

    @Override
    public <S extends JzUser> S save(S entity) {

        return JzUserRepository.save(entity);
    }

    public <S extends JzUser> Iterable<S> save(List<S> entity) {
        return JzUserRepository.save(entity);
    }

    @Override
    public JzUser findOne(Integer primaryKey) {
        return JzUserRepository.findOne(primaryKey);
    }

    @Override
    public List<JzUser> findAll() {
        return IterableUtils.toList(JzUserRepository.findAll());
    }

    @Override
    public long count() {
        return JzUserRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        JzUserRepository.delete(primaryKey);

    }

    public JzUser getPhone(String phone) {
        return JzUserRepository.getPhone(phone);
    }

    public List<JzUser> search(JzUserSearchVO search) {
        List<JzUser> liveUsers = JzUserRepository.search(search);
        return liveUsers;
    }

    public List<JzUser> getList(JzUserSearchVO searchVO) {
        return JzUserRepository.getList(searchVO);
    }


    public JzUser addIntegral(Integer userNo, int i) {
        JzUser user = JzUserRepository.findOne(userNo);


        if (user != null) {

            int integral = 0;
            if (user.getIntegral() != null) {
                integral = user.getIntegral();

            }

            user.setIntegral(integral + i);
            user = JzUserRepository.save(user);
        }


        return user;
    }

    public List<JzUser> getInvitationList(JzUserSearchVO JzUserSearchVO) {


        return JzUserRepository.getInvitationList(JzUserSearchVO);
    }

    // 修改登录时间
    public void updateLogin(JzUser JzUser, HttpServletRequest request, Integer isApp) {
        JzUser.setLoginDate(new Date());
        JzUser.setLoginIp(StringUtil.getIp(request));
        System.out.println("=-========================" + JzUser.getLoginIp());
        ;
        if (JzUser.getIsApp() != null && JzUser.getIsApp() == 1) {
            JzUser.setIsApp(1);
        }
        JzUserRepository.save(JzUser);

    }

    public void updateState(Integer id, Integer state) {
        JzUser JzUser = JzUserRepository.findOne(id);
        JzUser.setState(state);
        JzUserRepository.save(JzUser);


    }

    // 判断邀请码是否存在
    public JzUser isInvite(Integer inviteCode) {
        return JzUserRepository.isInvite(inviteCode);

    }

}
