package com.example.audiobookapp;

public class Book {

    /** book title */
    private String mBookTitle;

    /** book author */
    private String mBookAuthor;

    /** book cover img */
    private int mBookCover;


    public Song(int bookCover, String bookTitle, String bookAuthor) {
        mBookCover = bookCover
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
     * get the book cover img
     */

    public String getCover(){
        return mBookCover;
    }
}
