# ExpenseTracker

# Expense Tracker

## Overview

The Expense Tracker is a simple web application that allows users to manage their daily expenses. Users can add, view, update, and delete expense records. This project is built using Java Servlets, JSP, and MySQL, making it an excellent example of a CRUD (Create, Read, Update, Delete) application.

## Features

- **Add Expense**: Users can add a new expense by entering details such as date, category, amount, and a brief description.
- **View Expenses**: All recorded expenses are displayed in a tabular format, with options to filter or sort the data.
- **Update Expense**: Users can modify the details of an existing expense.
- **Delete Expense**: Users can delete any unwanted or incorrect expense records.

## Technology Stack

- **Frontend**: HTML, CSS, JSP
- **Backend**: Java Servlets
- **Database**: MySQL
- **Server**: Apache Tomcat
    
    
    Database : 
    
    CREATE DATABASE ExpenseTracker;
USE ExpenseTracker;

CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE NOT NULL,
    category VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    description TEXT
);
    
