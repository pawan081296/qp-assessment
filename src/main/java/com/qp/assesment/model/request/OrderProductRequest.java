package com.qp.assesment.model.request;

import com.qp.assesment.entity.ProductEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderProductRequest {

    private Long userId;
    private List<ProductEntity> productList;
}
