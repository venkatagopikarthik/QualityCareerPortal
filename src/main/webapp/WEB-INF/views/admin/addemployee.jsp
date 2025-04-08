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
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
            font-size: 16px;
        }
        input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }
        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .employee-list {
            margin-top: 30px;
            border-top: 1px solid #ddd;
            padding-top: 20px;
        }
        .employee-item {
            padding: 10px 0;
            border-bottom: 1px solid #ddd;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .action-buttons {
            display: flex;
            gap: 10px;
        }
        .btn-edit {
            background-color: #2196F3;
        }
        .btn-remove {
            background-color: #f44336;
        }
        .error {
            color: red;
            margin-top: 10px;
        }
        .success {
            color: green;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Employee Management</h2>
        
        <form action="/admin/employee/add" method="post">
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
            <button type="submit" class="btn">Add Employee</button>
        </form>

        <div class="employee-list">
            <c:forEach items="${employees}" var="employee">
                <div class="employee-item">
                    <div class="employee-info">
                        ${employee.name} (ID: ${employee.employeeId})
                    </div>
                    <div class="action-buttons">
                        <a href="/admin/employee/edit/${employee.id}" class="btn btn-edit">Edit</a>
                        <a href="/admin/employee/delete/${employee.id}" class="btn btn-remove">Remove</a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty success}">
            <div class="success">${success}</div>
        </c:if>
    </div>
  

<h3>Submitted Forms by Employees</h3>
<table border="1" id="employeeTable" data-sort="asc">

  <tr>
    <th onclick="sortTable()">Employee ID &#x25B2;&#x25BC;</th>

    <th>Name</th>
    <th>Mobile</th>
    <th>Employment</th>
    <th>Language</th>
    <th>Credit Card</th>
    <th>Submitted At</th>
    
  </tr>
  <c:forEach var="form" items="${submissions}">
    <tr>
      <td>${form.employeeId}</td>
      <td>${form.customerName}</td>
      <td>${form.mobileNumber}</td>
      <td>${form.employment}</td>
      <td>${form.language}</td>
      <td>${form.hasCreditCard}</td>
      <td>${form.submissionDate}</td>
      
    </tr>
  </c:forEach>
</table>


    <script>
    
    function sortTable() {
        const table = document.getElementById("employeeTable");
        const rows = Array.from(table.rows).slice(1); // Exclude header
        const currentAsc = table.getAttribute("data-sort") !== "desc";
        table.setAttribute("data-sort", currentAsc ? "desc" : "asc");

        rows.sort((a, b) => {
            const valA = parseInt(a.cells[0].innerText);
            const valB = parseInt(b.cells[0].innerText);
            return currentAsc ? valA - valB : valB - valA;
        });

        rows.forEach(row => table.appendChild(row));
    }
   

        // Clear form after successful submission
        <c:if test="${not empty success}">
            document.getElementById('name').value = '';
            document.getElementById('employeeId').value = '';
            document.getElementById('password').value = '';
        </c:if>
    </script>
</body>
</html>