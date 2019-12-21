package com.wangxu.bootweb.serviceimpl;

import com.wangxu.bootweb.domain.ChapterInfo;
import com.wangxu.bootweb.domain.SimpleChapterInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RESTChapterRepository extends JpaRepository<ChapterInfo, Long> {

    @Query(value = "select new com.wangxu.bootweb.domain.SimpleChapterInfo(c.id,c.chapterid,c.bookId,c.chapterName) from #{#entityName} c where c.bookId=?1")
    Page<SimpleChapterInfo> findChapterList(long bookid, Pageable page);

    @Query(value = "select c from #{#entityName} c where c.bookId=?1 and c.chapterid=?2")
    ChapterInfo findChapterById(long bookid,long chapterid);
}
