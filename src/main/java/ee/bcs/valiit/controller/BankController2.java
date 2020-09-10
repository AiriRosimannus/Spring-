package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankController2 {

    @Autowired
    private AccountServise accountServise;
    // private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("account")  // createaccount http://localhost:8080/account?accountNr=EE258&balance=88&client_id=6
    // Kontroll PGAdminnis: SELECT * FROM accounts;
    public void addaccount(@RequestParam String accountNr,
                           @RequestParam Integer balance,
                           @RequestParam Integer client_id) {
        accountServise.addaccount(accountNr, balance, client_id);
    }

    @GetMapping("getBalance")       // http://localhost:8080/getBalance?accountNr=EE123 võrdub
    // PGAdminnis: SELECT balance FROM accounts WHERE account_nr='EE123';
    public Integer balance(@RequestParam String accountNr) {
        Integer getBalance = accountServise.balance(accountNr);
        return getBalance;
    }

    //(suurendab kontoga seotud raha muutujat)
    @GetMapping("deposit")
    public void deposit(@RequestParam String accountNr,
                        @RequestParam Integer amount) {
        accountServise.deposit(accountNr, amount);

        //http://localhost:8080/deposit?accountNr=EE123&amount=20
        //Kontroll PGAdminnis SELECT * FROM accounts;
    }

    @GetMapping("withdraw")
    public void withdraw(@RequestParam String accountNr,
                         @RequestParam Integer amount) {
        accountServise.withdraw(accountNr, amount);

        //http://localhost:8080/withdraw?accountNr=EE123&amount=20
        //Kontroll PGAdminnis SELECT * FROM accounts;
    }

    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam String fromAccountNr,
                              @RequestParam String toAccountNr,
                              @RequestParam Integer amount) {
        accountServise.transferMoney(fromAccountNr, toAccountNr, amount);

        //http://localhost:8080/transferMoney?fromAccountNr=EE123&toAccountNr=EE258&amount=30
    }

    @GetMapping("addClient")
    public void addClient(@RequestParam String firstName,
                          @RequestParam String lastName) {
        accountServise.addClient(firstName, lastName);
    }
}
