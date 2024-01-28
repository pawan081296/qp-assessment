package com.qp.assesment.mapper;

import com.qp.assesment.entity.OrderEntity;
import com.qp.assesment.model.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    @Mapping(target = "userEntity",source = "user")
    OrderEntity toOrderEntity(OrderModel orderModel);

    OrderModel toModel(OrderEntity orderEntity);

}
