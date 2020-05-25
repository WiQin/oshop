package com.oshop.item.service;

import com.oshop.common.exception.BizException;
import com.oshop.common.exception.ExceptionEnums;
import com.oshop.item.mapper.CategoryMapper;
import com.oshop.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/08
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);

        //以对象中的非空字段作为查询条件
        List<Category> result = categoryMapper.select(category);
        if (CollectionUtils.isEmpty(result)){
            //返回404
            throw new BizException(ExceptionEnums.CATEGORY_NOT_FOUND);
        }
        return result;
    }

    @Override
    public List<Category> queryByIds(List<Long> ids) {
        List<Category> categories = categoryMapper.selectByIdList(ids);
        if (CollectionUtils.isEmpty(categories)){
            //返回404
            throw new BizException(ExceptionEnums.CATEGORY_NOT_FOUND);
        }
        return categories;
    }
}
