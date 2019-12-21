package com.wangxu.bootweb.serviceimpl;

import com.wangxu.bootweb.domain.BookInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RESTBookRepository extends JpaRepository<BookInfo, Long> {

    /**
     * 如果bean里面entity使用了name就是用name的值，并且所有字段都是用表里的。最后要使用nativeQuery=true 声明使用原生sql
     * @param bookid
     * @return
     */
    @Query(value = "select id,bookid,bookName,bookAuthor,cateId from book_list b where bookid =?1",nativeQuery = true)
    BookInfo findByBookId(long bookid);

    /**
     * 根据分类id查找啊图书
     * @param cateid
     * @return
     */
    @Query("select b from #{#entityName} b where b.cateId = ?1")
    Page<BookInfo> findBooksBuCateid(long cateid, Pageable page);

    @Query("select b from #{#entityName} b")
    Page<BookInfo> finaAllBooks(Pageable page);
}
