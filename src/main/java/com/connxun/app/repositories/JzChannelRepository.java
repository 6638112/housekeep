package com.connxun.app.repositories;

import com.connxun.app.entity.JzChannel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by anna on 2017-09-18.
 */
public interface JzChannelRepository extends CrudRepository<JzChannel,Integer>,JzChannelRepositoryCustom {

    /*根据频道ID获取频道对象*/
    @SuppressWarnings("JpaQlInspection")
    @Query(value = "select * from jz_channel lv where lv.channelId=:channelId", nativeQuery = true)
    JzChannel getChannelByChannelId(@Param("channelId") String channelId);
}
