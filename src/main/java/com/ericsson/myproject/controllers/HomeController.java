package com.ericsson.myproject.controllers;

import com.ericsson.myproject.models.Article;
import com.ericsson.myproject.repositories.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    ArticleRepo articleRepo;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("message", "Hello at home!");
        model.addAttribute("formArticle", new Article("title","content here", "tags..."));
        return "homeView";
    }

    @PostMapping("/add")
    public String addArticle(@ModelAttribute Article article, Model model){
        model.addAttribute("formArticle",article);
        articleRepo.save(article);
        return "successView";
    }
    @GetMapping("/findArticleByTitle/{title}")
    public String findArticleByTitle(@PathVariable String title, Model model){
            model.addAttribute("articles", articleRepo.findByTitle(title));
        return "articleListView";
    }

    @GetMapping("/articleFinder/{title}/{tag}")
    public String articleFinder(@PathVariable String title, @PathVariable String tag, Model model){
        articleRepo.findByTitleAndTags(title,tag).stream().forEach(article -> System.out.println(article.getTitle()));
        model.addAttribute("articles", articleRepo.findByTitleAndTags(title,tag));
        return "articleListView";
    }
}

