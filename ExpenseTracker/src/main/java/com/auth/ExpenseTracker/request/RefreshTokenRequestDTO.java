package com.auth.ExpenseTracker.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RefreshTokenRequestDTO {
    private String token;

}