package com.ashish.BooksUpdateProject.model;

import lombok.Data;

@Data
public class BookDetails {

    private int id;
    private String bookName;
    private String authorName;
    private int price;
    private boolean isAvailable;
}
