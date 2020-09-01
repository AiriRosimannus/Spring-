package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {
    private static final Map<String, Integer> map = new HashMap<>();

    @PostMapping("account")
    public void addaccount(@RequestBody Account account) {
        map.put(account.getAccountNr(), account.getAmount());
    }

  /*  @PutMapping("account/{amount}")
    public void updateAmount(@PathVariable("amount") int amount, @RequestBody Account account) {
        map.set(amount, map);

    }*/

    @GetMapping("account/{accountNr}")
    public Integer getaccount(@PathVariable("accountNr") String account) {
        return map.get(account);
    }
}

