package com.example.bank;

import com.example.bank.entity.Account;
import com.example.bank.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BankApplicationTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    void contextLoads() {
        Account acc = new Account("1000","hong",100000,"special","VIP");
        accountRepository.save(acc);
    }

}
