package com.imcs.trng.rest.consume;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.imcs.trng.mongo.api.model.Book;

@Component
public class CallRestService implements CommandLineRunner {
private static void callRestService() {
	RestTemplate restTemplate=new RestTemplate();
	Book book=restTemplate.getForObject("http://localhost:8080//books/6771", Book.class);
	System.out.println("Book Details: "+book.toString());
}

@Override
public void run(String... args) throws Exception {
callRestService();	
}
}
