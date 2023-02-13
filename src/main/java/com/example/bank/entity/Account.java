package com.example.bank.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private Integer balance;
    @Column
    private String type;
    @Column
    private String grade;

    public void deposit(Integer money) {
        if (money > 0) this.balance += money;
    }

    public void withdraw(Integer money) {
        if (balance >= money) {
            balance -= money;
        }
    }
}
