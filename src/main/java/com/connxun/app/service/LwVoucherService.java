package com.connxun.app.service;


import com.connxun.app.entity.LwVoucher;
import com.connxun.app.repositories.LwVoucherRepository;
import com.connxun.app.searchVO.LwVoucherSearchVO;
import com.connxun.common.service.BaseService;
import com.connxun.util.string.StringUtil;
import org.apache.commons.collections4.IterableUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-20 15:50
 * @Comments：
 */
@Service
public class LwVoucherService implements BaseService<LwVoucher,Integer> {

    private static Logger logger = LoggerFactory.getLogger("redisLog");

    @Autowired
    private LwVoucherRepository lwVoucherRepository;
//    @Autowired
//    private JpaTransactionManager transactionManager;

    @Override
    public <S extends LwVoucher> S save(S entity) {
        return lwVoucherRepository.save(entity);
    }

    @Override
    public LwVoucher findOne(Integer primaryKey) {
        return lwVoucherRepository.findOne(primaryKey);
    }

    @Override
    public List<LwVoucher> findAll() {
        return IterableUtils.toList(lwVoucherRepository.findAll());
    }

    @Override
    public long count() {
        return lwVoucherRepository.count();
    }

    @Override
    public void delete(Integer primaryKey) {
        lwVoucherRepository.delete(primaryKey);
    }


    public List<LwVoucher> getList(LwVoucherSearchVO searchVO) {
        return lwVoucherRepository.getList(searchVO);

    }

    public void updateState(Integer id, int state) {
        lwVoucherRepository.setStateById(state, id != null ? id : 0);
    }

    public List<LwVoucher> findAllByState(int state){
        return lwVoucherRepository.findAllByState(state);
    }

    public List<LwVoucher> getListByNameLike(String name,String state){
        if (StringUtil.isNotNullOrEmpty(state)){
            return lwVoucherRepository.getListByNameLike(name,state);
        }else{
            return lwVoucherRepository.getListByNameLike(name);
        }

    }

    public int getIdByTelephone(String telephone){
        Integer integer=lwVoucherRepository.getIdByTelephone(telephone);
        if (integer==null){
            integer=0;
        }
        return integer.intValue();
    }

    public List<Integer> getAllphone(){
        return lwVoucherRepository.getAllphone();
    }


    public List<Integer> getPhoneByCourse(String courseNo){
        return lwVoucherRepository.getPhoneByCourse(courseNo);
    }

    public Integer getVoucherRemain(int voucherNo){
        return lwVoucherRepository.getVoucherRemain(voucherNo);
    }

//    @Transactional(rollbackFor = Exception.class)
    public void updateDeleteById(int id){
        lwVoucherRepository.updateDeleteById(id);
    }

    public void updateNumberById(int id){
        lwVoucherRepository.updateNumberById(id);
    }

    public List<LwVoucher> getListWhereStop(){
        return lwVoucherRepository.getListWhereStop();
    }

}
