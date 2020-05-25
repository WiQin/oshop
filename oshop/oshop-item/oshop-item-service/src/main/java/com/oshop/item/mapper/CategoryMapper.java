package com.oshop.item.mapper;

import com.oshop.item.pojo.Category;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/08
 */
@Service
public interface CategoryMapper extends Mapper<Category>, IdListMapper<Category,Long> {
}
