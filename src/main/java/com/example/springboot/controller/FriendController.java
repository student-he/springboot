package com.example.springboot.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.dto.FriendDto;
import com.example.springboot.service.IFriendService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhengwei he
 */

@RestController
@RequestMapping("/student")
public class FriendController {

    // 基于构造函数的依赖注入
/*    private final IFriendService friendService;

    public FriendController(IFriendService friendService) {
        this.friendService = friendService;
    }*/

    /*
    //基于Setter的依赖注入
    private IFriendService friendService;
    @Autowired
    public void setStudentServices(IFriendService friendService){
        this.friendService = friendService;
    }
    */




    //基于属性的依赖注入
    @Resource
    private IFriendService friendService;


    @RequestMapping("/findOne")
    public String findOne(String name) {
        FriendDto students = friendService.selectOne(name);
        String json = JSON.toJSONString(students);
        return json;
    }

    @RequestMapping("/findAll")
    public String findAll() {
        List<FriendDto> students = friendService.selectAll();
        String json = JSON.toJSONString(students);
        return json;
    }

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页面大小
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    public JSONObject queryByPage(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        JSONObject queryResult = new JSONObject();
        if (pageNum > 0 && pageSize > 0) {
            queryResult = this.friendService.queryByPage(pageNum, pageSize);
        } else {
            queryResult.put("retCode", 1);
            queryResult.put("retMsg", "查询失败");
            queryResult.put("jsonArray", null);
        }
        return queryResult;
    }

    /**
     * 上传照片
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadPhoto")
    public String uploadPhoto(MultipartFile file) {
        String result = null;
        try {
            InputStream ins = file.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = ins.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            bos.flush();
            byte[] data = bos.toByteArray();
            //将图片插入到数据库
            int insertResult = friendService.insertPhoto(data,"name");
            if (insertResult == 1) {
                result = "Upload Photo success~";
            } else {
                result = "Upload Photo failed~";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 下载照片
     *
     * @return
     */
    @RequestMapping(value = "/downloadPhoto")
    public String downloadPhoto() {
        String result = "Download Failed~";
        try {
            //从数据库读取信息
            FriendDto studentDto = friendService.selectImage("name");
            if (studentDto == null) {
                result = "image is null~";
            } else {
                //将图片保存到本地
                byte[] image = studentDto.getPhoto();
                saveFile("photo.jpg", image);
                result = "Download Success~";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将字节流转换成文件
     *
     * @param filename
     * @param data
     * @throws Exception
     */
    public static void saveFile(String filename, byte[] data) throws Exception {
        if (data != null) {
            String filepath = "D:\\" + filename;
            File file = new File(filepath);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data, 0, data.length);
            fos.flush();
            fos.close();
        }
    }

}
