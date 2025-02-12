package com.bankmanagementsystem.accounting.repositories;

import com.bankmanagementsystem.accounting.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
}
