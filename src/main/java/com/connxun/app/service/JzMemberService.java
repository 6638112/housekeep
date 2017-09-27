package com.connxun.app.service;

import com.connxun.app.entity.JzMember;
import com.connxun.app.repositories.JzMemberRepository;
import com.connxun.app.searchVO.JzMemberSearchVO;
import com.connxun.common.service.BaseService;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anna on 2017-09-27.
 */
@Service
public class JzMemberService  implements BaseService<JzMember,Integer> {

    @Autowired
    private JzMemberRepository jzMemberRepository;

    @Override
    public <S extends JzMember> S save(S entity) {
        return jzMemberRepository.save(entity);
    }

    @Override
    public JzMember findOne(Integer primaryKey) {
        return jzMemberRepository.findOne(primaryKey);
    }

    @Override
    public List<JzMember> findAll() {
        return IterableUtils.toList(jzMemberRepository.findAll());
    }

    @Override
    public long count() {
        return jzMemberRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        jzMemberRepository.delete(primaryKey);
    }


    public List<JzMember> getList(JzMemberSearchVO searchVO) {
        return jzMemberRepository.getList(searchVO);

    }
}
