package com.parser.news.controller;

import com.parser.news.model.News;
import com.parser.news.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    public final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping(value = "/news")
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }

}
