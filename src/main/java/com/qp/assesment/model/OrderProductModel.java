package com.qp.assesment.model;

import com.qp.assesment.entity.OrderEntity;
import com.qp.assesment.entity.ProductEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProductModel {

    private Long id;
    private Integer quantity;
    private OrderEntity order;
    private ProductEntity product;
}
