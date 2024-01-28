package com.qp.assesment.service;

import com.qp.assesment.model.request.OrderProductRequest;

public interface OrderService {

    void saveOrder(OrderProductRequest orderProductRequest);
}
