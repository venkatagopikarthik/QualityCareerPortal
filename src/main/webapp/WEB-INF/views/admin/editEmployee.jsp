<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
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
        .btn-back {
            background-color: #2196F3;
            color: white;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Edit Employee</h2>
        <form action="/admin/employee/update/${employee.id}" method="post">
            <div class="form-group">
                <label for="name">Employee Name:</label>
                <input type="text" id="name" name="name" value="${employee.name}" required>
            </div>
            <div class="form-group">
                <label for="employeeId">Employee ID:</label>
                <input type="text" id="employeeId" name="employeeId" value="${employee.employeeId}" required>
            </div>
            <div class="form-group">
                <label for="password">Employee Password:</label>
                <input type="password" id="password" name="password" placeholder="Leave blank to keep current password">
            </div>
            <a href="/admin/addemployee" class="btn btn-back">Back</a>
            <button type="submit" class="btn btn-primary">Update Employee</button>
        </form>
    </div>
</body>
</html> 