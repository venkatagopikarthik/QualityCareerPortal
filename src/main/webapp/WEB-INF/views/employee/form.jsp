<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
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
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        
        input[type="tel"],
        select {
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
        <h2>Employee Details Form</h2>
        <form id="employeeForm">
       <div class="form-group">
    <label for="employeeId">Employee ID:</label>
    <input type="text" id="employeeId" name="employeeId" value="${employeeId}" readonly>
</div>

<!-- Hidden timestamp field -->
<input type="hidden" id="timestamp" name="timestamp">

            <div class="form-group">
                <label for="customerName">Customer Name:</label>
                <input type="text" id="customerName" name="customerName" required>
            </div>
            <div class="form-group">
                <label for="mobileNumber">Mobile Number:</label>
                <input type="tel" id="mobileNumber" name="mobileNumber" required>
            </div>
            <div class="form-group">
                <label for="alternateMobile">Alternate Mobile:</label>
                <input type="tel" id="alternateMobile" name="alternateMobile">
            </div>
            <div class="form-group">
                <label for="employment">Employment Type:</label>
                <select id="employment" name="employment" required>
                    <option value="">Select Employment Type</option>
                    <option value="Salaried">Salaried</option>
                    <option value="Self-Employed">Self-Employed</option>
                    <option value="Business">Business</option>
                </select>
            </div>
            <div class="form-group">
                <label for="language">Preferred Language:</label>
                <select id="language" name="language" required>
                    <option value="">Select Language</option>
                    <option value="English">English</option>
                    <option value="Hindi">Hindi</option>
                    <option value="Other">Other</option>
                </select>
            </div>
            <div class="form-group">
                <label for="hasCreditCard">Do you have a credit card?</label>
                <select id="hasCreditCard" name="hasCreditCard" required>
                    <option value="">Select Option</option>
                    <option value="Yes">Yes</option>
                    <option value="No">No</option>
                </select>
            </div>
            <button type="submit">Submit</button>
        </form>
        <a href="/employee/logout" class="back-link">Logout</a>
    </div>

    <script>
        document.getElementById('employeeForm').addEventListener('submit', function(e) {
            e.preventDefault();
            const now = new Date().toISOString(); // format: "2025-04-08T13:45:30.123Z"
            document.getElementById('timestamp').value = now;

            const formData = {
            		employeeId: document.getElementById('employeeId').value,
                customerName: document.getElementById('customerName').value,
                mobileNumber: document.getElementById('mobileNumber').value,
                alternateMobile: document.getElementById('alternateMobile').value,
                employment: document.getElementById('employment').value,
                language: document.getElementById('language').value,
                hasCreditCard: document.getElementById('hasCreditCard').value
            };

            fetch('/employee/submit', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            })
            .then(response => {
                if (response.ok) {
                    // After successful submission, redirect to the URL
                    window.location.href = 'https://extp.in/BJyIeR';
                } else {
                    throw new Error('Form submission failed');
                }
            })
            .catch(error => {
                alert('Error submitting form: ' + error.message);
            });
        });
    </script>
</body>
</html> 