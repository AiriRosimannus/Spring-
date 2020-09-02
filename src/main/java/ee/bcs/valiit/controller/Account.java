package ee.bcs.valiit.controller;

import java.math.BigDecimal;

public class Account {

    private String accountNr;
    private BigDecimal balance;

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}


