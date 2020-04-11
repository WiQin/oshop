package com.oshop.item.service;

import com.oshop.common.exception.BizException;
import com.oshop.common.exception.ExceptionEnums;
import com.oshop.item.mapper.SpecGroupMapper;
import com.oshop.item.pojo.SpecGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    SpecGroupMapper groupMapper;

    @Override
    public List<SpecGroup> queryGroupByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);

        List<SpecGroup> result = groupMapper.select(specGroup);
        if (CollectionUtils.isEmpty(result)){
            throw new BizException(ExceptionEnums.SPEC_PARAM_NOT_FOUND);
        }
        return result;
    }
}
