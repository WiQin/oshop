package com.oshop.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oshop.common.exception.BizException;
import com.oshop.common.exception.ExceptionEnums;
import com.oshop.common.vo.PageResult;
import com.oshop.item.mapper.BrandMapper;
import com.oshop.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/14
 */
@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //1.分页
        PageHelper.startPage(page,rows);
        /**
         * where name like "%x%" or letter = "x"
         * order by id desc
         */
        //2.过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)){
            example.createCriteria().orLike("name","%"+key+"%")
                    .orEqualTo("letter",key.toUpperCase());
        }
        //3.排序
        if (StringUtils.isNotBlank(sortBy)){
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        //4.查询
        List<Brand> result = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(result)){
            throw new BizException(ExceptionEnums.BRAND_NOT_FOUND);
        }
        PageInfo<Brand> pageInfo = new PageInfo<>(result);

        return new PageResult<>(pageInfo.getTotal(),result);
    }
}
