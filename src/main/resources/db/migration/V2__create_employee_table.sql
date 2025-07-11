CREATE TABLE employee (
                          employee_id INT PRIMARY KEY AUTO_INCREMENT,
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          job_title VARCHAR(255) NOT NULL,
                          department_id INT,
                          manager_id INT,
                          CONSTRAINT fk_department FOREIGN KEY (department_id) REFERENCES department(department_id),
                          CONSTRAINT fk_manager FOREIGN KEY (manager_id) REFERENCES employee(employee_id)
);