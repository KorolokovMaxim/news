package com.parser.news.service;

import com.parser.news.Repository.NewsRepository;
import com.parser.news.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    public final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public boolean isExist(String newsTitle) {

        return newsRepository.findNewsByTitle(newsTitle).isPresent()
                && newsRepository.findNewsByTitle(newsTitle).get().getTitle().equals(newsTitle);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}
