package com.wangxu.bootweb.controller;

import com.wangxu.bootweb.domain.*;
import com.wangxu.bootweb.service.RESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class RESTController {

    @Autowired
    private RESTService restService;

    /**
     * 获取所有分类信息
     *
     * @return
     */
    @RequestMapping(value = "/catelist", method = RequestMethod.GET)
    public Result bookCateList() {
        List<BookCateInfo> allCateList = restService.findAllCateList();
        Result result = new Result(1, "请求成功了：", allCateList);
        return result;
    }

    /**
     * 获取分类下所有的图书信息
     *
     * @param cateid
     * @return
     */
    @RequestMapping(value = "/booklistInCate")
    public Result bookListByCateId(@RequestParam(name = "cateid") long cateid,
                                   @RequestParam(name = "page") int page,
                                   @RequestParam(name = "pageSize") int pageSize) {
        Page<BookInfo> bookListByCateId = restService.findBookListByCateId(cateid, PageRequest.of(page - 1, pageSize));
        PageResult<BookInfo> pageResult = new PageResult<>(page, pageSize, bookListByCateId.getTotalPages(),
                bookListByCateId.getTotalElements(), bookListByCateId.getContent());
        Result result = new Result(1, "请求成功", pageResult);
        return result;
    }


    /**
     * 获取所有图书
     *
     * @return
     */
    @RequestMapping(value = "/allbooklist", method = RequestMethod.GET)
    public Result bookList(@RequestParam(name = "page") int page, @RequestParam(name = "pageSize") int pageSize) {
        Page<BookInfo> allBookList = restService.findAllBookList(PageRequest.of(page - 1, pageSize));
        PageResult<BookInfo> pageResult = new PageResult<>(page, pageSize, allBookList.getTotalPages(),
                allBookList.getTotalElements(), allBookList.getContent());
        Result result = new Result(1, "请求成功了", pageResult);
        return result;
    }

    /**
     * 根据图书id查找图书
     *
     * @param bookid
     * @return
     */
    @RequestMapping(value = "/findBookById", method = RequestMethod.GET)
    public Result getBookInfoById(@RequestParam(name = "bookId") long bookid) {
        BookInfo bookById = restService.findBookById(bookid);
        Result result = new Result(1, "请求成功了", bookById);
        return result;
    }


    /**
     * 按图书获取章节列表的
     *
     * @param bookid
     * @return
     */
    @RequestMapping(value = "/chapterlist", method = RequestMethod.GET)
    public Result chapterList(@RequestParam(name = "bookid") long bookid,
                              @RequestParam(name = "page") int page,
                              @RequestParam(name = "pageSize") int pageSize) {
        PageRequest rpage = PageRequest.of(page - 1, pageSize);
        Page<SimpleChapterInfo> allChapterList = restService.findAllChapterList(bookid, rpage);
        List<SimpleChapterInfo> content = allChapterList.getContent();
        int totalPages = allChapterList.getTotalPages();
        long totalElements = allChapterList.getTotalElements();
        PageResult<SimpleChapterInfo> pageResult = new PageResult<SimpleChapterInfo>(page, pageSize, totalPages, totalElements, content);
        Result result = new Result(1, "请求成功", pageResult);
        return result;
    }


    /**
     * 获取章节信息通过id
     *
     * @param bookid
     * @param chapterid
     * @return
     */
    @RequestMapping(value = "/getchapterByid")
    public Result getChapterById(@RequestParam(name = "bookid") long bookid, @RequestParam(name = "chapterid") long chapterid) {
        ChapterInfo chapterById = restService.findChapterById(bookid, chapterid);
        Result result = new Result(1, "请求成功", chapterById);
        return result;
    }


}
