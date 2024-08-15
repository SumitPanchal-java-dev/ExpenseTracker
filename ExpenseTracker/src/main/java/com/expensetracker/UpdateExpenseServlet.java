package com.expensetracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet("/updateExpense")
public class UpdateExpenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Date date = Date.valueOf(request.getParameter("date"));
            String category = request.getParameter("category");
            BigDecimal amount = new BigDecimal(request.getParameter("amount"));
            String description = request.getParameter("description");

            Expense expense = new Expense(id, date, category, amount, description);

            try (Connection connection = DBConnection.getConnection()) {
                ExpenseDao dao = new ExpenseDao(connection);
                dao.updateExpense(expense);
            }

            response.sendRedirect("viewExpenses.jsp");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
