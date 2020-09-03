package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@RestController
public class BankController {
    private static final Map<String, Integer> map = new HashMap<>();
/*
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping("sqltest")
    public String testSql() {
        String sql = "SELECT account_nr FROM accounts where id = :id";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("id", 1);
        String vastus = jdbcTemplate.queryForObject(sql, paramMap, String.class);

        sql = "UPDATE accounts SET balance = :balance where id = :id";
        paramMap = new HashMap<>();
        paramMap.put("balance", 100);
        paramMap.put("id", 1);
        jdbcTemplate.update(sql, paramMap);

        sql = "SELECT balance FROM accounts where id = :id";
        paramMap = new HashMap<>();
        paramMap.put("id", 1);
        String vastus2 = jdbcTemplate.queryForObject(sql, paramMap, String.class);

        return vastus2;


    }*/

    public BankController() {
    }

    @GetMapping("account")  // createaccount http://localhost:8080/account?accountNr=abc&balance=44
    public void addaccount(@RequestParam String accountNr, @RequestParam() Integer balance) {
        map.put(accountNr, balance);
    }

    @GetMapping("getBalance") // getBalance http://localhost:8080/getBalance?accountNr=abc
    public Integer balance(@RequestParam String accountNr) {
        return map.get(accountNr);
    }

    //depositMoney(String accountNr, amount) | kannab loodud kontole raha
    //(suurendab kontoga seotud raha muutujat)
    @GetMapping("deposit")
    public void deposit(@RequestParam String accountNr,
                        @RequestParam Integer amount) {

        Integer balance = map.get(accountNr);
        balance = balance + amount;
        System.out.println("Ülekanne tehtud");
        map.put(accountNr, balance);

        //   map.equals(balance = balance + amount);

    }

    //withdrawMoney(String accountNr, amount) | võtab kontolt raha (vähendab
    //kontol olevat rahasummat)

    @GetMapping("withdraw")
    public void withdraw(@RequestParam String accountNr,
                         @RequestParam Integer amount) {
        Integer balance = map.get(accountNr);
        if (balance < amount) {
            System.out.println("Arvel pole piisavalt vahendeid/ Insufficient funds");
        } else {
            balance = balance - amount;
        }
        map.put(accountNr, balance);
    }

    //transferMoney(String account1, String account2, amount) | kanna raha
    //esimeselt kontolt teisele kontole

    @GetMapping("transferMoney")
    public void transferMoney(@RequestParam String fromAccountNr,
                              @RequestParam String toAccountNr,
                              @RequestParam Integer amount) {
        Integer fromBalance = map.get(fromAccountNr);
        Integer toBalance = map.get(toAccountNr);
        if (fromBalance >= amount) {
            fromBalance = fromBalance - amount;
            toBalance = toBalance + amount;
            System.out.println("Funds successfully transfered.");
        } else {
            System.out.println("Insufficient funds");
        }
        map.put(fromAccountNr, fromBalance);
        map.put(toAccountNr, toBalance);
    }
}
