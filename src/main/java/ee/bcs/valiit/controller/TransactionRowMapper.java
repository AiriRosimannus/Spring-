package ee.bcs.valiit.controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(resultSet.getInt("id"));
        transaction.setAccountId(resultSet.getInt("account_id"));
        transaction.setAmount(resultSet.getInt("amount"));
        return transaction;
    }
}
