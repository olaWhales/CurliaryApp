package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserSignUp {
    @Id
    private String id;
    private String fullName ;
    private String username;
    private String email;
    private String password ;
}