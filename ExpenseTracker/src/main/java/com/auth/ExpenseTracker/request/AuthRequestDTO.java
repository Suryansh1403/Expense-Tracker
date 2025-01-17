package com.auth.ExpenseTracker.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthRequestDTO {

    private String username;
    private String password;


}
