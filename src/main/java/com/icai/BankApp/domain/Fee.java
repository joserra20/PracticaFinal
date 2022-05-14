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
@Table("FEE")
public class Fee {
    private @Column("id") @Id Long id;

    private @Column("USER_TYPE") UserType userType;

    private @Column("IBAN") String fee_amount;
}
