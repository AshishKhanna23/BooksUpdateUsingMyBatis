package com.ashish.BooksUpdateProject.service.serviceImpl;

import com.ashish.BooksUpdateProject.dao.BookDao;
import com.ashish.BooksUpdateProject.dtos.BookDto;
import com.ashish.BooksUpdateProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;


   // Get All Books Details
    @Override
    public List<BookDto> getAllBooks(){
        List<BookDto> bookDtos=bookDao.getAllBooksDetails();
        return bookDtos;
    }

    // Get Book Details by Id
    @Override
    public BookDto getBookById(int bookId) {
        return bookDao.findById(bookId);
    }

    // Get Book Details by Name
    @Override
    public BookDto getBookByName(String bookName) {
       return bookDao.findByName(bookName);
    }

    // Updating an Existing Book Details
    @Override
    public BookDto updateBookDetails(BookDto bookDto, int bookId) {
        return bookDao.updateBook(bookDto, bookId);
    }

    //Create a new Entry for Book
    @Override
    public BookDto createBook(BookDto bookDto) {
        return bookDao.insertBook(bookDto);
    }

    // Deleting an existing book details ( NOT EXACTLY)
    @Override
    public boolean deleteBookDetails(int bookId) {
        return bookDao.deleteBook(bookId);
    }

}
