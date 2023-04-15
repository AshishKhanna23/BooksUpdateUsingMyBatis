package com.ashish.BooksUpdateProject.dao;

import com.ashish.BooksUpdateProject.dtos.BookDto;
import com.ashish.BooksUpdateProject.exception.NoBookFoundException;
import com.ashish.BooksUpdateProject.exception.ResourceNotFoundException;
import com.ashish.BooksUpdateProject.mapper.BookMapper;
import com.ashish.BooksUpdateProject.model.BookDetails;
import com.ashish.BooksUpdateProject.translator.BookTranslator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
@AllArgsConstructor
public class BookDaoImpl implements BookDao{

    @Autowired
    BookMapper bookMapper;

    @Autowired
    BookTranslator bookTranslator;

    @Override
    public List<BookDto> getAllBooksDetails() {
        List<BookDetails> bookDetails= bookMapper.getAllBooksDetails();
        return bookTranslator.translateDetailsListToDto(bookDetails);
    }

    @Override
    public BookDto findById(int bookId) {
        BookDetails bookDetails=bookMapper.findById(bookId);
        if (bookDetails==null){
            throw new ResourceNotFoundException("Book",bookId);
        }
        if (bookDetails.isAvailable()==false){
            throw new ResourceNotFoundException("Book", bookId);
        }
        BookDto bookDto=bookTranslator.entityToDto(bookDetails);
        return bookDto;
    }

    @Override
    public BookDto findByName(String bookName) {
        BookDetails bookDetails=bookMapper.findByName(bookName);
        if (bookDetails == null){
            throw new NoBookFoundException();
        }
        if (bookDetails.isAvailable()==false){
            throw new NoBookFoundException();
        }
        BookDto bookDto=bookTranslator.entityToDto(bookDetails);
        return bookDto;
    }

    @Override
    public BookDto insertBook(BookDto bookDto) {
        bookDto.setAvailable(true);
        bookMapper.insertBook(bookTranslator.dtoToEntity(bookDto));
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookDto bookDto, int bookId) {
        BookDetails bookDetails=bookMapper.findById(bookId);
        if (bookDetails == null){
            throw new ResourceNotFoundException("book",bookId);
        }
        if (bookDetails.isAvailable()==false){
            throw new NoBookFoundException("Book is not available");
        }
        bookDetails.setBookName(bookDto.getBookName());
        bookDetails.setAuthorName(bookDto.getAuthorName());
        bookDetails.setPrice(bookDto.getPrice());
        bookDetails.setId(bookId);
        bookDetails.setAvailable(true);
        bookMapper.updateBook(bookDetails);
        return (bookTranslator.entityToDto(bookDetails));
    }

    @Override
    public boolean deleteBook(int bookId) {
        BookDetails bookDetails= bookMapper.findById(bookId);
        if (bookDetails==null){
            throw new NoBookFoundException("Book not Found");
        }
        bookDetails.setAvailable(false);
        bookMapper.updateBook(bookDetails);
        return true;
    }


}
