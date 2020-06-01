package com.syz.springangular.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.syz.springangular.demo.models.Book;

// When extends MongoRepository <type of entity, type of id(which is a string)>
@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}
