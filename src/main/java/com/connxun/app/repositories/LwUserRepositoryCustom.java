package com.connxun.app.repositories;


import com.connxun.app.entity.LwUser;
import com.connxun.app.searchVO.LwUserSearchVO;

import java.util.List;

/**
 * 用户自定义Repository
 * Created by Mac on 2017/6/11.
 */
public interface LwUserRepositoryCustom {
    List<LwUser> getList(LwUserSearchVO searchVO);

    LwUser getPhone(String phone);

    List<LwUser> search(LwUserSearchVO search);

    List<LwUser> getInvitationList(LwUserSearchVO lwUserSearchVO);

    LwUser isInvite(Integer inviteCode);


}
