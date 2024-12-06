package org.example.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class CreateUserSignUpRequest {
    private String fullName ;
    private String email ;
    private String userName ;
    private String password ;
}
