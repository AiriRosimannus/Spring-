package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServise {

    @Autowired
    private AccountRepository accountRepository;

    public void addaccount(String accountNr,
                           Integer balance,
                           Integer client_id) {
        accountRepository.addaccount(accountNr, balance, client_id);
    }

    public Integer balance(String accountNr) {
        Integer showbalance = accountRepository.balance(accountNr);
        return showbalance;
    }

    public void deposit(String accountNr,
                        Integer amount) {

        Integer accountBalance = accountRepository.balance(accountNr);
        Integer newBalance = accountBalance + amount;
        accountRepository.updateBalance(accountNr, newBalance);
        Integer accountId = accountRepository.getAccountId(accountNr);
        accountRepository.updateTransactions(accountId, amount);
    }

    public void withdraw(String accountNr,
                         Integer amount) {
        Integer accountBalance = accountRepository.balance(accountNr);
        if (accountBalance < amount) {
            System.out.println("Insufficient funds");
        } else {
            Integer newBalance = accountBalance - amount;
            accountRepository.updateBalance(accountNr, newBalance);
            Integer accountId = accountRepository.getAccountId(accountNr);
            accountRepository.updateTransactions(accountId, amount * (-1));
        }
    }

    public void transferMoney(String fromAccountNr,
                              String toAccountNr,
                              Integer amount) {
        Integer accountBalance = accountRepository.balance(fromAccountNr);

        if (accountBalance >= amount) {
            Integer newBalance = accountBalance - amount;
            accountRepository.updateBalance(fromAccountNr, newBalance);
        } else {
            System.out.println("Insufficient funds");
        }

        Integer accountBalance2 = accountRepository.balance(toAccountNr);
        Integer newBalance = accountBalance2 + amount;
        accountRepository.updateBalance(toAccountNr, newBalance);
        Integer fromAccountId = accountRepository.getAccountId(fromAccountNr);
        Integer toAccountId = accountRepository.getAccountId(toAccountNr);
        accountRepository.updateTransactions(fromAccountId, amount * (-1));
        accountRepository.updateTransactions(toAccountId, amount);

    }

    public void addClient(String firstName,
                          String lastName) {
        accountRepository.addClient(firstName, lastName);
    }

    public List<Transaction> getTransactionHistoryTable(Integer id, Integer accountId, Integer amount) {
        List<Transaction> getTransactionHistoryTable= accountRepository.getTransactionHistoryTable(id, accountId, amount);
        return getTransactionHistoryTable;
    }
}
