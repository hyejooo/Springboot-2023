package com.example.bank.service;

import com.example.bank.entity.Account;
import com.example.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

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
}