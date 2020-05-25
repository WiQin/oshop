package com.oshop.item.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oshop.common.exception.BizException;
import com.oshop.common.exception.ExceptionEnums;
import com.oshop.common.vo.PageResult;
import com.oshop.item.mapper.BrandMapper;
import com.oshop.item.mapper.SpuDetailmapper;
import com.oshop.item.mapper.SpuMapper;
import com.oshop.item.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SpuDetailmapper spuDetailmapper;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;

    /**
     * 分页查询spu信息
     *
     * @param page
     * @param rows
     * @param saleable
     * @param key
     * @return
     */
    public PageResult<Spu> querySpuByPage(Integer page, Integer rows, Boolean saleable, String key) {
        //1.分页
        PageHelper.startPage(page, rows);
        //2.条件过滤
        Example example = new Example(Spu.class);
        //搜索字段过滤（默认根据名称搜索）
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().andLike("title", "%" + key + "%");
        }
        //上下架过滤
        if (null != saleable) {
            example.createCriteria().andEqualTo(saleable);
        }
        //3.默认排序(会自动订正为驼峰命名)
        example.setOrderByClause("last_update_time DESC");

        //查询
        List<Spu> spus = spuMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(spus)) {
            throw new BizException(ExceptionEnums.GOOD_NOT_FOUND);
        }

        //解析分类和品牌名称
        loadCategoryAndBrandName(spus);
        //解析分页结果
        PageInfo<Spu> spuPageInfo = new PageInfo<>(spus);
        return new PageResult<Spu>(spuPageInfo.getTotal(), spus);

    }

    /**
     * 根据spu信息解析其分类和品牌名称
     *
     * @param spus
     */
    private void loadCategoryAndBrandName(List<Spu> spus) {
        for (Spu spu : spus) {
            //处理分类名称（三级分类）
            List<Category> categoryList = categoryService.queryByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));
            List<String> nameList = categoryList.stream().map(Category::getName).collect(Collectors.toList());
            spu.setCName(StringUtils.join(nameList,"/"));
            //处理品牌名称
            spu.setBname(brandService.queryBrandById(spu.getBrandId()).getName());
        }
    }
}
