package com.connxun.app.repositories.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.connxun.app.entity.JzPlayer;
import com.connxun.app.repositories.JzPlayerRepositoryCustom;
import com.connxun.app.searchVO.JzPlayerSearchVO;
import com.connxun.util.string.StringUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anna on 2017-09-26.
 */
@Repository
public class JzPlayerRepositoryImpl extends JdbcDaoSupport implements JzPlayerRepositoryCustom {

    public JzPlayerRepositoryImpl(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public List<JzPlayer> getList(JzPlayerSearchVO searchVO) {
        String sql = "";


        sql = "select lv.*,ju.realName,jc.channelName  " +
                "  from jz_player lv " +
                "LEFT JOIN jz_user ju on lv.userId=ju.id  " +
                "LEFT JOIN jz_channel jc on lv.channelId=jc.id  where 1=1 ";


        sql += createSearchSql(searchVO);//调用创建查询sql方法

        sql += " ORDER BY lv.createDate DESC, lv.status ASC ";


        SqlParameterSource params = new BeanPropertySqlParameterSource(searchVO);//实例化一个查询类，用来注入查询数据 根据（:+字段值）
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());//对象构造器初始化
        String countSql = PagerUtils.count(sql, JdbcConstants.MYSQL);//工具类自动创建查询总数sql
        int count = jdbcTemplate.queryForObject(countSql, params, Integer.class);//执行sql返回查询结果
        if (count > 0) {
            searchVO.setTotal(count);
            sql = PagerUtils.limit(sql, JdbcConstants.MYSQL, searchVO.getPage(), searchVO.getLength());//工具类创建分页sql

            return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(JzPlayer.class));//执行sql 返回数据
        }
        return new ArrayList<>();
    }

    /**
     * 创建查询sql
     *
     * @param searchVO 查询条件
     * @return 查询sql
     */
    private String createSearchSql(JzPlayerSearchVO searchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(searchVO.getPlayerName())) { //判断是否为null或者""
            sql += " and ju.userId like :playerNameParam ";
        }
        if (StringUtil.isNotNullOrEmpty(searchVO.getChannelName())) { //判断是否为null或者""
            sql += " and jc.channelName like :channelNameParam ";
        }
        if (searchVO.getStatus() != null) { //判断是否为null或者""
            sql += " and lv.status = :channelStatus ";
        }

        return sql;

    }
}

