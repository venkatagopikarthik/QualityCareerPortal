<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f4f4f4;
        }
        .container {
            text-align: center;
            background-color: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            margin-bottom: 30px;
        }
        .btn-container {
            display: flex;
            gap: 20px;
            justify-content: center;
        }
        .btn {
            padding: 12px 24px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            color: white;
            transition: background-color 0.3s;
        }
        .btn-admin {
            background-color: #2196F3;
        }
        .btn-admin:hover {
            background-color: #1976D2;
        }
        .btn-employee {
            background-color: #4CAF50;
        }
        .btn-employee:hover {
            background-color: #388E3C;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Employee Management System</h1>
        <div class="btn-container">
            <a href="/admin/login" class="btn btn-admin">Admin Login</a>
            <a href="/employee/login" class="btn btn-employee">Employee Login</a>
        </div>
    </div>
</body>
</html>