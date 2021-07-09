package com.example.springboot.service;


import com.example.springboot.dto.FriendDto;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author zhengwei he
 */
@Component
public interface IFriendService {

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
