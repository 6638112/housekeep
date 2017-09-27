package com.connxun.app.repositories;

import com.connxun.app.entity.JzPlayer;
import com.connxun.app.searchVO.JzPlayerSearchVO;

import java.util.List;

/**
 * Created by anna on 2017-09-26.
 */
public interface JzPlayerRepositoryCustom {

    List<JzPlayer> getList(JzPlayerSearchVO searchVO);
}
