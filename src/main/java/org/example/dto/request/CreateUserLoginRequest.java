package org.example.dto.request;

import lombok.Data;

@Data
public class CreateUserLoginRequest {
    private String userName ;
    private String password ;
}
