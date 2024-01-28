package com.qp.assesment.mapper;

import com.qp.assesment.entity.OrderProductEntity;
import com.qp.assesment.model.OrderProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderProductMapper {

    OrderProductEntity toOrderProductEntity(OrderProductModel orderModel);
    List<OrderProductEntity> toOrderProductEntityList(List<OrderProductModel> orderModel);

    OrderProductModel toModel(OrderProductEntity orderEntity);

}
