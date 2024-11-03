package com.yuxs.mapper;

import com.yuxs.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {
    //新增
    @Insert("INSERT INTO category " +
            "(category_name, category_alias, create_user, creat_time, update_time)" +
            "VALUES(#{categoryName},#{categoryAlias},#{createUser},#{creatTime},#{updateTime})")
    void add(Category category);

    //查询所有
    @Select("SELECT * FROM category where create_user=#{userId}")
    List<Category> list(Integer userId);

    //根据id查询分类
    @Select("SELECT * FROM category where id=#{id}")
//     and create_user=#{userId} ,Integer userId
    Category findById(Integer id);

    //更新分类
    @Update("UPDATE category " +
            "SET category_name=#{categoryName},category_alias=#{categoryAlias}, update_time=#{updateTime} " +
            "WHERE id=#{id}")
    void update(Category category);
}
