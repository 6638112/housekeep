package com.connxun.app.service;

import com.connxun.app.entity.JzChannel;
import com.connxun.app.repositories.JzChannelRepository;
import com.connxun.app.searchVO.JzChannelSearchVO;
import com.connxun.common.service.BaseService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anna on 2017-09-18.
 */
@Service
public class JzChannelService implements BaseService<JzChannel,Integer> {

    @Autowired
    private JzChannelRepository jzChannelRepository;

    @Override
    public <S extends JzChannel> S save(S entity) {
        return jzChannelRepository.save(entity);
    }

    @Override
    public JzChannel findOne(Integer primaryKey) {
        return jzChannelRepository.findOne(primaryKey);
    }

    @Override
    public List<JzChannel> findAll() {
        return IterableUtils.toList(jzChannelRepository.findAll());
    }

    @Override
    public long count() {
        return jzChannelRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        jzChannelRepository.delete(primaryKey);

    }

    public List<JzChannel> getList(JzChannelSearchVO searchVO) {
        return jzChannelRepository.getList(searchVO);

    }
}
