package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Book;
import com.example.demo.service.JpaSampleService;

@RestController
//@Controller
//@RequestMapping("api/*")
public class SelectSampleController {
    @Autowired
    JpaSampleService service;

    @GetMapping("/index")
    ModelAndView index(ModelAndView model) {
        model.setViewName("Index");
        return model;
    }

    //全検索
    @GetMapping("/select")
    ModelAndView findAll(ModelAndView model) {
        List<Book> result = service.findAll();
        model.setViewName("JpaSelect");
        model.addObject("books", result);
        return model;
    }

    //主キーで検索
    @GetMapping("/select/primary")
    ModelAndView findPrimary(ModelAndView model) {
        List<Book> result = service.findPrimary();
        model.setViewName("JpaSelect");
        model.addObject("books", result);
        return model;
    }

    //任意の列で検索
    @GetMapping("/select/other")
    ModelAndView findOther(ModelAndView model) {
        List<Book> result = service.findOther();
        model.setViewName("JpaSelect");
        model.addObject("books", result);
        return model;
    }

    //以上
    @GetMapping("/select/greater")
    ModelAndView findGreater(ModelAndView model) {
        List<Book> result = service.findGreater();
        model.setViewName("JpaSelect");
        model.addObject("books", result);
        return model;
    }

    //特定の列
    @GetMapping("/select/onlycolumn")
    ModelAndView findOnlyColumn(ModelAndView model) {
        List<Book> result = service.findOnlyColumn();
        model.setViewName("JpaSelect");
        model.addObject("books", result);
        return model;
    }


/*
	<label>全検索</label><a th:href ="@{/select}"></a>
	<label>主キーで検索</label><a th:href ="@{/select/primary}"></a>
	<label>任意の列で検索</label><a th:href ="@{/select/other}"></a>
	<label>以上</label><a th:href ="@{/select/greater}"></a>
	<label>LIKE</label><a th:href ="@{/select/like}"></a>
	<label>含む</label><a th:href ="@{/select/contain}"></a>
	<label>AND条件</label><a th:href ="@{/select/and}"></a>
	<label>ソート</label><a th:href ="@{/select/sort}"></a>
	<label>特定の列だけ</label><a th:href ="@{/select/onlycolumn}"></a>
	<label>重複除去</label><a th:href ="@{/select/other}"></a>
	<label>自作</label><a th:href ="@{/select/custom}"></a>
	*/
}