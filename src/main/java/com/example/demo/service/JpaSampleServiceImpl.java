package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.BookTitleOnly;
import com.example.demo.repository.BookRepositoryImpl;
import com.example.demo.repository.BookRepositoryImpl2;



@Service
public class JpaSampleServiceImpl implements JpaSampleService {

    @Autowired
    BookRepositoryImpl bookRepositoryImpl;

    @Autowired
    BookRepositoryImpl2 bookRepositoryImpl2;

	public List<Book> findAll() {
    	return bookRepositoryImpl.findAll();
	}

	public List<Book> findPrimary() {
		Optional<Book> book = bookRepositoryImpl.findById(20);
    	ArrayList<Book> list = new ArrayList<>();
    	book.ifPresent(b -> list.add(b));
//		Book result = book.orElse(new Book());
//		if(book.empty) {
//			return list;
//    	} else {
//    		result = book.get();
//    		list.add(result);
//    	}
//		list.add(result);
		return list;
	}

	public List<Book> findOther() {
		return bookRepositoryImpl.findByPublisher("日経BP");
	}

	public List<Book> findGreater() {
		return bookRepositoryImpl.findByPriceGreaterThanEqual(3000);
	}

	public List<Book> findOnlyColumn() {
//		return bookRepositoryImpl.findByPriceGreaterThanEqual(3000);
		List<BookTitleOnly> bookTitles = bookRepositoryImpl2.findByPublisher("日経BP");
		List<Book> result = new ArrayList<>();
		for(BookTitleOnly bookTitle: bookTitles) {
			Book book = new Book();
			book.setIsbn("-");
			book.setTitle(bookTitle.getTitle());
			book.setPrice(0);;
			book.setPublisher("-");
			book.setPublished(null);
			result.add(book);
		}
		return result;
	}


}
