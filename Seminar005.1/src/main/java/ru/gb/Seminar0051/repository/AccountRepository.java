package ru.gb.Seminar0051.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.Seminar0051.model.Account;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAccountByName(String name);
    @Modifying
    @Query("update account set amount = :amount where id = :id")
    void changeAmount(Long id, BigDecimal amount);
}
