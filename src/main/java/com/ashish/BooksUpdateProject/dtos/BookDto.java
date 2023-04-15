package com.ashish.BooksUpdateProject.dtos;

import lombok.Data;

@Data
public class BookDto {

    private Integer id;
    private String bookName;
    private String authorName;
    private int price;
    private boolean isAvailable;
}
