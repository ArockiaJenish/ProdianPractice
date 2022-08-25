package com.jenish.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jenish.demo.model.Book;
import com.jenish.demo.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bService;

	@RequestMapping(method = RequestMethod.POST, value = "/books")
	public String addAllBooks(@RequestBody List<Book> books) {
		return bService.addAllBooks(books);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/books")
	public List<Book> getAllBooks() {
		return bService.getAllBooks();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/booksByYOP")
	public List<Book> getBooksByYOP(@RequestParam("yop") int yop, @RequestParam("author") String auth) {
		return bService.getBooksByYOP(yop, auth);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getValueOrderBy")
	public List<Book> getBooksByOrder() {
		return bService.getBooksByOrder();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveBooks")
	public int saveDetails(@RequestParam("bId") int id, @RequestParam("bName") String name,
			@RequestParam("bAuthor") String author, @RequestParam("yop") int yop) {
		return bService.saveDetails(id, name, author, yop);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateBooks")
	public int updateBooks(@RequestParam("bName") String name, @RequestParam("yop") int year,
			@RequestParam("bId") int id) {
		int result = bService.updateBooks(name, year, id);
		System.out.println(result += 5);
		return result;
	}

}
