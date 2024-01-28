package com.qp.assesment.service.Impl;

import com.qp.assesment.entity.OrderEntity;
import com.qp.assesment.entity.OrderProductEntity;
import com.qp.assesment.entity.ProductEntity;
import com.qp.assesment.entity.UserEntity;
import com.qp.assesment.entity.constants.OrderStatus;
import com.qp.assesment.exceptions.ApiException;
import com.qp.assesment.exceptions.ResourceNotFoundException;
import com.qp.assesment.mapper.OrderMapper;
import com.qp.assesment.mapper.OrderProductMapper;
import com.qp.assesment.model.OrderModel;
import com.qp.assesment.model.OrderProductModel;
import com.qp.assesment.model.request.OrderProductRequest;
import com.qp.assesment.repository.OrderProductRepo;
import com.qp.assesment.repository.OrderRepo;
import com.qp.assesment.repository.ProductRepo;
import com.qp.assesment.repository.UserRepo;
import com.qp.assesment.service.OrderService;
import com.qp.assesment.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderProductMapper orderProductMapper;
    @Autowired
    ProductService productService;

    @Autowired
    OrderProductRepo orderProductRepo;

    @Override
    @Transactional
    public void saveOrder(OrderProductRequest order) {

        if (CollectionUtils.isEmpty(order.getProductList())) return;

        //Check if the products exist in the database;
        List<ProductEntity> productList = order.getProductList().stream()
                .filter(data -> Objects.isNull(productService.getProductDetailsById(data.getId()))).toList();
        if (!CollectionUtils.isEmpty(productList)) {
            throw new ResourceNotFoundException("Products not found");
        }

        //Get the user details to by user id
        UserEntity user = userRepo.findById(order.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User ", "Id", order.getUserId()));

        //Save the Order data
        OrderEntity orderEntity = orderRepo.save(orderMapper.toOrderEntity(OrderModel.builder()
                .orderStatus(OrderStatus.PAID.toString()).user(user).build()));

        //Update the product quantity(Manage Inventory levels according to the order)
        order.getProductList().forEach(productEntity -> {
            int status = productRepo.updateProductQuantity(productEntity.getId(), productEntity.getQuantity());
            if(status == 0) throw  new ApiException("Requested quantity is higher than available");
        });

        //Get all the Products
        List<OrderProductEntity> orderProductModelList = new ArrayList<>();
        order.getProductList().forEach(product -> {
            //Get the product by Id
            ProductEntity productEntity = productRepo.findById(product.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", product.getId()));
            orderProductModelList.add(OrderProductEntity.builder()
                    .product(productEntity).order(orderEntity).quantity(product.getQuantity()).build());
        });
        log.debug("OrderProduct "+orderProductModelList);

        orderProductRepo.saveAll(orderProductModelList);

    }
}
