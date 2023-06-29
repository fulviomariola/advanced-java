package app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.entities.Book;

@RestController
public class BookControllers {
	
	@GetMapping("/books")
	public Book books() {
		
		var book = new Book("Charles", "Great Expect");
		
		return book;
	}
	
}
