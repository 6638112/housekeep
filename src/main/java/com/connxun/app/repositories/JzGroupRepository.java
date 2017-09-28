package com.connxun.app.repositories;

import com.connxun.app.entity.JzGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by anna on 2017-09-27.
 */
public interface JzGroupRepository  extends CrudRepository<JzGroup,Integer>,JzGroupRepositoryCustom{

    /*根据群组ID获取群组对象*/
    @SuppressWarnings("JpaQlInspection")
    @Query(value = "select * from jz_group lv where lv.groupId=:groupId", nativeQuery = true)
    JzGroup getGroupByGroupId(@Param("groupId") String groupId);
}
