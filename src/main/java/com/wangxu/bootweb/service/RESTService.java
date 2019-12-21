package com.wangxu.bootweb.service;

import com.wangxu.bootweb.domain.BookCateInfo;
import com.wangxu.bootweb.domain.BookInfo;
import com.wangxu.bootweb.domain.ChapterInfo;
import com.wangxu.bootweb.domain.SimpleChapterInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RESTService {

    List<BookCateInfo> findAllCateList();

    Page<BookInfo> findAllBookList(Pageable page);

    Page<BookInfo> findBookListByCateId(long cateid,Pageable page);

    BookInfo findBookById(long bookid);


    Page<SimpleChapterInfo> findAllChapterList(long bookid, Pageable rpage);


    ChapterInfo findChapterById(long bookid,long chapterid);
}
