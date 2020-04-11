package com.oshop.item.service;

import com.oshop.item.pojo.SpecGroup;

import java.util.List;

public interface SpecificationService {

    List<SpecGroup> queryGroupByCid(Long cid);
}
