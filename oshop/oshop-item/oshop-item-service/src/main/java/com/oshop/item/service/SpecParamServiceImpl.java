package com.oshop.item.service;

import com.netflix.discovery.converters.Auto;
import com.oshop.common.exception.BizException;
import com.oshop.common.exception.ExceptionEnums;
import com.oshop.item.mapper.SpecParamMapper;
import com.oshop.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SpecParamServiceImpl implements SpecParamService {

    @Autowired
    SpecParamMapper specParamMapper;

    @Override
    public List<SpecParam> queryParamByGid(Long gid) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);

        List<SpecParam> result = specParamMapper.select(specParam);
        if (CollectionUtils.isEmpty(result)){
            throw new BizException(ExceptionEnums.SPEC_GROUP_NOT_FOUND);
        }

        return null;
    }
}
