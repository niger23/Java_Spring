package ru.gb.Seminar0051.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.Seminar0051.dto.TransferRequest;
import ru.gb.Seminar0051.model.Account;
import ru.gb.Seminar0051.service.TransferService;

@RestController
@AllArgsConstructor
public class AccountController {
    private final TransferService transferService;


    @GetMapping("/accounts")
    public Iterable<Account> getAccount(@RequestParam(required = false) String name) {
        if(name == null) return transferService.getAllAccounts();
        else return transferService.findAccountByName(name);
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest) {
        transferService.transferMoney(transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(), transferRequest.getAmount());

    }

}
