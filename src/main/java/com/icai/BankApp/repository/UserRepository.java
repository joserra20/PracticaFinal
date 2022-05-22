package com.icai.BankApp.repository;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT * FROM USER WHERE USER.firstName = ?1 AND USER.lastName = ?2")
    User getUserByName(String first, String last);

    @Query("""
            SELECT U.*
                               FROM ACCOUNT_USER
                               INNER JOIN ACCOUNT A
                               ON ACCOUNT_USER.A_ID = A.ID
                               INNER JOIN USER U
                               ON ACCOUNT_USER.U_ID = U.ID
                               WHERE A.ID=:id;
                   """)
    List<User> usersByAcc(@Param("id") Long id);

    public User findByEmail(String email);

}
