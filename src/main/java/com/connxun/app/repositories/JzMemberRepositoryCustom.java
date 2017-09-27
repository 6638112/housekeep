package com.connxun.app.repositories;

import com.connxun.app.entity.JzMember;
import com.connxun.app.searchVO.JzMemberSearchVO;

import java.util.List;

/**
 * Created by anna on 2017-09-27.
 */
public interface JzMemberRepositoryCustom {

    List<JzMember> getList(JzMemberSearchVO searchVO);
}
