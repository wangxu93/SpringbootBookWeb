package com.wangxu.bootweb.controller;

import com.wangxu.bootweb.domain.BookCateInfo;
import com.wangxu.bootweb.service.RESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 图书控制器，用来显示图书页面的
 */
@Controller
public class BookContoller {

    @Autowired
    private RESTService restService;

    @RequestMapping(value = "/mmain")
    public String main(Model model){
        List<BookCateInfo> allCateList = restService.findAllCateList();
        model.addAttribute("cateList",allCateList);
        return "main";
    }
}
