package com.example.springboot.service;


import com.alibaba.fastjson.JSONObject;
import com.example.springboot.dto.FriendDto;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author zhengwei he
 */
@Component
public interface IFriendService {

    /**
     * 分页查询
     *
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @return 查询结果
     */
    JSONObject queryByPage(int pageNum, int pageSize);

    /**查询一个
     * @param name
     * @return
     */
    FriendDto selectOne(String name);

    /**查询全部
     * @return
     */
    List<FriendDto> selectAll();

    /**
     * 插入照片
     * @param image
     * @return
     */
    int insertPhoto(byte[] image,String name);

    /**查询照片
     * @return
     */
    FriendDto selectImage(String name);
}
