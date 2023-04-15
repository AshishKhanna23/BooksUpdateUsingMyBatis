package com.ashish.BooksUpdateProject.controller;

import com.ashish.BooksUpdateProject.commons.BookRequest;
import com.ashish.BooksUpdateProject.commons.BookResponse;
import com.ashish.BooksUpdateProject.dtos.BookDto;
import com.ashish.BooksUpdateProject.service.BookService;
import com.ashish.BooksUpdateProject.translator.BookTranslator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    BookService bookService;
    private final BookTranslator bookTranslator;

    // Getting all the Books
    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>> getAllBooksDetails(){
        List<BookDto> bookDtos=bookService.getAllBooks();
        List<BookResponse> responses= bookTranslator.translateGetDtoListToResponse(bookDtos);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    //Getting Book Based on Id
    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable(value = "bookId")int id){
        BookDto bookDto =bookService.getBookById(id);
        return new ResponseEntity<>(bookTranslator.dtoToResponse(bookDto), HttpStatus.OK);
    }

    // Getting Book Based on Name
    @GetMapping("{bookName}")
    public ResponseEntity<BookResponse> getBookByName(@PathVariable(value = "bookName") String name){
        BookDto bookDto=bookService.getBookByName(name);
        return new ResponseEntity<>(bookTranslator.dtoToResponse(bookDto), HttpStatus.OK);
    }

    //Post Mapping
    @PostMapping
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest bookRequest){
        BookDto bookDto= bookTranslator.requestToDto(bookRequest);
        bookDto=bookService.createBook(bookDto);
        return new ResponseEntity<>(bookTranslator.dtoToResponse(bookDto), HttpStatus.CREATED);
    }

    //Updating an Existing Book
    @PostMapping(value = "/update/{bookId}")
    public ResponseEntity<BookResponse> updateBookDetails(@RequestBody BookRequest bookRequest, @PathVariable(value = "bookId") int bookId){
        BookDto bookDto= bookTranslator.requestToDto(bookRequest);
        BookDto bookDto1= bookService.updateBookDetails(bookDto, bookId);
        return new ResponseEntity<>(bookTranslator.dtoToResponse(bookDto1), HttpStatus.OK);
    }

    //Deleting a book by its Id
    @PostMapping("/delete/{bookId}")
    public ResponseEntity<Integer> deleteBook (@PathVariable(value = "bookId") int bookId){
        bookService.deleteBookDetails(bookId);
        return new ResponseEntity("Book with the given ID is Deleted !!", HttpStatus.OK);
    }


}
