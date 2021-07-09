package com.example.springboot.dao;

import com.example.springboot.dto.FriendDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengwei he
 */
@Repository
public interface IFriendDao {
    /**
     * 查询一个
     * @param name 姓名
     * @return 实体
     */
    FriendDto selectOne(String name);

    /**查询全部
     * @return
     */
    List<FriendDto> selectAll();

    /**
     * 插入照片
     * @param image 照片
     * @return
     */
    int insertPhoto(@Param("image") byte[] image,@Param("name") String name);

    /**筛选照片
     * @return
     */
    FriendDto selectImage(@Param("name") String name);
}