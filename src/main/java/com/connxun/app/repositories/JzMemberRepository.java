package com.connxun.app.repositories;

import com.connxun.app.entity.JzMember;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anna on 2017-09-27.
 */
public interface JzMemberRepository  extends CrudRepository<JzMember,Integer>,JzMemberRepositoryCustom {


}
