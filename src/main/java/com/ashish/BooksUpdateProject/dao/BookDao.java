package com.ashish.BooksUpdateProject.dao;

import com.ashish.BooksUpdateProject.dtos.BookDto;

import java.util.List;

public interface BookDao {

    List<BookDto> getAllBooksDetails();
    BookDto findById(int id);
    BookDto insertBook(BookDto bookDto);
    BookDto updateBook(BookDto bookDto, int bookId);
    boolean deleteBook(int bookId);
    BookDto findByName(String name);

}
