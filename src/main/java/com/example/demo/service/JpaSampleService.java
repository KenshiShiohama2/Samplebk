package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Book;

public interface JpaSampleService {

	public List<Book> findAll();
	public List<Book> findPrimary();
	public List<Book> findOther();
	public List<Book> findGreater();
	public List<Book> findOnlyColumn();

}