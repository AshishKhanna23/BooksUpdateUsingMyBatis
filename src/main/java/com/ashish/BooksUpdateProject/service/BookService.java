package com.ashish.BooksUpdateProject.service;

import com.ashish.BooksUpdateProject.dtos.BookDto;
import java.util.List;

public interface BookService {

    public BookDto createBook(BookDto bookDto);

    public List<BookDto> getAllBooks();

    public BookDto getBookById(int bookId);

    public BookDto updateBookDetails(BookDto bookDto, int bookId);

    public boolean deleteBookDetails(int bookId);

    public BookDto getBookByName(String bookName);
}
