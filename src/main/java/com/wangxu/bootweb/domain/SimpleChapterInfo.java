package com.wangxu.bootweb.domain;

public class SimpleChapterInfo {
    private int id;
    private long chapterId;
    private long bookId;
    private String chapterName;

    public SimpleChapterInfo(int id, long chapterId, long bookId, String chapterName) {
        this.id = id;
        this.chapterId = chapterId;
        this.bookId = bookId;
        this.chapterName = chapterName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getChapterId() {
        return chapterId;
    }

    public void setChapterId(long chapterId) {
        this.chapterId = chapterId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
}
