package com.ashish.BooksUpdateProject.commons;

import lombok.Data;

@Data
public class BookRequest {

    private String bookName;
    private String authorName;
    private Integer price;
}
