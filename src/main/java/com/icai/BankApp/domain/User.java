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
@Table("USER")
public class User {
    private @Column("id") @Id Long id;

    private @Column("firstName") String firstName;

    private @Column("lastName") String lastName;

    private @Column("password") String password;

    private @Column("EMAIL") String email;

    private @Column("USER_TYPE") UserType userType;

    public User(String firstName, String lastName, String password, String email, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }
}
