package com.connxun.app.repositories;

import com.connxun.app.entity.JzGroup;
import com.connxun.app.searchVO.JzGroupSearchVO;

import java.util.List;

/**
 * Created by anna on 2017-09-27.
 */
public interface JzGroupRepositoryCustom {

    List<JzGroup> getList(JzGroupSearchVO searchVO);
}
