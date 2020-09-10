package ee.bcs.valiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addaccount(String accountNr, Integer balance, Integer client_id) {
        String sql = "INSERT INTO accounts (account_nr,balance,client_id) VALUES (:accountNumber, :Balance, :Client_id)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("Balance", balance);
        paramMap.put("Client_id", client_id);
        jdbcTemplate.update(sql, paramMap);
    }

    public Integer balance(String accountNr) {
        String sql = "SELECT balance FROM accounts WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return result;
    }

    public void updateBalance(String accountNr,
                              Integer balance) {
        String sql = "UPDATE accounts SET balance = :Amount WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        paramMap.put("Amount", balance);
        jdbcTemplate.update(sql, paramMap);
        //http://localhost:8080/deposit?accountNr=EE123&amount=20
        //Kontroll PGAdminnis SELECT * FROM accounts;
    }

    public void addClient(String firstName, String lastName) {
        String sql = "INSERT INTO client (first_name, last_name) VALUES (:firstName, :lastName)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("firstName", firstName);
        paramMap.put("lastName", lastName);
        jdbcTemplate.update(sql, paramMap);
    }

    public void updateTransactions(Integer accountId, Integer amount) {
        String sql = "INSERT INTO transaction_history (amount, account_id) VALUES (:amount, :accountId)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("amount", amount);
        paramMap.put("accountId", accountId);
        jdbcTemplate.update(sql, paramMap);
    }

    public Integer getAccountId(String accountNr) {
        String sql = "SELECT id FROM accounts WHERE account_nr = :accountNumber";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountNumber", accountNr);
        Integer result = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return result;
    }

    public List<Transaction> getTransactionHistoryTable(Integer accountId) {
        String sql = "SELECT id, account_id,amount FROM transaction_history WHERE account_id = :accountId";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("accountId", accountId);
        return jdbcTemplate.query(sql, paramMap, new TransactionRowMapper());
    }
}
