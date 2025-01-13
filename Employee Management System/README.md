# Employee Management System

This is a console-based Employee Management System built using Java and JDBC to interact with an Oracle database. The program allows users to perform various CRUD (Create, Read, Update, Delete) operations on an `Employee70` table.

## Features

1. **Add Employee**: Insert a new employee record into the database.
2. **View All Employees**: Display all employee records.
3. **View Employee by ID**: Fetch and display the details of a specific employee by their ID.
4. **Update Employee by ID**: Update the salary and recalculate HRA, DA, and Total Salary for a specific employee.
5. **Delete Employee by ID**: Remove an employee record based on their ID.
6. **Exit**: Exit the application.

## Table Schema

The program works with the `Employee70` table, which has the following schema:

| Column Name     | Null?   | Data Type      | Description                                       |
|-----------------|---------|----------------|---------------------------------------------------|
| `EID`          | NOT NULL| NUMBER(4)      | Primary key. Unique 4-digit employee ID.          |
| `ENAME`        | NULLABLE| VARCHAR2(15)   | Employee name, up to 15 characters.               |
| `EDESIGNATION` | NULLABLE| VARCHAR2(15)   | Employee designation, up to 15 characters.        |
| `BASICSALARY`  | NULLABLE| NUMBER(8,2)    | Basic salary of the employee.                     |
| `HRA`          | NULLABLE| NUMBER(8,2)    | House Rent Allowance (96% of basic salary).       |
| `DA`           | NULLABLE| NUMBER(8,2)    | Dearness Allowance (61% of basic salary).         |
| `TOTALSALARY`  | NULLABLE| NUMBER(10,2)   | Total salary (Basic Salary + HRA + DA).           |

## Requirements

- Java Development Kit (JDK) 8 or above.
- Oracle Database.
- Oracle JDBC Driver.

## Setup Instructions

1. **Create the `Employee70` Table**:
   ```sql
   CREATE TABLE Employee70 (
       EID NUMBER(4) PRIMARY KEY,
       ENAME VARCHAR2(15),
       EDESIGNATION VARCHAR2(15),
       BASICSALARY NUMBER(8,2),
       HRA NUMBER(8,2),
       DA NUMBER(8,2),
       TOTALSALARY NUMBER(10,2)
   );
   ```

2. **Configure Database Connection**:
   - Update the `getConnection` method in the program with your Oracle database credentials:
     ```java
     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "your_username", "your_password");
     ```

3. **Compile and Run the Program**:
   - Compile the program:
     ```bash
     javac Employee.java
     ```
   - Run the program:
     ```bash
     java assignment3.employeeSalary.Employee
     ```

## How It Works

### Menu Options

1. **Add Employee**:
   - Prompts the user to enter employee details: ID, name, designation, and salary.
   - Automatically calculates `HRA`, `DA`, and `Total Salary`.
   - Inserts the record into the `Employee70` table.

2. **View All Employees**:
   - Fetches and displays all records from the `Employee70` table.

3. **View Employee by ID**:
   - Prompts the user to enter an employee ID.
   - Fetches and displays the record for the specified ID.

4. **Update Employee by ID**:
   - Prompts the user to enter an employee ID and new basic salary.
   - Updates the `BASICSALARY`, recalculates `HRA`, `DA`, and `Total Salary`, and updates the record in the table.

5. **Delete Employee by ID**:
   - Prompts the user to enter an employee ID.
   - Deletes the record for the specified ID.

6. **Exit**:
   - Exits the application.

## Error Handling

- **Database Connection Issues**:
  - Catches and handles `ClassNotFoundException` and `SQLException`.
- **Invalid Input**:
  - Handles exceptions for invalid data types or values entered by the user.
- **Basic Salary Validation**:
  - Ensures the basic salary is at least `12000` before inserting or updating records.

## Sample Output

```
---------------Welcome Employee Records---------------
1.Add Employee.
2.View All Employees.
3.View Employee By Id.
4.Update Employee By Id(bSal,hra,da,totSal).
5.Delete Employee By Id.
6.Exit.

Enter your choice: 1

---------------Inserting Employee Record---------------
Enter employee id: 1001
Enter employee name: John Doe
Enter employee designation: Manager
Enter employee Salary: 50000
Employee Record insert successfully
```

## Future Enhancements

- Add logging for better debugging.
- Implement more robust input validation.
- Provide an option to export employee records to a file.

## License

This program is provided as-is and is free to use and modify.

