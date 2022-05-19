package com.icai.BankApp.repository;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

    @Query("SELECT * FROM ACCOUNT WHERE ACCOUNT.IBAN = ?1 ")
    Account getAccountByIban(String iban);
}
