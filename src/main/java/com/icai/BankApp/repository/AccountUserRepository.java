package com.icai.BankApp.repository;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.AccountUser;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountUserRepository {

    @Query("SELECT user_id FROM ACCOUNT_USER WHERE ACCOUNT_USER.account_id = ?1 ")
    List<Long> getUserIdById(float id);

    @Query("SELECT account_id FROM ACCOUNT_USER WHERE ACCOUNT_USER.user_id = ?1 ")
    List<Long> getAccountIdById(float id);

    @Query("INSERT INTO ACCOUNT_USER (user_id, account_id) values (?1,?2)")
    AccountUser save(Long user_id, Long account_id);
}
