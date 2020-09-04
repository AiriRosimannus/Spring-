package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController2 {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("account")  // createaccount http://localhost:8080/account?accountNr=EE258&balance=88&client_id=6
    // Kontroll PGAdminnis: SELECT * FROM accounts;
    public void addaccount(@RequestParam String accountNr, @RequestParam Integer balance, @RequestParam Integer client_id) {
        String sql = "INSERT INTO accounts (account_nr,balance,client_id) VALUES (:accountNumber, :Balance, :Client_id)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("Balance", balance);
        paramMap.put("Client_id", client_id);
        jdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("getBalance")       // http://localhost:8080/getBalance?accountNr=EE123 võrdub
    // PGAdminnis: SELECT balance FROM accounts WHERE account_nr='EE123';
    public Integer balance(@RequestParam String accountNr) {
        String sql = "SELECT balance FROM accounts WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        return result;
    }

    //(suurendab kontoga seotud raha muutujat)
    @GetMapping("deposit")
    public void deposit(@RequestParam String accountNr,
                        @RequestParam Integer amount) {

        String sql = "SELECT balance FROM accounts WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        result = result + amount;

        // kirjutab üle! PGAdminn :UPDATE accounts SET balance ='100' WHERE account_nr ='EE123';

        sql = "UPDATE accounts SET balance = :Amount WHERE account_nr = :accountNumber";
        paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("Amount", result);
        jdbcTemplate.update(sql, paramMap);

        //http://localhost:8080/deposit?accountNr=EE123&amount=20
        //Kontroll PGAdminnis SELECT * FROM accounts;
    }

    @GetMapping("withdraw")
    public void withdraw(@RequestParam String accountNr,
                         @RequestParam Integer amount) {
        String sql = "SELECT balance FROM accounts WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        if (result < amount) {
            System.out.println("Insufficient funds");
        } else {
            result = result - amount;
        }
        sql = "UPDATE accounts SET balance = :Amount WHERE account_nr = :accountNumber";
        paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("Amount", result);
        jdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam String fromAccountNr,
                              @RequestParam String toAccountNr,
                              @RequestParam Integer amount) {
        String sql = "SELECT balance FROM accounts WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", fromAccountNr);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        if (result >= amount) {
            result = result - amount;
        } else {
            System.out.println("Insufficient funds");
        }

        sql = "UPDATE accounts SET balance = :Balance WHERE account_nr = :accountNumber";
        paramMap = new HashMap();
        paramMap.put("accountNumber", fromAccountNr);
        paramMap.put("Balance", result);
        jdbcTemplate.update(sql, paramMap);

        sql = "SELECT balance FROM accounts WHERE account_nr = :accountNumber";
        paramMap = new HashMap();
        paramMap.put("accountNumber", toAccountNr);
        Integer result2 = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

        result2 = result2 + amount;

        sql = "UPDATE accounts SET balance = :Balance WHERE account_nr = :accountNumber";
        paramMap = new HashMap();
        paramMap.put("accountNumber", toAccountNr);
        paramMap.put("Balance", result2);
        jdbcTemplate.update(sql, paramMap);
    }
}
