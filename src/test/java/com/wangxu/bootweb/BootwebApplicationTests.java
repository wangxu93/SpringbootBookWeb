package com.wangxu.bootweb;

import com.wangxu.bootweb.domain.BookInfo;
import com.wangxu.bootweb.domain.SimpleChapterInfo;
import com.wangxu.bootweb.serviceimpl.RESTBookCateRepository;
import com.wangxu.bootweb.serviceimpl.RESTBookRepository;
import com.wangxu.bootweb.serviceimpl.RESTChapterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BootwebApplicationTests {

    @Autowired
    private RESTBookRepository restBookRepository;

    @Autowired
    private RESTChapterRepository restChapterRepository;

    @Autowired
    private RESTBookCateRepository cateRepository;

    @Test
    void contextLoads() {
//        BookInfo byBookId = restBookRepository.findByBookId(1000020);
        ArrayList<String> id = new ArrayList<String>();
        id.add("id");
        Pageable page = PageRequest.of(1, 20);
        Page<SimpleChapterInfo> chapterList = restChapterRepository.findChapterList(1000022, page);
        System.out.println(chapterList.getTotalPages());
    }

    @Test
    void testCate() {
//        List<BookCateInfo> chapterList = cateRepository.getCateList();
//        System.out.println(chapterList);
        Page<BookInfo> booksBuCateid = restBookRepository.findBooksBuCateid(100001,PageRequest.of(1,10));
        for (BookInfo bookInfo : booksBuCateid) {
            System.out.println(bookInfo.getBookName());
        }
    }

}
