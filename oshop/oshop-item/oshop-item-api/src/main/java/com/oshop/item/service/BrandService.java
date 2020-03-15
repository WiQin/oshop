package com.oshop.item.service;

import com.oshop.common.vo.PageResult;
import com.oshop.item.pojo.Brand;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/14
 */
public interface BrandService {
    PageResult<Brand> queryBrandByPage(Integer page,Integer rows,String sortBy,Boolean desc,String key);
}
