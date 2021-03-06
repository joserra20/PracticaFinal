package com.icai.BankApp.repository;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.AccountUser;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountUserRepository extends CrudRepository<AccountUser, Long>{

    @Query("SELECT U_ID FROM ACCOUNT_USER WHERE ACCOUNT_USER.A_ID = 1 ")
    List<Long > getUserIdById(float id);

    @Query("SELECT A_ID FROM ACCOUNT_USER WHERE ACCOUNT_USER.U_ID = 1 ")
    List<Long> getAccountIdById(float id);

}
