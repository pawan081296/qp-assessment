package com.qp.assesment.service.Impl;

import com.qp.assesment.entity.OrderProductEntity;
import com.qp.assesment.mapper.OrderProductMapper;
import com.qp.assesment.model.OrderProductModel;
import com.qp.assesment.repository.OrderProductRepo;
import com.qp.assesment.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    OrderProductRepo orderProductRepo;
    @Autowired
    OrderProductMapper orderProductMapper;

    @Override
    public OrderProductEntity create(OrderProductModel orderProductModel) {
        return orderProductRepo.save(orderProductMapper.toOrderProductEntity(orderProductModel));
    }
}
