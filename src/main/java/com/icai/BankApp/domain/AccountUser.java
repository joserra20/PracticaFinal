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
@Table("ACCOUNT_USER")
public class AccountUser {

    private @Column("id") @Id Long id;

    private @Column("account_id") Long account_id;

    private @Column("user_id") Long user_id;


    private AccountUser(Long account_id, Long user_id){
        this.account_id = account_id;
        this.user_id = user_id;
    }

}
