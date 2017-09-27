package com.connxun.app.repositories.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.connxun.app.entity.JzUser;
import com.connxun.app.repositories.JzUserRepositoryCustom;
import com.connxun.app.searchVO.JzUserSearchVO;
import com.connxun.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 用户 repositories
 * Created by Mac on 2017/6/11.
 */
@Repository
public class JzUserRepositoryImpl extends JdbcDaoSupport implements JzUserRepositoryCustom {

    @Autowired
    public JzUserRepositoryImpl(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    /**
     * 自定义分页查询
     *
     * @param searchVO 查询条件
     * @return 分页数据
     */
    @Override
    public List<JzUser> getList(JzUserSearchVO searchVO) {
        System.out.println("--------" + searchVO.getId());
        String sql = "SELECT  *  FROM jz_user where 1=1  ";
        sql += createSearchSql(searchVO);//调用创建查询sql方法
        sql += " order by id DESC ";//拼接sql 排序
        SqlParameterSource params = new BeanPropertySqlParameterSource(searchVO);//实例化一个查询类，用来注入查询数据 根据（:+字段值）
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());//对象构造器初始化
        String countSql = PagerUtils.count(sql, JdbcConstants.MYSQL);//工具类自动创建查询总数sql
        int count = jdbcTemplate.queryForObject(countSql, params, Integer.class);//执行sql返回查询结果
        if (count > 0) {
            searchVO.setTotal(count);//set一个总数到查询VO的父类
            sql = PagerUtils.limit(sql, JdbcConstants.MYSQL, searchVO.getPage(), searchVO.getLength());//工具类创建分页sql
            return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(JzUser.class));//执行sql 返回数据
        }
        return new ArrayList<>();
    }

    // 手机登录
    @Override
    public JzUser getPhone(String phone) {
        String sql = "SELECT * FROM  jz_user WHERE  phone =" + phone;
        List<JzUser> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(JzUser.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Override
    public List<JzUser> search(JzUserSearchVO searchVO) {
        String sql = "SELECT * FROM  jz_user" +
                "(SELECT username FROM sys_user WHERE id=b.createUser) AS  'createUserName'," +
                "(SELECT username FROM sys_user WHERE id=b.updateUser) AS  'updateUserName'" +
                " WHERE  1=1";

        SqlParameterSource params = new BeanPropertySqlParameterSource(searchVO);//实例化一个查询类，用来注入查询数据 根据（:+字段值）
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());//对象构造器初始化
        String countSql = PagerUtils.count(sql, JdbcConstants.MYSQL);//工具类自动创建查询总数sql
        int count = jdbcTemplate.queryForObject(countSql, params, Integer.class);//执行sql返回查询结果
        if (count > 0) {
            searchVO.setTotal(count);//set一个总数到查询VO的父类
            return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(JzUser.class));//执行sql 返回数据
        }
        return new ArrayList<>();
    }

    @Override
    public List<JzUser> getInvitationList(JzUserSearchVO JzUserSearchVO) {

        String sql = "SELECT phone,createDate ,icon FROM  jz_user  WHERE  1=1   ";
        sql += createSearchSql(JzUserSearchVO);//调用创建查询sql方法
        sql += " order by createDate DESC ";//拼接sql 排序
        SqlParameterSource params = new BeanPropertySqlParameterSource(JzUserSearchVO);//实例化一个查询类，用来注入查询数据 根据（:+字段值）
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate());//对象构造器初始化
        String countSql = PagerUtils.count(sql, JdbcConstants.MYSQL);//工具类自动创建查询总数sql
        int count = jdbcTemplate.queryForObject(countSql, params, Integer.class);//执行sql返回查询结果
        if (count > 0) {
            JzUserSearchVO.setTotal(count);//set一个总数到查询VO的父类
            return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(JzUser.class));//执行sql 返回数据
        }
        return new ArrayList<>();

    }

    @Override
    public JzUser isInvite(Integer inviteCode) {
        String sql = "SELECT * FROM  jz_user WHERE  inviteCode =" + inviteCode;
        List<JzUser> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(JzUser.class));
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    /**
     * 创建查询sql
     *
     * @param searchVO 查询条件
     * @return 查询sql
     */
    private String createSearchSql(JzUserSearchVO searchVO) {
        String sql = "";
        if (StringUtil.isNotNullOrEmpty(searchVO.getNickName())) { //判断是否为null或者""
            sql += " and  nickName like :nickNameParam";
        }//注入参数  这里用的模糊查询  防注入 所以在bean里面拼接
        if (searchVO.getId() != null) {
            sql += " and id = :id ";
        }
        if (searchVO.getInvitationNo() != null) {
            sql += "  and invitationNo=:invitationNo ";
        }
        if (searchVO.getInviteCode() != null) {
            sql += "   and  guide=:guide ";

        }
        if (searchVO.getGuide() != null) {
            sql += "   and  guide=:guide ";

        }
        if (StringUtil.isNotNullOrEmpty(searchVO.getPhone())) {
            sql += "  and phone=:phone ";
        }
        if (searchVO.getIntegral() != null) {
            sql += "  and integral>=:integral ";

        }
////        微信登录
//        if (searchVO.getLoginType() == 1) {
//            sql += "   and  openId =:openId";
//
//
//        }
////       微博登录
//        if (searchVO.getLoginType() == 2) {
//            sql += "   and  wbId =:wbId";
//
//
//        }
////        qq 登录
//        if (searchVO.getLoginType() == 3) {
//            sql += "   and  qqId =:qqId";
//
//
//        }


        return sql;

    }

}
