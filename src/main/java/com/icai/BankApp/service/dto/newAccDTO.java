package com.icai.BankApp.service.dto;

import com.icai.BankApp.domain.UserType;
import lombok.Data;

@Data
public class newAccDTO {
    String IBAN;

    Float balance;

    String dni;

    UserType userType;

}
