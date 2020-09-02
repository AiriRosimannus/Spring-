package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {
    private static final Map<String, BigDecimal> map = new HashMap<>();

    /*@Autowired
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

    @GetMapping ("account")  // createaccount http://localhost:8080/account?accountNr=abc&balance=44
    public void addaccount(@RequestParam String accountNr, @RequestParam() BigDecimal balance) {
        map.put(accountNr, balance);
    }

    @GetMapping("getBalance") // getBalance http://localhost:8080/getBalance?accountNr=abc
    public BigDecimal balance(@RequestParam String accountNr) {
        return map.get(accountNr);
    }
}
