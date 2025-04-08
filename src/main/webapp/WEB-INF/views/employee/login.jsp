<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 300px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
            margin-bottom: 10px;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #4CAF50;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
        .forgot-password {
            text-align: center;
            margin-top: 10px;
        }
        .forgot-password a {
            color: #2196F3;
            text-decoration: none;
        }
        .forgot-password a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Employee Login</h2>
        <c:if test="${param.error != null}">
            <div class="error">Invalid login credentials</div>
        </c:if>
        <form action="/employee/process-login" method="post">
            <div class="form-group">
                <label for="employeeId">Employee ID:</label>
                <input type="text" id="employeeId" name="employeeId" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Login</button>
        </form>
        <div class="forgot-password">
            <a href="https://wa.me/917382752900?text=I%20forgot%20my%20employee%20password.%20Please%20help%20me%20reset%20it." target="_blank">Forgot Password?</a>
        </div>
        <a href="/" class="back-link">Back to Home</a>
    </div>
</body>
</html> 