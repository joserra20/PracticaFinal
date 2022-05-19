package com.icai.BankApp.DTO;

import com.icai.BankApp.domain.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccount {


    String IBAN;

    Float balance;

    UserType userType;

    String firstName;

    String lastName;

    String email;

}
