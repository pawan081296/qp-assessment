package com.qp.assesment.mapper;

import com.qp.assesment.entity.ProductEntity;
import com.qp.assesment.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.lang.annotation.Target;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    List<ProductEntity> toProductEntityList(List<ProductModel> productModels);

    List<ProductModel> toProductList(List<ProductEntity> productEntityList);

    ProductEntity toProductEntity(ProductModel products);

    ProductEntity toProductEntity(ProductModel products, @MappingTarget ProductEntity productEntity);

    ProductModel toProduct(ProductEntity productEntity);

}
