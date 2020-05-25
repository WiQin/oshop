package com.oshop.item.service;

import com.oshop.item.pojo.Category;

import java.util.List;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/08
 */
public interface CategoryService {

    List<Category> queryCategoryByPid(Long pid);

    List<Category> queryByIds(List<Long> ids);
}
