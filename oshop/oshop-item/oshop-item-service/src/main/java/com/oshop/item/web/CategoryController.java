package com.oshop.item.web;

import com.oshop.item.pojo.Category;
import com.oshop.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/08
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoryByPid(@RequestParam("pid")Long pid){

        return ResponseEntity.ok(categoryService.queryCategoryByPid(pid));//简写
//        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
