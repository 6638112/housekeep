package com.connxun.app.repositories;


import com.connxun.app.entity.LwUser;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户 Repository
 * Created by Mac on 2017/6/11.
 */

public interface LwUserRepository extends CrudRepository<LwUser,Integer>,LwUserRepositoryCustom {

}


