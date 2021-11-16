package com.example.springboot.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageHelperUtil {

    /**
     * @param list 数据信息列表
     * @param page 页表
     * @param <T>  泛型
     * @return
     */
    public static <T> PageInfo<T> insertPageInfo(List<T> list, Page page) {
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        pageInfo.setTotal(page.getTotal());
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setPages(page.getPages());
        return pageInfo;
    }
}
