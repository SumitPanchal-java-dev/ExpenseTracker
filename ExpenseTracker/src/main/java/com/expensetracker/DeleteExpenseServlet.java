package com.expensetracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            try (Connection connection = DBConnection.getConnection()) {
                ExpenseDao dao = new ExpenseDao(connection);
                dao.deleteExpense(id);
            }

            response.sendRedirect("viewExpenses.jsp");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
