package com.icai.BankApp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("ACCOUNT")
public class Account {
    private @Column("id") @Id Long id;

    private @Column("IBAN") String IBAN;

    private @Column("balance") float balance;

    private @Column("USER_TYPE") String userType;

    public Account(String iban, float balance, String userType){
        this.IBAN= iban;
        this.balance = balance;
        this.userType = userType;
    }
}
