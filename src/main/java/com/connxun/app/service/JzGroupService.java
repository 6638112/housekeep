package com.connxun.app.service;

import com.connxun.app.entity.JzGroup;
import com.connxun.app.repositories.JzGroupRepository;
import com.connxun.app.searchVO.JzGroupSearchVO;
import com.connxun.common.service.BaseService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anna on 2017-09-27.
 */
@Service
public class JzGroupService implements BaseService<JzGroup,Integer> {

    @Autowired
    private JzGroupRepository jzGroupRepository;

    @Override
    public <S extends JzGroup> S save(S entity) {
        return jzGroupRepository.save(entity);
    }

    @Override
    public JzGroup findOne(Integer primaryKey) {
        return jzGroupRepository.findOne(primaryKey);
    }

    @Override
    public List<JzGroup> findAll() {
        return IterableUtils.toList(jzGroupRepository.findAll());
    }

    @Override
    public long count() {
        return jzGroupRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        jzGroupRepository.delete(primaryKey);

    }

    public List<JzGroup> getList(JzGroupSearchVO searchVO) {
        return jzGroupRepository.getList(searchVO);

    }
    public JzGroup getGroupByGroupId(String channelId) {
        return jzGroupRepository.getGroupByGroupId(channelId);

    }
}
