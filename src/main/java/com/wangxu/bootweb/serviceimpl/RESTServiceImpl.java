package com.wangxu.bootweb.serviceimpl;

import com.wangxu.bootweb.domain.BookCateInfo;
import com.wangxu.bootweb.domain.BookInfo;
import com.wangxu.bootweb.domain.ChapterInfo;
import com.wangxu.bootweb.domain.SimpleChapterInfo;
import com.wangxu.bootweb.service.RESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //外面使用autowired里面得要这个注解
public class RESTServiceImpl implements RESTService {

    @Autowired
    private RESTBookCateRepository bookCateRepository;

    @Autowired
    private RESTBookRepository bookRepository;

    @Autowired
    private RESTChapterRepository chapterRepository;

    @Override
    public List<BookCateInfo> findAllCateList() {
        return bookCateRepository.findAll();
    }

    @Override
    public Page<BookInfo> findAllBookList(Pageable page) {
        return bookRepository.finaAllBooks(page);
    }

    @Override
    public Page<SimpleChapterInfo> findAllChapterList(long bookid, Pageable rpage) {
        return chapterRepository.findChapterList(bookid,rpage);
    }

    @Override
    public Page<BookInfo> findBookListByCateId(long cateid,Pageable pageable) {
        return bookRepository.findBooksBuCateid(cateid,pageable);
    }

    @Override
    public BookInfo findBookById(long bookid) {
        return bookRepository.findByBookId(bookid);
    }

    @Override
    public ChapterInfo findChapterById(long bookid, long chapterid) {
        return chapterRepository.findChapterById(bookid,chapterid);
    }


}
