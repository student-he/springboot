package com.example.springboot.dao;

import com.example.springboot.dto.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 记录用户信息(Userinfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-11-14 21:31:11
 */
public interface IUserinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Userinfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<Userinfo> queryAll();

    /**
     * 统计总行数
     *
     * @param userinfo 查询条件
     * @return 总行数
     */
    long count(Userinfo userinfo);

    /**
     * 新增数据
     *
     * @param userinfo 实例对象
     * @return 影响行数
     */
    int insert(Userinfo userinfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Userinfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Userinfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Userinfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Userinfo> entities);

    /**
     * 修改数据
     *
     * @param userinfo 实例对象
     * @return 影响行数
     */
    int update(Userinfo userinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

