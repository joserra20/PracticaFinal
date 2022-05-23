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
    private @Column("ID") @Id Long id;

    private @Column("DNI") String dni;

    private @Column("FIRSTNAME") String firstName;

    private @Column("LASTNAME") String lastName;

    private @Column("PASSWORD") String password;

    private @Column("EMAIL") String email;

    private @Column("USER_TYPE") String userType;

    public User(String dni,String firstName, String lastName, String password, String email, String userType) {
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }


}
