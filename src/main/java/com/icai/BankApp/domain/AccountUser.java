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

    private @Column("ID") @Id Long id;

    private @Column("A_ID") Long a_id;

    private @Column("U_ID") Long u_id;


    public AccountUser(Long account_id, Long user_id){
        this.a_id = account_id;
        this.u_id = user_id;
    }

}
