package com.example.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springboot.dto.Userinfo;
import com.example.springboot.service.IUserinfoService;
import com.example.springboot.utils.LogUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 记录用户信息(Userinfo)表控制层
 *
 * @author makejava
 * @since 2021-11-14 21:31:11
 */
@RestController
@CrossOrigin
@RequestMapping("userinfo")
public class UserinfoController {
    /**
     * 服务对象
     */
    @Resource
    private IUserinfoService userinfoService;

    /**
     * 分页查询 查询用户信息
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    public JSONObject queryByPage(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        JSONObject queryResult = new JSONObject();
        LogUtil.info("请求参数信息，pageNum" + pageNum, ",pageSize:" + pageSize);
        if (pageNum > 0 && pageSize > 0) {
            queryResult = this.userinfoService.queryByPage(pageNum, pageSize);
        } else {
            queryResult.put("retCode", 1);
            queryResult.put("totalNum", 1);
            queryResult.put("retMsg", "查询失败");
            queryResult.put("jsonArray", null);
            LogUtil.error("请求参数格式不正确");
        }
        return queryResult;
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById/{id}")
    public ResponseEntity<Userinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Userinfo> add(Userinfo userinfo) {
        return ResponseEntity.ok(this.userinfoService.insert(userinfo));
    }

    /**
     * 编辑数据
     *
     * @param userinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Userinfo> edit(Userinfo userinfo) {
        return ResponseEntity.ok(this.userinfoService.update(userinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userinfoService.deleteById(id));
    }

}

