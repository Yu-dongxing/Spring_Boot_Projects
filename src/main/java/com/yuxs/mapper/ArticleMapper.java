package com.yuxs.mapper;

import com.yuxs.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    //添加文章接口
    @Insert("INSERT INTO big_event.article " +
            "(title, content, cover_img, state, category_id, create_user, creat_time, update_time) " +
            "VALUES(#{title},#{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{creatTime}, #{updateTime}) ")
    void add(Article article);
}
