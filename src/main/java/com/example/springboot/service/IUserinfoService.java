package com.example.springboot.service;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.dto.Userinfo;

/**
 * 记录用户信息(Userinfo)表服务接口
 *
 * @author makejava
 * @since 2021-11-14 21:31:19
 */
public interface IUserinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Userinfo queryById(Integer id);

    /**
     * 分页查询
     *
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 查询结果
     */
    JSONObject queryByPage(int pageNum, int pageSize);

    /**
     * 新增数据
     *
     * @param userinfo 实例对象
     * @return 实例对象
     */
    Userinfo insert(Userinfo userinfo);

    /**
     * 修改数据
     *
     * @param userinfo 实例对象
     * @return 实例对象
     */
    Userinfo update(Userinfo userinfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
