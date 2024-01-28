package com.qp.assesment.service;

import com.qp.assesment.entity.OrderProductEntity;
import com.qp.assesment.model.OrderProductModel;

public interface OrderProductService {

    OrderProductEntity create(OrderProductModel orderProductModel);
}
