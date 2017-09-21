package com.connxun.app.repositories.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.connxun.app.entity.Jzchannel;
import com.connxun.app.repositories.JzChannelRepositoryCustom;
import com.connxun.app.searchVO.JzChannelSearchVO;
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

import static com.connxun.util.qcloud.LiveGetInfo.LiveChannelGetChannelList;

/**
 * @Author：luoxiaosheng
 * @Date：2017-09-18 14:20
 * @Comments：
 */
@Repository
public class JzChannelRepositoryImpl  extends JdbcDaoSupport implements JzChannelRepositoryCustom {

    public JzChannelRepositoryImpl(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public List<Jzchannel> getList(JzChannelSearchVO searchVO) {
        String sql = "";


        sql = "select lv.*  " +
                "  from jz_channel lv where 1=1";


        sql += createSearchSql(searchVO);//调用创建查询sql方法

        sql += " ORDER BY lv.create_time DESC, lv.channel_status ASC ";



        SqlParameterSource params = new BeanPropertySqlParameterSource(searchVO);//实例化一个查询类，用来注入查询数据 根据（:+字段值）
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());//对象构造器初始化
        String countSql = PagerUtils.count(sql, JdbcConstants.MYSQL);//工具类自动创建查询总数sql
        int count = jdbcTemplate.queryForObject(countSql, params, Integer.class);//执行sql返回查询结果
        if (count > 0) {
            searchVO.setTotal(count);
            sql = PagerUtils.limit(sql, JdbcConstants.MYSQL, searchVO.getPage(), searchVO.getLength());//工具类创建分页sql

            return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Jzchannel.class));//执行sql 返回数据
        }
        return new ArrayList<>();
    }

    /**
     * 创建查询sql
     *
     * @param searchVO 查询条件
     * @return 查询sql
     */
    private String createSearchSql(JzChannelSearchVO searchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(searchVO.getChannelNo())) { //判断是否为null或者""
            sql += " and lv.channel_id = :channelNo ";
        }
        if (StringUtil.isNotNullOrEmpty(searchVO.getChannelName())) { //判断是否为null或者""
            sql += " and lv.channel_name like :channelNameParam ";
        }
        if (searchVO.getChannelStatus() != null) { //判断是否为null或者""
            sql += " and lv.channel_status like :channelStatus ";
        }

        return sql;

    }

    /**
     * 同步云端数据到本地数据库
     *
     * @return
     */
    private String synQCloudChannel() {
        String jsonResult=LiveChannelGetChannelList();

        return "";

    }

}
