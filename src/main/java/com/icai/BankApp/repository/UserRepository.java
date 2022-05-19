package com.icai.BankApp.repository;

import com.icai.BankApp.domain.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT * FROM USER WHERE USER.firstName = ?1 AND USER.lastName = ?2")
    User getUserByName(String first, String last);
}
