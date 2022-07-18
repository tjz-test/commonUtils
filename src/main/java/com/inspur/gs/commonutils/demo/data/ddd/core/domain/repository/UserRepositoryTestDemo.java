package com.inspur.gs.commonutils.demo.data.ddd.core.domain.repository;

import com.inspur.gs.commonutils.demo.data.ddd.api.entity.User;
import com.inspur.gs.commonutils.demo.data.ddd.core.domain.entity.UserEntity;
import io.iec.edp.caf.commons.utils.Page;
import io.iec.edp.caf.data.orm.DataRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

/**
 * @author tianjinzan01
 * maven依赖
 * <dependency>
 *    <groupId>io.iec.edp</groupId>
 *    <artifactId>caf-boot-parent</artifactId>
 * </dependency>
 * <dependency>
 *    <groupId>io.iec.edp</groupId>
 *    <artifactId>caf-boot-starter-data</artifactId>
 * </dependency>
 */
public interface UserRepositoryTestDemo extends DataRepository<UserEntity, String> {

    /*Jpa方法命名规则
    JpaRepository支持接口规范方法名查询。意思是如果在接口中定义的查询方法符合它的命名规则，就可以不用写实现，目前支持的关键字如下。

    Keyword	                   Sample	                          JPQL snippet
    And	                    findByNameAndPwd	              where name= ? and pwd =?
    Or	                    findByNameOrSex	                  where name= ? or sex=?
    Is,Equals	            findById,findByIdEquals	          where id= ?
    Between	                findByIdBetween	                  where id between ? and ?
    LessThan	            findByIdLessThan	              where id < ?
    LessThanEquals	        findByIdLessThanEquals	          where id <= ?
    GreaterThan	            findByIdGreaterThan	              where id > ?
    GreaterThanEquals	    findByIdGreaterThanEquals	      where id > = ?
    After	                findByIdAfter	                  where id > ?
    Before	                findByIdBefore	                  where id < ?
    IsNull	                findByNameIsNull	              where name is null
    isNotNull,NotNull	    findByNameNotNull	              where name is not null
    Like	                findByNameLike	                  where name like ?
    NotLike	                findByNameNotLike	              where name not like ?
    StartingWith	        findByNameStartingWith	          where name like ‘?%’
    EndingWith	            findByNameEndingWith	          where name like ‘%?’
    Containing	            findByNameContaining	          where name like ‘%?%’
    OrderBy	                findByIdOrderByXDesc	          where id=? order by x desc
    Not	                    findByNameNot	                  where name <> ?
    In	                    findByIdIn(Collection<?> c)	      where id in (?)
    NotIn	                findByIdNotIn(Collection<?> c) 	  where id not in (?)
    True	                findByAaaTue	                  where aaa = true
    False	                findByAaaFalse	                  where aaa = false
    IgnoreCase	            findByNameIgnoreCase	          where UPPER(name)=UPPER(?)
    top	                    findTop10	                      top 10/where ROWNUM <=10*/

    ///**
    // * 简单查询，可以根据具体业务来自定义，基本：find…By, read…By, query…By, count…By, get…By,and,or
    // * @param firstName firstName
    // * @return 符合条件的用户列表
    // */
    //List<User> findByFirstName(String firstName);
    //
    ///**
    // * 使用Native SQL/JPQL模板定义指定命名的查询
    // *
    // * [!] 使用此种模式定义查询时，方法名无需具备任何模式或特性
    // * [!] 使用Native SQL时，需要指定@Query(nativeQuery=true)
    // * [!] 查询模板位于当前模块源码目录下 META-INF/orm.xml
    // *
    // * @param middleName middleName
    // * @return 符合条件的用户列表
    // */
    //@Query(name = "queryUserByMiddleName")
    //List<User> findByMiddleName(@Param("middleName") String middleName);
    //
    ///**
    // * 使用模板定义指定Repository下具体方法的具体查询
    // * 需要查询模板中named-query或named-native-query
    // * 的name属性符合如下模式：
    // *   {实体名}.{实体Repository中对应查询方法的方法名}
    // *
    // * [!] 使用此种模式定义查询时，方法名无需具备任何模式或特性
    // * [!] 同样Native SQL时，无需额外设置
    // * [!] 查询模板位于当前模块源码目录下 META-INF/orm.xml
    // *
    // * @param middleName middleName
    // * @return 符合条件的用户列表
    // */
    //@Query
    //List<User> fetchUserByMiddleName(@Param("middleName") String middleName);
    //
    ///**
    // * 使用Annotation定义的NativeSQL查询
    // *
    // * @param userId 用户ID
    // * @return 指定ID的用户
    // */
    //@Query(value = "SELECT * FROM `USER` WHERE id = :id", nativeQuery = true)
    //User findByUserId(@Param("id") String userId );
}
