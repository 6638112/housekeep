package com.connxun.app.repositories;

import com.connxun.app.entity.JzGroup;
import com.connxun.app.entity.JzPlayer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by anna on 2017-09-26.
 */
public interface JzPlayerRepository  extends CrudRepository<JzPlayer,Integer>,JzPlayerRepositoryCustom {

    /*根据群组ID获取群组对象*/
    @SuppressWarnings("JpaQlInspection")
    @Query(value = "select * from jz_group lv where lv.groupId=:groupId", nativeQuery = true)
    JzGroup getGroupByGroupId(@Param("groupId") String groupId);


}
