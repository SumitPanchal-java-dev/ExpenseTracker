<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Expense</title>
</head>
<body>
    <h1>Add New Expense</h1>
    <form action="addExpense" method="post">
        <label>Date:</label>
        <input type="date" name="date" required><br>
        <label>Category:</label>
        <input type="text" name="category" required><br>
        <label>Amount:</label>
        <input type="number" step="0.01" name="amount" required><br>
        <label>Description:</label>
        <textarea name="description"></textarea><br>
        <input type="submit" value="Add Expense">
    </form>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
