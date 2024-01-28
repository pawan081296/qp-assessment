package com.qp.assesment.mapper;

import com.qp.assesment.entity.UserEntity;
import com.qp.assesment.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserEntity toUserEntity(UserModel userModel);

    UserModel toUserModel(UserEntity userEntity);

    default void setPasswordEncoder(){

    }

}
