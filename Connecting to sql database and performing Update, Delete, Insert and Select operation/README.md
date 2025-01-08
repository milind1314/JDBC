# JDBC Employee Management Program

This program demonstrates various JDBC operations such as inserting, updating, deleting, and querying records from an Oracle database. It uses a switch-case menu to allow users to perform different operations on the `EMPLOYEE_INFO` table.

---

## Table Structure: EMPLOYEE_INFO

The program interacts with the following database table:

| Column Name | Data Type         | Description                |
|-------------|-------------------|----------------------------|
| EMPID       | NUMBER(4)         | Employee ID (Primary Key)  |
| EMPNAME     | VARCHAR2(15)      | Name of the Employee       |
| EMPSALARY   | NUMBER(8,2)       | Salary of the Employee     |
| EMPADDRESS  | VARCHAR2(25)      | Address of the Employee    |
| EMPMAILID   | VARCHAR2(20)      | Email ID of the Employee   |
| EMPPHNO     | NUMBER(10)        | Phone Number of the Employee |

---

## Functionalities

### 1. Insert Employee Record
Allows the user to insert a new employee record into the database.

### 2. Update Employee Record
Updates the salary, email ID, and phone number of an employee identified by their `EMPID`.

### 3. Find Employees by Name Prefix
Finds employees whose names start with a specific character (case-insensitive).

### 4. Count Employee Records
Counts the total number of records in the `EMPLOYEE_INFO` table.

### 5. Delete Employee with Maximum Salary
Deletes the record of the employee who has the highest salary.

### 6. Display All Employee Records
Displays all records in the `EMPLOYEE_INFO` table.

---

## Program Flow
1. **Database Connection**: 
   - Connects to an Oracle database using `oracle.jdbc.driver.OracleDriver`.

2. **Menu-Driven Options**:
   - The user selects an operation from the displayed menu.
   - The corresponding SQL query or update is executed.

3. **Error Handling**:
   - Ensures proper handling of SQL exceptions and invalid inputs.

---

## Prerequisites

1. **Oracle Database**:
   - Ensure Oracle database is installed and running.

2. **JDBC Driver**:
   - Add the Oracle JDBC driver (`ojdbc8.jar`) to your classpath.

3. **Table Creation**:
   ```sql
   CREATE TABLE EMPLOYEE_INFO (
       EMPID NUMBER(4) PRIMARY KEY,
       EMPNAME VARCHAR2(15),
       EMPSALARY NUMBER(8,2),
       EMPADDRESS VARCHAR2(25),
       EMPMAILID VARCHAR2(20),
       EMPPHNO NUMBER(10)
   );
   ```

4. **Sample Data**:
   ```sql
   INSERT INTO EMPLOYEE_INFO VALUES (1001, 'MAHESH', 45000, 'BULDHANA', 'MAHESH@GMAIL.COM', 9595951234);
   INSERT INTO EMPLOYEE_INFO VALUES (1002, 'NILESH', 40000, 'PUNE', 'NILESH@GMAIL.COM', 7878781234);
   INSERT INTO EMPLOYEE_INFO VALUES (1003, 'PRANAY', 50000, 'BHANDARA', 'PRANAY@GMAIL.COM', 7474741234);
   INSERT INTO EMPLOYEE_INFO VALUES (1004, 'OM', 52000, 'NAGPUR', 'OM@GMAIL.COM', 8988961234);
   ```

---

## How to Run

1. Compile the program:
   ```bash
   javac First_adv.java
   ```

2. Run the program:
   ```bash
   java adv_lab_jan08.First_adv
   ```

3. Follow the menu prompts to perform operations.

---

## Example Execution

```
----------Employee Records-----------
1001    MAHESH  45000.0   BULDHANA    MAHESH@GMAIL.COM  9595951234
1002    NILESH  40000.0   PUNE        NILESH@GMAIL.COM  7878781234
1003    PRANAY  50000.0   BHANDARA    PRANAY@GMAIL.COM  7474741234
1004    OM      52000.0   NAGPUR      OM@GMAIL.COM      8988961234

----------Operation Choice-----------
1.Display Employee Record
2.Update Employee Record
3.Find Employee by Name Prefix
4.Count Employee Records
5.Delete Employee with Maximum Salary
6.Show All Employees
Enter your choice: 
```

---

## Notes
- The program ensures case-insensitivity while searching by name prefix.
- The deletion of the employee with the maximum salary assumes only one employee holds the highest salary.
- Ensure proper database configurations (username, password, and URL) before running the program.
