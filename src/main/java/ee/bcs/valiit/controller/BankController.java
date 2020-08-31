package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {
    private static final Map<String, Account> map = new HashMap<>();

    @PostMapping("account")
    public void addaccount(@RequestBody Account account) {
        account.put(account.getAccountNr(), account.getAmount());
    }

    @GetMapping("account/{accountNr}")
    public Account getaccount(@PathVariable("accountNr") String account) {
        return map.get(account);
    }
}

