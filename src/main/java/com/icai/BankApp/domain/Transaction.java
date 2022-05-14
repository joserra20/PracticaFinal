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
@Table("TRANSACTION")
public class Transaction {
    private @Column("id") @Id Long id;

    private @Column("origin_acc") UserType originAcc;

    private @Column("destination_acc") String destinationAcc;
}
