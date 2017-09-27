package com.connxun.app.service;

import com.connxun.app.entity.JzPlayer;
import com.connxun.app.repositories.JzPlayerRepository;
import com.connxun.app.searchVO.JzPlayerSearchVO;
import com.connxun.common.service.BaseService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anna on 2017-09-26.
 */
@Service
public class JzPlayerService implements BaseService<JzPlayer,Integer> {

    @Autowired
    private JzPlayerRepository jzPlayerRepository;

    @Override
    public <S extends JzPlayer> S save(S entity) {
        return jzPlayerRepository.save(entity);
    }

    @Override
    public JzPlayer findOne(Integer primaryKey) {
        return jzPlayerRepository.findOne(primaryKey);
    }

    @Override
    public List<JzPlayer> findAll() {
        return IterableUtils.toList(jzPlayerRepository.findAll());
    }

    @Override
    public long count() {
        return jzPlayerRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        jzPlayerRepository.delete(primaryKey);
    }

    public List<JzPlayer> getList(JzPlayerSearchVO searchVO) {
        return jzPlayerRepository.getList(searchVO);

    }
}
