<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Expense</title>
</head>
<body>
    <h1>Update Expense</h1>
    <form action="updateExpense" method="post">
        <input type="hidden" name="id" value="${expense.id}">
        <label>Date:</label>
        <input type="date" name="date" value="${expense.date}" required><br>
        <label>Category:</label>
        <input type="text" name="category" value="${expense.category}" required><br>
        <label>Amount:</label>
        <input type="number" step="0.01" name="amount" value="${expense.amount}" required><br>
        <label>Description:</label>
        <textarea name="description">${expense.description}</textarea><br>
        <input type="submit" value="Update Expense">
    </form>
    <a href="viewExpenses.jsp">Back to View Expenses</a>
</body>
</html>
