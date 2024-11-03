package com.yuxs.controller;

import com.yuxs.pojo.Article;
import com.yuxs.pojo.Result;
import com.yuxs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping("")
    public Result add(@RequestBody Article article){
        articleService.add(article);
        return Result.success("添加文章成功！");
    }
}
