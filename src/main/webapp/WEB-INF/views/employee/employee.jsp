<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
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
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .btn {
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            text-decoration: none;
            display: inline-block;
        }
        .btn-primary {
            background-color: #4CAF50;
            color: white;
        }
        .btn-primary:hover {
            background-color: #45a049;
        }
        .btn-edit {
            background-color: #2196F3;
            color: white;
        }
        .btn-remove {
            background-color: #f44336;
            color: white;
        }
        .employee-list {
            margin-top: 20px;
        }
        .employee-item {
            padding: 10px 0;
            border-bottom: 1px solid #ddd;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .employee-info {
            flex-grow: 1;
        }
        .action-buttons {
            display: flex;
            gap: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Employee Management</h2>
        <form action="/employee/create" method="post">
            <div class="form-group">
                <label for="name">Employee Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="employeeId">Employee ID:</label>
                <input type="text" id="employeeId" name="employeeId" required>
            </div>
            <div class="form-group">
                <label for="password">Employee Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Employee</button>
        </form>

        <div class="employee-list">
            <c:forEach items="${employees}" var="employee">
                <div class="employee-item">
                    <div class="employee-info">
                        ${employee.name} (ID: ${employee.employeeId})
                    </div>
                    <div class="action-buttons">
                        <a href="/employee/edit/${employee.id}" class="btn btn-edit">Edit</a>
                        <a href="/employee/delete/${employee.id}" class="btn btn-remove">Remove</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>