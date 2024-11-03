package com.yuxs.service;

import com.yuxs.pojo.Category;

import java.util.List;

public interface CategoryService {
    //新增分类
    void add(Category category);

    //查询分类列表
    List<Category> list();

    //根据id查询分类信息
    Category findById(Integer id);

    //根据id更新分类
    void update(Category category);
}
