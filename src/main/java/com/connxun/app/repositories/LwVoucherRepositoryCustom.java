package com.connxun.app.repositories;


import com.connxun.app.entity.LwVoucher;
import com.connxun.app.searchVO.LwVoucherSearchVO;

import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-20 15:51
 * @Comments：
 */
public interface LwVoucherRepositoryCustom {

    List<LwVoucher> getList(LwVoucherSearchVO searchVO);

}
