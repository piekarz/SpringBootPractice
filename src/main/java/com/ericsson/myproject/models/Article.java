package com.ericsson.myproject.models;

import javax.persistence.*;

@Entity
@NamedQuery(name = "article.finder", query = "select a from Article a WHERE a.title LIKE CONCAT('%',:title,'%') AND a.tags LIKE CONCAT('%',:tags,'%') ORDER BY a.title ASC")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String tags;

    public Article(){
    }

    public Article(String title, String content, String tags){
        this.title = title;
        this.content = content;
        this.tags = tags;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "{title: "+title+", content: "+content+" tags: "+tags+"}";
    }
}
