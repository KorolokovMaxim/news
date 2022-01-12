package com.parser.news.job;

import com.parser.news.model.News;
import com.parser.news.service.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParserTask {

    public  final NewsService newsService;

    public ParserTask(NewsService newsService) {
        this.newsService = newsService;
    }

    @Scheduled(fixedDelay = 10000)
    public void parseNewNews(){
        String url = "https://quote.rbc.ru/";

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Opera")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();
            Elements titleNews = doc.getElementsByClass("q-item__title");

            for (Element e : titleNews){
                System.out.println(e);
                String title = e.ownText();
                if(!newsService.isExist(title)){
                    News obj = new News();
                    obj.setTitle(title);
                    newsService.save(obj);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
