package com.oshop.item.service;

import com.oshop.common.vo.PageResult;
import com.oshop.item.pojo.Brand;

import java.util.List;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/14
 */
public interface BrandService {
    PageResult<Brand> queryBrandByPage(Integer page,Integer rows,String sortBy,Boolean desc,String key);

    Void saveBrand(Brand brand, List<Long> cids);

    Brand queryBrandById(Long id);

    List<Brand> queryBrandByCid(Long cid);
}
