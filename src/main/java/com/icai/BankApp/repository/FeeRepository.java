package com.icai.BankApp.repository;

import com.icai.BankApp.domain.AccountUser;
import com.icai.BankApp.domain.Fee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository  extends CrudRepository<Fee, Long> {
}
