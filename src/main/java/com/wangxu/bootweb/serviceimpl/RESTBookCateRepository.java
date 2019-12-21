package com.wangxu.bootweb.serviceimpl;

import com.wangxu.bootweb.domain.BookCateInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RESTBookCateRepository  extends JpaRepository<BookCateInfo,Long> {

    /**
     * 使用java实体名使用#{#entityName}
     * @return
     */
    @Query(value = "select b from #{#entityName} b")
    List<BookCateInfo> getCateList();

}
