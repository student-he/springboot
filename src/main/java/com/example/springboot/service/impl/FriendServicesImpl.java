package com.example.springboot.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.dao.IFriendDao;
import com.example.springboot.dto.FriendDto;
import com.example.springboot.service.IFriendService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhengwei he
 */
@Service
public class FriendServicesImpl implements IFriendService {


    @Resource
    private IFriendDao friendDao;


    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return
     */
    @Override
    public JSONObject queryByPage(int pageNum, int pageSize) {
        JSONObject queryResult = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<FriendDto> queryList = this.friendDao.selectAll();

            if (!queryList.isEmpty() && queryList.size() > 0) {

                for (int i = 0; i < queryList.size(); i++) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("name", queryList.get(i).getName());
                    jsonObject.put("age", queryList.get(i).getAge());
                    jsonObject.put("sex", queryList.get(i).getSex());
                    jsonObject.put("address", queryList.get(i).getAddress());
                    jsonObject.put("department", queryList.get(i).getDepartment());
                    jsonObject.put("birthplace", queryList.get(i).getBirthplace());
                    jsonArray.add(jsonObject);
                }


            } else {

            }

            queryResult.put("retCode", 0);
            queryResult.put("retMsg", "查询成功");
            queryResult.put("jsonArray", jsonArray);

        } catch (Exception e) {
            queryResult.put("retCode", 1);
            queryResult.put("retMsg", "查询成功");
            queryResult.put("jsonArray", jsonArray);
        }

        return queryResult;
    }

    @Override
    public FriendDto selectOne(String name) {
        return friendDao.selectOne(name);
    }

    @Override
    public List<FriendDto> selectAll() {
        return friendDao.selectAll();
    }

    @Override
    public int insertPhoto(byte[] image, String name) {
        return friendDao.insertPhoto(image, name);
    }

    @Override
    public FriendDto selectImage(String name) {
        return friendDao.selectImage(name);
    }


}
