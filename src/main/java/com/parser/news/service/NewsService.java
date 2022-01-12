package com.parser.news.service;

import com.parser.news.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {

    void save(News news);

    boolean isExist(String newsTitle);

    List<News> getAllNews();

}
