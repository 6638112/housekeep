package com.connxun.app.repositories;

import com.connxun.app.entity.JzGroup;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anna on 2017-09-27.
 */
public interface JzGroupRepository  extends CrudRepository<JzGroup,Integer>,JzGroupRepositoryCustom{
}
