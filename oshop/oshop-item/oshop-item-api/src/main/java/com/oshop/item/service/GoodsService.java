package com.oshop.item.service;

import com.oshop.common.vo.PageResult;
import com.oshop.item.pojo.Spu;
import com.oshop.item.pojo.SpuBo;

import java.util.List;

public interface GoodsService {

    PageResult<Spu> querySpuByPage(Integer page, Integer rows, Boolean saleable, String key);

}
