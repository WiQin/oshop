package com.oshop.item.service;


import com.oshop.item.pojo.Item;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ItemServiceImpl implements ItemService {

    @Override
    public Item saveItem(Item item){
        int i = new Random().nextInt(100);
        item.setId(Long.valueOf(i));
        return item;
    }
}
