package com.ashish.BooksUpdateProject.mapper;

import com.ashish.BooksUpdateProject.model.BookDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    List<BookDetails> getAllBooksDetails();
    BookDetails findById(int id);
    int insertBook(BookDetails book);
    int updateBook(BookDetails bookDetails);
    int deleteBook(int bookId);
    BookDetails findByName(String name);




}
