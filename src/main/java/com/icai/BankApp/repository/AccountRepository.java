package com.icai.BankApp.repository;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

    @Query("SELECT * FROM ACCOUNT WHERE ACCOUNT.IBAN = ?1 ")
    Account getAccountByIban(String iban);


    @Query("""
                     SELECT A.*
                    FROM ACCOUNT_USER
                    INNER JOIN ACCOUNT A
                    ON ACCOUNT_USER.a_id = A.ID
                    INNER JOIN USER U
                    ON ACCOUNT_USER.u_id = U.ID
                    WHERE U.ID=:id
                    """)
    List<Account> myQuery(@Param("id") Long id);
}
