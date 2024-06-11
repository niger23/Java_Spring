package com.example;

import com.example.exceptions.AccountNotFoundException;
import com.example.model.Account;
import com.example.repositories.AccountRepository;
import com.example.services.TransferService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TransferServiceModelTest {
    @InjectMocks
    private TransferService transferService;
    @Mock
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

        given(accountRepository.findById(1L)).willReturn(Optional.of(sender));
        given(accountRepository.findById(2L)).willReturn(Optional.of(receiver));
//        --- блок действия
        transferService.transferMoney(1,2, new BigDecimal(500));

//        --- блок проверки
        verify(accountRepository).changeAmount(1L, new BigDecimal(500));
        verify(accountRepository).changeAmount(2L, new BigDecimal(1500));
    }
    @Test
    public void moneyTransferAccountNotFoundTest() {
//        --- блок предусловий
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        given(accountRepository.findById(1L)).willReturn(Optional.of(sender));
        given(accountRepository.findById(2L)).willReturn(Optional.empty());
//        --- блок действия
        assertThrows(AccountNotFoundException.class, () -> {
            transferService.transferMoney(1,2, new BigDecimal(500));
        });
//        --- блок проверки
        verify(accountRepository, never()).changeAmount(anyLong(), any());
    }
}
