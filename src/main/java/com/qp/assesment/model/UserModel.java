package com.qp.assesment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qp.assesment.entity.RoleEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserModel {

    private Long id;

    @NotEmpty
    @Size(min = 4, message = "Name must be min of 4 characters !!")
    private String name;

    @Email(message = "Email address is not valid !!")
    @NotEmpty(message = "Email is required !!")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars !!")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotEmpty
    @Size(min = 10, max = 10, message = "Mobile number must be of 10 digits")
    private String mobileNumber;

    private RoleEntity role;
}
