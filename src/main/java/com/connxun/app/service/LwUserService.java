package com.connxun.app.service;


import com.connxun.app.entity.LwUser;
import com.connxun.app.repositories.LwUserRepository;
import com.connxun.app.searchVO.LwUserSearchVO;
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
public class LwUserService implements BaseService<LwUser, Integer> {

    private final LwUserRepository lwUserRepository;

    @Autowired
    public LwUserService(LwUserRepository lwUserRepository) {
        this.lwUserRepository = lwUserRepository;
    }

    @Override
    public <S extends LwUser> S save(S entity) {

        return lwUserRepository.save(entity);
    }

    public <S extends LwUser> Iterable<S> save(List<S> entity) {
        return lwUserRepository.save(entity);
    }

    @Override
    public LwUser findOne(Integer primaryKey) {
        return lwUserRepository.findOne(primaryKey);
    }

    @Override
    public List<LwUser> findAll() {
        return IterableUtils.toList(lwUserRepository.findAll());
    }

    @Override
    public long count() {
        return lwUserRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        lwUserRepository.delete(primaryKey);

    }

    public LwUser getPhone(String phone) {
        return lwUserRepository.getPhone(phone);
    }

    public List<LwUser> search(LwUserSearchVO search) {
        List<LwUser> liveUsers = lwUserRepository.search(search);
        return liveUsers;
    }

    public List<LwUser> getList(LwUserSearchVO searchVO) {
        return lwUserRepository.getList(searchVO);
    }


    public LwUser addIntegral(Integer userNo, int i) {
        LwUser user = lwUserRepository.findOne(userNo);


        if (user != null) {

            int integral = 0;
            if (user.getIntegral() != null) {
                integral = user.getIntegral();

            }

            user.setIntegral(integral + i);
            user = lwUserRepository.save(user);
        }


        return user;
    }

    public List<LwUser> getInvitationList(LwUserSearchVO lwUserSearchVO) {


        return lwUserRepository.getInvitationList(lwUserSearchVO);
    }

    // 修改登录时间
    public void updateLogin(LwUser lwUser, HttpServletRequest request, Integer isApp) {
        lwUser.setLoginDate(new Date());
        lwUser.setLoginIp(StringUtil.getIp(request));
        System.out.println("=-========================" + lwUser.getLoginIp());
        ;
        if (lwUser.getIsApp() != null && lwUser.getIsApp() == 1) {
            lwUser.setIsApp(1);
        }
        lwUserRepository.save(lwUser);

    }

    public void updateState(Integer id, Integer state) {
        LwUser lwUser = lwUserRepository.findOne(id);
        lwUser.setState(state);
        lwUserRepository.save(lwUser);


    }

    // 判断邀请码是否存在
    public LwUser isInvite(Integer inviteCode) {
        return lwUserRepository.isInvite(inviteCode);

    }

}
