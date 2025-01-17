package com.auth.ExpenseTracker.model;

import com.auth.ExpenseTracker.entities.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@JsonNaming (PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class UserInfoDto extends UserInfo
{

    private String firstName; // first_name

    private String lastName; //last_name

    private Long phoneNumber;

    private String email; // email

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Long getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmail(){
        return email;
    }

}
