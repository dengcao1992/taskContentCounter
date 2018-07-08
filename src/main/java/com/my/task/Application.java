package com.my.task;

import com.my.task.dao.ArticleDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    private final ArticleDAO articleDAO;

    public Application(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.articleDAO.getAllArticles());
    }
}
