package com.connxun.app.repositories;


import com.connxun.app.entity.JzUser;
import com.connxun.app.searchVO.JzUserSearchVO;

import java.util.List;

/**
 * 用户自定义Repository
 * Created by Mac on 2017/6/11.
 */
public interface JzUserRepositoryCustom {
    List<JzUser> getList(JzUserSearchVO searchVO);

    JzUser getPhone(String phone);

    List<JzUser> search(JzUserSearchVO search);

    List<JzUser> getInvitationList(JzUserSearchVO JzUserSearchVO);

    JzUser isInvite(Integer inviteCode);


}
