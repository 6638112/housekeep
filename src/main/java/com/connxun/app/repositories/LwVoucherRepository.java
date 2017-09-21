package com.connxun.app.repositories;


import com.connxun.app.entity.LwVoucher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author：luoxiaosheng
 * @Date：2017-07-20 15:51
 * @Comments：
 */
public interface LwVoucherRepository extends CrudRepository<LwVoucher,Integer>,LwVoucherRepositoryCustom {

    /*状态码更新*/
    @SuppressWarnings("JpaQlInspection")
    @Modifying
    @Query(value = "UPDATE lw_voucher lc SET lc.state=:state WHERE lc.id=:id", nativeQuery = true)
    void setStateById(@Param("state") int state, @Param("id") int id);

    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT * from lw_voucher lc WHERE lc.state=:state", nativeQuery = true)
    List<LwVoucher> findAllByState(@Param("state") int state);

    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT * from lw_voucher WHERE  name LIKE CONCAT('%',:name,'%') AND state=:state", nativeQuery = true)
    List<LwVoucher> getListByNameLike(@Param("name") String name, @Param("state") String state);

    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT * from lw_voucher WHERE  name LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    List<LwVoucher> getListByNameLike(@Param("name") String name);

    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT lw_user.id from lw_user WHERE  phone =:telephone limit 0,1" , nativeQuery = true)
    Integer getIdByTelephone(@Param("telephone") String telephone);

    /*查询全站用户的手机号*/
    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT DISTINCT(lw_user.phone) from lw_user" , nativeQuery = true)
    List<Integer> getAllphone();

    /*查询某课程下用户的手机号*/
    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT DISTINCT(lu.phone) from lw_user_course lc LEFT JOIN lw_user lu ON lc.userNo=lu.id where lc.courseNo=:courseNo" , nativeQuery = true)
    List<Integer> getPhoneByCourse(@Param("courseNo") String courseNo);

    /*获取代金券剩余数量*/
    @SuppressWarnings("JpaQlInspection")
    @Query(value = "SELECT lc.count-(SELECT count(*) from lw_voucher_log where voucherId=:voucherNo) from lw_voucher lc where lc.id=:voucherNo" , nativeQuery = true)
    Integer getVoucherRemain(@Param("voucherNo") int voucherNo);

    /*代金券删除——逻辑删除*/
    @Procedure(name = "proc_voucher_deleteById")
    void updateDeleteById(@Param("id") int id);


    /*代金券剩余减1——保证减完不为负数*/
    @SuppressWarnings("JpaQlInspection")
    @Modifying
    @Query(value = "update lw_voucher lc set number=number-1 where (number -1 ) >= 0 AND lc.id=:id", nativeQuery = true)
    void updateNumberById(@Param("id") int id);

    @SuppressWarnings("JpaQlInspection")
    @Query(value = "select * from lw_voucher lv where lv.state=1", nativeQuery = true)
    List<LwVoucher> getListWhereStop();


}
