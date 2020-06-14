package com.syz.springangular.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.syz.springangular.demo.models.BookTag;


public interface BookTagRepository extends MongoRepository<BookTag, String> {

}
