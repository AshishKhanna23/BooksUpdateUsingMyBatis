package com.ashish.BooksUpdateProject.translator;

import com.ashish.BooksUpdateProject.commons.BookRequest;
import com.ashish.BooksUpdateProject.commons.BookResponse;
import com.ashish.BooksUpdateProject.dtos.BookDto;
import com.ashish.BooksUpdateProject.model.BookDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Data
@AllArgsConstructor
public class BookTranslator {

    @Autowired
    ModelMapper modelMapper;

    public BookDto requestToDto(BookRequest bookRequest) {return (modelMapper.map(bookRequest, BookDto.class));}

    public BookDetails dtoToEntity(BookDto bookDto){
        return (modelMapper.map(bookDto, BookDetails.class));
    }

    public BookDto entityToDto(BookDetails bookDetails){
        return (modelMapper.map(bookDetails, BookDto.class));
    }

    public BookResponse dtoToResponse(BookDto bookDto){
        return (modelMapper.map(bookDto, BookResponse.class));
    }

    public List<BookDto> translateDetailsListToDto(List<BookDetails> bookDetailsList){
        List<BookDto> bookDtos= new ArrayList<>();
        for (BookDetails bookDetails : bookDetailsList){
            bookDtos.add(modelMapper.map(bookDetails, BookDto.class));
        }
        return bookDtos;
    }

    public List<BookResponse> translateGetDtoListToResponse(List<BookDto> bookDtos){
        List<BookResponse> responses= new ArrayList<>();
        for (BookDto bookDto : bookDtos){
            responses.add(modelMapper.map(bookDto, BookResponse.class));
        }
        return responses;
    }

}
