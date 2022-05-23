package com.icai.BankApp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("TRANSACTION")
public class Transaction {
    private @Column("ID") @Id Long id;

    private @Column("ORIGIN_ACC") Long originAcc;

    private @Column("DESTINATION_ACC") Long destinationAcc;

    private @Column("AMOUNT") float amount;

    private @Column("DATE")  LocalDate date;

    public Transaction(Long originAcc, Long destinationAcc, float amount, LocalDate date) {
        this.originAcc = originAcc;
        this.destinationAcc = destinationAcc;
        this.amount = amount;
        this.date = date;
    }
}
