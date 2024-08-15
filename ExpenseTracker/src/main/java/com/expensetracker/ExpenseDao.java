package com.expensetracker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {
    private Connection connection;

    public ExpenseDao(Connection connection) {
        this.connection = connection;
    }

    public void addExpense(Expense expense) throws SQLException {
        String sql = "INSERT INTO expenses (date, category, amount, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, expense.getDate());
            statement.setString(2, expense.getCategory());
            statement.setBigDecimal(3, expense.getAmount());
            statement.setString(4, expense.getDescription());
            statement.executeUpdate();
        }
    }

    public List<Expense> getAllExpenses() throws SQLException {
        List<Expense> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Expense expense = new Expense(
                        resultSet.getInt("id"),
                        resultSet.getDate("date"),
                        resultSet.getString("category"),
                        resultSet.getBigDecimal("amount"),
                        resultSet.getString("description")
                );
                expenses.add(expense);
            }
        }
        return expenses;
    }

    public Expense getExpenseById(int id) throws SQLException {
        Expense expense = null;
        String sql = "SELECT * FROM expenses WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    expense = new Expense(
                            resultSet.getInt("id"),
                            resultSet.getDate("date"),
                            resultSet.getString("category"),
                            resultSet.getBigDecimal("amount"),
                            resultSet.getString("description")
                    );
                }
            }
        }
        return expense;
    }

    public void updateExpense(Expense expense) throws SQLException {
        String sql = "UPDATE expenses SET date = ?, category = ?, amount = ?, description = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, expense.getDate());
            statement.setString(2, expense.getCategory());
            statement.setBigDecimal(3, expense.getAmount());
            statement.setString(4, expense.getDescription());
            statement.setInt(5, expense.getId());
            statement.executeUpdate();
        }
    }

    public void deleteExpense(int id) throws SQLException {
        String sql = "DELETE FROM expenses WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
