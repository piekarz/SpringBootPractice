package com.ericsson.myproject.repositories;

import com.ericsson.myproject.models.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends CrudRepository<Article, Long> {
    List<Article> findByTitle(String title);

    @Query(name = "article.finder")
    List<Article> findByTitleAndTags(@Param("title") String title, @Param("tags") String tags);
}
