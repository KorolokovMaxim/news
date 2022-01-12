package com.parser.news.Repository;

import com.parser.news.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, Long> {


    Optional<News> findNewsByTitle(String title);
}
