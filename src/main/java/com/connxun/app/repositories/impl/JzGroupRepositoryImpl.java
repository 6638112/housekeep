package com.connxun.app.repositories.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.connxun.app.entity.JzGroup;
import com.connxun.app.repositories.JzGroupRepositoryCustom;
import com.connxun.app.searchVO.JzGroupSearchVO;
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
 * Created by anna on 2017-09-27.
 */
@Repository
public class JzGroupRepositoryImpl  extends JdbcDaoSupport implements JzGroupRepositoryCustom {


    public JzGroupRepositoryImpl(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public List<JzGroup> getList(JzGroupSearchVO searchVO) {
        String sql = "";


        sql = "select lv.*  " +
                "  from jz_group lv where 1=1";


        sql += createSearchSql(searchVO);//调用创建查询sql方法

        sql += " ORDER BY lv.createTime DESC ";



        SqlParameterSource params = new BeanPropertySqlParameterSource(searchVO);//实例化一个查询类，用来注入查询数据 根据（:+字段值）
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());//对象构造器初始化
        String countSql = PagerUtils.count(sql, JdbcConstants.MYSQL);//工具类自动创建查询总数sql
        int count = jdbcTemplate.queryForObject(countSql, params, Integer.class);//执行sql返回查询结果
        if (count > 0) {
            searchVO.setTotal(count);
            sql = PagerUtils.limit(sql, JdbcConstants.MYSQL, searchVO.getPage(), searchVO.getLength());//工具类创建分页sql

            return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(JzGroup.class));//执行sql 返回数据
        }
        return new ArrayList<>();
    }

    /**
     * 创建查询sql
     *
     * @param searchVO 查询条件
     * @return 查询sql
     */
    private String createSearchSql(JzGroupSearchVO searchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(searchVO.getGroupNo())) { //判断是否为null或者""
            sql += " and lv.groupId = :groupNo ";
        }
        if (StringUtil.isNotNullOrEmpty(searchVO.getGroupName())) { //判断是否为null或者""
            sql += " and lv.name like :groupNameParam ";
        }

        return sql;

    }
}
