package com.ecommerce.basicplatform.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageParam<T> implements Serializable {
    private Integer pageSize = 10;
    private Integer pageNo = 1;
    private T param;
}
