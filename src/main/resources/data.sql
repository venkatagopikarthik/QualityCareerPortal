CREATE TABLE IF NOT EXISTS employee_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id VARCHAR(255),
    customer_name VARCHAR(255),
    mobile_number VARCHAR(20),
    alternate_mobile VARCHAR(20),
    employment VARCHAR(255),
    language VARCHAR(255),
    has_credit_card VARCHAR(10),
    submission_date DATETIME
);
