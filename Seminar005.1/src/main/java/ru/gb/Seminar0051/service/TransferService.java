package ru.gb.Seminar0051.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.Seminar0051.exception.AccountNotFoundException;
import ru.gb.Seminar0051.model.Account;
import ru.gb.Seminar0051.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class TransferService {
    private final AccountRepository accountRepository;

    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findById(idSender)
                .orElseThrow(() -> new AccountNotFoundException());

        Account receiver = accountRepository.findById(idReceiver)
                .orElseThrow(() -> new AccountNotFoundException());

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    public List<Account> findAccountByName(String name) {
        return accountRepository.findAccountByName(name);
    }
}
