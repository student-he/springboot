package com.example.springboot.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.dao.IUserinfoDao;
import com.example.springboot.dto.Userinfo;
import com.example.springboot.service.IUserinfoService;
import com.example.springboot.utils.PageHelperUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 记录用户信息(Userinfo)表服务实现类
 *
 * @author makejava
 * @since 2021-11-14 21:31:19
 */
@Service("userinfoService")
public class UserinfoServiceImpl implements IUserinfoService {
    @Resource
    private IUserinfoDao userinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Userinfo queryById(Integer id) {
        return this.userinfoDao.queryById(id);
    }


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
            Page page =PageHelper.startPage(pageNum, pageSize);
            List<Userinfo> queryList = this.userinfoDao.queryAll();
            PageInfo pageInfo= PageHelperUtil.insertPageInfo(queryList,page);
            if (!queryList.isEmpty() && queryList.size() > 0) {

                for (int i = 0; i < queryList.size(); i++) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("id", queryList.get(i).getId());
                    jsonObject.put("name", queryList.get(i).getName());
                    jsonObject.put("money", queryList.get(i).getMoney());
                    jsonObject.put("address", queryList.get(i).getAddress());
                    jsonObject.put("state", queryList.get(i).getState());
                    jsonObject.put("date", queryList.get(i).getDate());
                    jsonObject.put("thumb", queryList.get(i).getThumb());
                    jsonArray.add(jsonObject);
                }


            } else {

            }
            queryResult.put("totalNum", pageInfo.getTotal());
            queryResult.put("retCode", 0);
            queryResult.put("retMsg", "查询成功");
            queryResult.put("jsonArray", jsonArray);

        } catch (Exception e) {
            queryResult.put("totalNum", 0);
            queryResult.put("retCode", 1);
            queryResult.put("retMsg", "查询成功");
            queryResult.put("jsonArray", jsonArray);
        }

        return queryResult;
    }

    /**
     * 新增数据
     *
     * @param userinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Userinfo insert(Userinfo userinfo) {
        this.userinfoDao.insert(userinfo);
        return userinfo;
    }

    /**
     * 修改数据
     *
     * @param userinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Userinfo update(Userinfo userinfo) {
        this.userinfoDao.update(userinfo);
        return this.queryById(userinfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userinfoDao.deleteById(id) > 0;
    }
}
