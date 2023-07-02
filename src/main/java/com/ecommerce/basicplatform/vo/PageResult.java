package com.ecommerce.basicplatform.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 */
@Data
public class PageResult<T> implements Serializable {
    private Integer pageSize = 10;
    private Integer pageNo = 1;
    private Long totalCount;
    private List<T> data;

    public PageResult(){

    }
    public PageResult(int pageNo, int pageSize){
        super();
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
