package com.qp.assesment.model;

import com.qp.assesment.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderModel {

    private String orderStatus;
    private UserEntity user;
}
