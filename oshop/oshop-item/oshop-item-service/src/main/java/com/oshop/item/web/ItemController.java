package com.oshop.item.web;

import com.oshop.common.exception.BizException;
import com.oshop.common.exception.ExceptionEnums;
import com.oshop.item.pojo.Item;
import com.oshop.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/01/20
 */

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    /**
     *
     * @ResponseBody : java对象序列化放入响应体中
     *
     * 使用ResponseEntity接收响应（状态码，响应体等）
     *
     * 状态码返回：枚举
     * 响应体：返回实体
     *
     * @param item
     * @return
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Item> saveItem(Item item) {
        //校验价格
        if (null == item.getPrice()){
            throw new BizException(ExceptionEnums.PRICE_IS_NULL);
        }
        item = itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item) ;
    }
}