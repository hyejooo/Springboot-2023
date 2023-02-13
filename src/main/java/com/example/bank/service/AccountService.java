package com.example.bank.service;

import com.example.bank.entity.Account;
import com.example.bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
//    private final AccountRepository accountRepository;

    public void makeAccount(Account acc) throws Exception {
        Optional<Account> oacc = accountRepository.findById(acc.getId());
        if (oacc.isEmpty()) {
            accountRepository.save(acc);
        } else {
            throw new Exception("계좌번호 중복");
        }
    }
    public Account accountInfo(String id) throws Exception {
        Optional<Account> oacc = accountRepository.findById(id);
        if (oacc.isEmpty()) {
            throw new Exception("계좌번호 오류");
        }
        return oacc.get();
    }
    public Account deposit(String id, Integer money) throws Exception {
        Optional<Account> oacc = accountRepository.findById(id);
        if (oacc.isEmpty()) throw new Exception("계좌번호 오류");
        Account acc = oacc.get();
        acc.deposit(money); // Account Entity에 있는 deposit
        accountRepository.save(acc);
        return acc;
    }

    public Account withdraw(String id, Integer money) throws Exception {
        Optional<Account> oacc = accountRepository.findById(id);
        if (oacc.isEmpty()) throw new Exception("계좌번호 오류");
        Account acc = oacc.get();
        acc.withdraw(money); // Account Entity에 있는 deposit
        accountRepository.save(acc);
        return acc;
    }

    public List<Account> accountList() throws Exception {
        return accountRepository.findAll();
    }
}