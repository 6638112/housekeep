package com.connxun.app.repositories;

import com.connxun.app.entity.Jzchannel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anna on 2017-09-18.
 */
public interface JzChannelRepository extends CrudRepository<Jzchannel,Integer>,JzChannelRepositoryCustom {


}
