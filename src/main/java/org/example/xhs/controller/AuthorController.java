package org.example.xhs.controller;

import org.example.xhs.entity.req.Author;
import org.example.xhs.entity.rsp.AuthorRsp;
import org.example.xhs.response.AjaxResult;
import org.example.xhs.response.PageResult;
import org.example.xhs.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/author")
@RestController
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @PostMapping("/query")
    public AjaxResult<PageResult<AuthorRsp>> query(@RequestBody Author author){
        PageResult<AuthorRsp> pageResult = authorService.query(author);
        return new AjaxResult<>(pageResult);
    }

    @GetMapping("/dropList")
    public AjaxResult<List<AuthorRsp>> dropList(@RequestParam(value = "keyword", required = false) String keyWord){
        List<AuthorRsp> list = authorService.dropList(keyWord);
        return new AjaxResult<>(list);
    }
}
