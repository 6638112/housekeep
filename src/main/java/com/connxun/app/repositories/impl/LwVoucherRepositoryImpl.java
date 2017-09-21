package com.connxun.app.repositories.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.connxun.app.entity.LwVoucher;
import com.connxun.app.repositories.LwVoucherRepositoryCustom;
import com.connxun.app.searchVO.LwVoucherSearchVO;
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
 * Created by anna on 2017-07-20.
 */
@Repository
public class LwVoucherRepositoryImpl extends JdbcDaoSupport implements LwVoucherRepositoryCustom {

    public LwVoucherRepositoryImpl(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public List<LwVoucher> getList(LwVoucherSearchVO searchVO) {
        String sql = "";


            sql = "select lv.*,count(lg.id) receive,sum(lg.state=1) used   " +
                    "  from lw_voucher lv LEFT JOIN lw_voucher_log lg" +
                    " on lg.voucherId=lv.id where 1=1 and lv.del_flag<>1  ";


        sql += createSearchSql(searchVO);//调用创建查询sql方法

            sql += " GROUP BY lv.id ORDER BY lv.id DESC, lv.state ASC ";



        SqlParameterSource params = new BeanPropertySqlParameterSource(searchVO);//实例化一个查询类，用来注入查询数据 根据（:+字段值）
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());//对象构造器初始化
        String countSql = PagerUtils.count(sql, JdbcConstants.MYSQL);//工具类自动创建查询总数sql
        int count = jdbcTemplate.queryForObject(countSql, params, Integer.class);//执行sql返回查询结果
        if (count > 0) {
            searchVO.setTotal(count);
            sql = PagerUtils.limit(sql, JdbcConstants.MYSQL, searchVO.getPage(), searchVO.getLength());//工具类创建分页sql

            return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(LwVoucher.class));//执行sql 返回数据
        }
        return new ArrayList<>();
    }

    /**
     * 创建查询sql
     *
     * @param searchVO 查询条件
     * @return 查询sql
     */
    private String createSearchSql(LwVoucherSearchVO searchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(searchVO.getName())) { //判断是否为null或者""
            //注入参数  这里用的模糊查询  防注入 所以在bean里面拼接
            sql += " and lv.name like :nameParm ";

        }
        if (searchVO.getType() != null) { //判断是否为null或者""
            //注入参数  这里用的模糊查询  防注入 所以在bean里面拼接

            sql += " and lv.type = :type ";

        }

        if (StringUtil.isNotNullOrEmpty(searchVO.getPrefix())) {
            sql += "  and lv.prefix like :prefixParam  ";
        }
        if (searchVO.getState() != null) {
            sql += "  and lv.state =:state  ";
        }
        if (searchVO.getUserNo() != null) {
            sql += "  and lg.userNo =:userNo  ";

        }

        return sql;

    }

}
