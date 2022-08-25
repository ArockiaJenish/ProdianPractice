package com.jenish.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenish.demo.model.Book;
import com.jenish.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bRepo;
	
	public String addAllBooks(List<Book> books) {
		bRepo.saveAll(books);
		return "Books Added Successfully";
	}

	public List<Book> getAllBooks() {
		return bRepo.findAll();
	}

	public List<Book> getBooksByYOP(int yop, String auth) {
		return bRepo.findByYearOfPublication(yop, auth);
	}

	public List<Book> getBooksByOrder() {
		return bRepo.findAssendingOrdername();
	}
	
	public int saveDetails(int id, String name, String author, int yop) {
		 return bRepo.saveBooks(id, name, author, yop);
	}
	
	public int updateBooks(String bName, int year, int bId) {
		return bRepo.updateBooks(bName, year, bId);
	}
}
