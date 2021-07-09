package com.example.springboot.service.impl;

import com.example.springboot.dao.IFriendDao;
import com.example.springboot.dto.FriendDto;
import com.example.springboot.service.IFriendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhengwei he
 */
@Service
public class FriendServicesImpl implements IFriendService {


    @Resource
    private IFriendDao studentDao;

    @Override
    public FriendDto selectOne(String name) {
        return studentDao.selectOne(name);
    }

    @Override
    public List<FriendDto> selectAll() {
        return studentDao.selectAll();
    }

    @Override
    public int insertPhoto(byte[] image,String name) {
        return studentDao.insertPhoto(image,name);
    }

    @Override
    public FriendDto selectImage(String name) {
        return studentDao.selectImage(name);
    }


}
