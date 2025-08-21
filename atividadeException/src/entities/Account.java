package entities;

import exceptions.DomainException;

import javax.security.auth.login.AccountException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance = 0.0;
    private Double withdrawLimit;

    public Account(){}

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        deposit(balance);
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
    public  void deposit(Double balance) {

        this.balance += balance;
    }
    public  void withdraw(Double amount) throws DomainException {
       if(amount > withdrawLimit) {
            throw new DomainException("Amount to withdraw exceed limit");
        }
        else if(amount > this.balance) {
            throw new DomainException("Not enough balance");
        }else if(amount <= withdrawLimit && amount <= balance) {
           this.balance -= amount;
       }



           System.out.println("Withdrawal successful: " +  balance);

    }



}
