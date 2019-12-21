package com.wangxu.bootweb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "book_list")
public class BookInfo {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false,name = "bookName",unique = true)
    private String bookName;

    @Column(nullable = false,name = "bookAuthor",unique = true)
    private String bookAuthor;

    @Column(nullable = false,name = "cateId",unique = true)
    private long cateId;

    @Column(nullable = false,name = "bookid",unique = true)
    private long bookid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public long getCateId() {
        return cateId;
    }

    public void setCateId(long cateId) {
        this.cateId = cateId;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }
}
