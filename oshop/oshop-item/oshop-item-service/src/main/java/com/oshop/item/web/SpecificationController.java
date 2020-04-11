package com.oshop.item.web;

import com.oshop.item.pojo.SpecGroup;
import com.oshop.item.pojo.SpecParam;
import com.oshop.item.service.SpecParamService;
import com.oshop.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    SpecificationService specificationService;
    @Autowired
    SpecParamService specParamService;

    //根据商品分类id查询规格组集合
    @GetMapping("group/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupByCid(@PathVariable("cid") Long cid){

        return ResponseEntity.ok(specificationService.queryGroupByCid(cid));
    }

    //根据规格组id查询规格参数
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> qieryParamByGid(@RequestParam("gid") Long gid){
        return ResponseEntity.ok(specParamService.queryParamByGid(gid));
    }


}
