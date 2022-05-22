package com.icai.BankApp.repository;

import com.icai.BankApp.domain.Account;
import com.icai.BankApp.domain.Transaction;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query("""
                     SELECT *
                    FROM TRANSACTION
                    WHERE TRANSACTION.ORIGIN_ACC=:id
                    OR TRANSACTION.DESTINATION_ACC=:id
                    """)
    List<Transaction> getTransactionByAccount(@Param("id") Long id);


    @Query("""
                     SELECT *
                    FROM TRANSACTION
                    WHERE TRANSACTION.DATE=:date
                    """)
    List<Transaction> getTransactionByDate(@Param("date") LocalDate date);
}
