package com.oshop.item.service;

import com.oshop.item.pojo.SpecParam;

import java.util.List;

public interface SpecParamService {

    List<SpecParam> queryParamByGid(Long gid);
}
