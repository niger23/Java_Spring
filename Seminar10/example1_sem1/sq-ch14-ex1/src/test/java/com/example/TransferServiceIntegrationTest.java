package com.example;

import com.example.model.Account;
import com.example.repositories.AccountRepository;
import com.example.services.TransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferServiceIntegrationTest {
    @Autowired
    private TransferService transferService;
    @MockBean
    private AccountRepository accountRepository;
    @Test
    public void moneyTransferCorrectFlow() {
//        --- блок предусловий
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));
//        --- блок действия
        transferService.transferMoney(1,2, new BigDecimal(500));

//        --- блок проверки
        verify(accountRepository).changeAmount(1L, new BigDecimal(500));
        verify(accountRepository).changeAmount(2L, new BigDecimal(1500));
    }
}
