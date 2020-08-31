package ee.bcs.valiit.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BankController {
    private static final Map<String, Integer> map = new HashMap<>();

    @PostMapping("account")
    public void addaccount(@RequestBody Account account) {
        map.put(account.getAccountNr(), account.getAmount());
    }

    @GetMapping("account/{accountNr}")
    public Integer getaccount(@PathVariable("accountNr") String account) {
        return map.get(account);
    }
}

