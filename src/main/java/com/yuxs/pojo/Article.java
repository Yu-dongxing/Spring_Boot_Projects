package com.yuxs.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Article {
    private Integer id; // ID
    private String title; // 文章标题
    private String content; // 文章内容
    private String coverImg; // 文章封面
    private State state; // 文章状态
    private Integer categoryId; // 文章分类ID
    private Integer createUser; // 创建人ID
    private LocalDateTime creatTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间
    // 枚举类，对应文章状态
    public enum State {已发布, 草稿}
}
