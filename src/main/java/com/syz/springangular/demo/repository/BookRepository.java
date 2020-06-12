package com.syz.springangular.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.syz.springangular.demo.models.Book;



// When extends MongoRepository <type of entity, type of id(which is a string)>
@Repository
public interface BookRepository extends MongoRepository<Book, String>, QuerydslPredicateExecutor<Book> {

    public Page<Book> findByTags(String tag, Pageable pageable);
    
    
//    @Query(value = "{address.city:?0}")
//    List<Book> findByText(String text);
    
    List<Book> findAllBy(TextCriteria criteria, Sort sort);
    Page<Book> findAllBy(TextCriteria criteria, Pageable pageable);
    
    List<Book> findAllByPublishDate(Date publish);
    List<Book> findByTitleOrderByTextScoreDesc(String title, TextCriteria criteria);
    
}
