<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Data Check</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            margin-top: 0;
            color: #333;
        }
        .employee-item {
            padding: 15px;
            border: 1px solid #ddd;
            margin-bottom: 10px;
            border-radius: 4px;
        }
        .employee-info {
            margin-bottom: 5px;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            color: #4CAF50;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Employee Data Check</h2>
        <c:forEach items="${employees}" var="employee">
            <div class="employee-item">
                <div class="employee-info">ID: ${employee.id}</div>
                <div class="employee-info">Employee ID: ${employee.employeeId}</div>
                <div class="employee-info">Name: ${employee.name}</div>
                <div class="employee-info">Role: ${employee.role}</div>
                <div class="employee-info">Password: ${employee.password}</div>
            </div>
        </c:forEach>
        <a href="/employee/login" class="back-link">Back to Login</a>
    </div>
</body>
</html> 