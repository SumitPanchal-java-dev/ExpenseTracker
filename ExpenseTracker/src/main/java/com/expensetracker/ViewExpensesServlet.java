package com.expensetracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewExpenses")
public class ViewExpensesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            try (Connection connection = DBConnection.getConnection()) {
                ExpenseDao dao = new ExpenseDao(connection);
                List<Expense> expenses = dao.getAllExpenses();
                request.setAttribute("expenses", expenses);
                request.getRequestDispatcher("viewExpenses.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
