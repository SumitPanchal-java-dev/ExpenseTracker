<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>View Expenses</title>
</head>
<body>
    <h1>View Expenses</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Category</th>
                <th>Amount</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="expense" items="${expenses}">
                <tr>
                    <td>${expense.id}</td>
                    <td>${expense.date}</td>
                    <td>${expense.category}</td>
                    <td>${expense.amount}</td>
                    <td>${expense.description}</td>
                    <td>
                        <a href="updateexpense.jsp?id=${expense.id}">Edit</a>
                        <a href="deleteExpense?id=${expense.id}" onclick="return confirm('Are you sure?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
