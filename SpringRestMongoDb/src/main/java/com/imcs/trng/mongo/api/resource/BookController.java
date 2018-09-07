package com.imcs.trng.mongo.api.resource;

import java.awt.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.trng.mongo.api.model.Book;
import com.imcs.trng.mongo.api.repository.BookRepository;

@RestController
public class BookController {
@Autowired
private BookRepository repository;

@PostMapping("/addBook")
public String saveBook(@RequestBody Book book) {
	repository.save(book);
	return "New book added";
}
@GetMapping("/findAllBooks")
public java.util.List<Book> getBooks() {
	return repository.findAll();
}
@GetMapping("/findAllBooks/{id}")
public Optional<Book> getBooks(@PathVariable int id) {
	return repository.findById(id);
}
@DeleteMapping("/delete/{id}")
public String deleteBooks(@PathVariable int id) {
	repository.deleteById(id);
	return "book deleted";
}
}
