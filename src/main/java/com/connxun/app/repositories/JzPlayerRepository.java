package com.connxun.app.repositories;

import com.connxun.app.entity.JzPlayer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by anna on 2017-09-26.
 */
public interface JzPlayerRepository  extends CrudRepository<JzPlayer,Integer>,JzPlayerRepositoryCustom {
}
