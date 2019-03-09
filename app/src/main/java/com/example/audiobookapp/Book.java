package com.example.audiobookapp;

public class Book {

    /** book title */
    private String mBookTitle;

    /** book author */
    private String mBookAuthor;

    /** book cover img */
    private int mBookCoverId;


    public Book(String bookTitle, String bookAuthor, int bookCoverId) {
        mBookCoverId = bookCoverId;
        mBookTitle = bookTitle;
        mBookAuthor = bookAuthor;
    }

    public Book(String bookTitle, String bookAuthor) {
        mBookTitle = bookTitle;
        mBookAuthor = bookAuthor;
    }

    /**
     * get the book title
     */

    public String getTitle(){
        return mBookTitle;
    }

    /**
     * get the book author
     */

    public String getAuthor(){
        return mBookAuthor;
    }

    /**
     * get the book cover img id
     */

    public int getCoverId(){
        return mBookCoverId;
    }
}
