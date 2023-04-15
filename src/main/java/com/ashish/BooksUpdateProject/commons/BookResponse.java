package com.ashish.BooksUpdateProject.commons;

import lombok.Data;

@Data
public class BookResponse {

    private Integer id;
    private String bookName;
    private String authorName;
    private int price;

}
