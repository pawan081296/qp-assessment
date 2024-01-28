package com.qp.assesment.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AuthRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
