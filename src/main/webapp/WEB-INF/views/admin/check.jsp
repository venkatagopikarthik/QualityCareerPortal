<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Data Check</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 0;
        }
        .admin-item {
            border: 1px solid #ddd;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #f9f9f9;
        }
        .admin-info {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
    <h2>Admin Data Check</h2>
    <c:forEach items="${admins}" var="admin">
        <div class="admin-item">
            <div class="admin-info">ID: ${admin.id}</div>
            <div class="admin-info">Admin ID: ${admin.adminId}</div>
            <div class="admin-info">Name: ${admin.name}</div>
            
            <div class="admin-info">Role: ${admin.role}</div>
            <div class="admin-info">Password: ${admin.password}</div>
        </div>
    </c:forEach>
    <a href="/admin/login">Back to Login</a>
</body>
</html> 