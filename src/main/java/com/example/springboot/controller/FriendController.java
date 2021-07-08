package com.example.springboot.controller;


import com.alibaba.fastjson.JSON;
import com.example.springboot.dto.FriendDto;
import com.example.springboot.service.IFriendService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    private final IFriendService studentServices;

    public FriendController(IFriendService studentServices) {
        this.studentServices = studentServices;
    }

    /*
    //基于Setter的依赖注入
    private StudentServices studentServices;
    @Autowired
    public void setStudentServices(StudentServices studentServices){
        this.studentServices = studentServices;
    }
    */




  /*  //基于属性的依赖注入
    @Resource
    private StudentServices studentServices;*/


    @RequestMapping("/findOne")
    public String findOne(String name) {
        FriendDto students = studentServices.selectOne(name);
        String json = JSON.toJSONString(students);
        return json;
    }

    @RequestMapping("/findAll")
    public String findAll() {
        List<FriendDto> students = studentServices.selectAll();
        String json = JSON.toJSONString(students);
        return json;
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
            int insertResult = studentServices.insertPhoto(data);
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
            FriendDto studentDto = studentServices.selectImage();
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
