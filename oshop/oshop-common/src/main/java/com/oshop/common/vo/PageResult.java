package com.oshop.common.vo;

import lombok.Data;

import java.util.List;

/**
 * ${Description}
 *
 * @author wyw
 * @date 2020/03/14
 */
@Data
public class PageResult<T> {
    private Long total;//总条数
    private Integer totalPage;;//总页数
    private List<T> result;

    public PageResult() {
    }

    public PageResult(Long total, List<T> result) {
        this.total = total;
        this.result = result;
    }

    public PageResult(Long total, Integer totalPage, List<T> result) {
        this.total = total;
        this.totalPage = totalPage;
        this.result = result;
    }
}
