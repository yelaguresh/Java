package com.imcs.trng.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.imcs.trng.mongo.api.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
