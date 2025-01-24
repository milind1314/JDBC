# Student Details Management System

## Overview
This project is a Java-based application that captures and stores student details into an Oracle database. It uses JDBC to interact with the database and executes a stored procedure for data insertion.

## Features
- Input student details such as ID, roll number, name, branch, address, and contact information.
- Store student data into relational tables using a stored procedure.
- Maintain separation of concerns by using different tables for address and contact information.

## Requirements
1. **Java Development Kit (JDK)**: Version 8 or above.
2. **Oracle Database**: Version 11g or above.
3. **JDBC Driver**: Oracle JDBC driver (`ojdbc8.jar`).

## Setup and Usage
### Database Setup
1. Connect to the Oracle database.
2. Create the required tables:
    ```sql
    CREATE TABLE Studentdata (
        STUID NUMBER PRIMARY KEY,
        STUROLLNO NUMBER,
        STUNAME VARCHAR2(50),
        STUBRANCH VARCHAR2(50)
    );

    CREATE TABLE StudentAddress (
        STUID NUMBER REFERENCES Studentdata(STUID),
        STUHNO NUMBER,
        CITY VARCHAR2(50),
        PINCODE NUMBER
    );

    CREATE TABLE StudentContact (
        STUID NUMBER REFERENCES Studentdata(STUID),
        MID VARCHAR2(50),
        PHNO NUMBER
    );
    ```
3. Create the stored procedure:
    ```sql
    CREATE OR REPLACE PROCEDURE StudentDetails (
        sid IN NUMBER,
        srn IN NUMBER,
        sname IN VARCHAR2,
        sbr IN VARCHAR2,
        shno IN NUMBER,
        scity IN VARCHAR2,
        spin IN NUMBER,
        smid IN VARCHAR2,
        sphno IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Studentdata VALUES (sid, srn, sname, sbr);
        INSERT INTO StudentAddress VALUES (sid, shno, scity, spin);
        INSERT INTO StudentContact VALUES (sid, smid, sphno);
    END;
    /
    ```

### Application Setup
1. Add the Oracle JDBC driver (`ojdbc8.jar`) to your project.
2. Update the database connection details in the `DriverManager.getConnection` method in the Java code.
    ```java
    Connection con = DriverManager.getConnection(
        "jdbc:oracle:thin:@localhost:1521:orcl",
        "c##mydbhome",
        "home"
    );
    ```
3. Compile and run the `StudentDetails` Java class.
    ```bash
    javac StudentDetails.java
    java adv_procedure_lab_jan23.stundent_details.StudentDetails
    ```

## Example Interaction
### Input:
```
Enter student id: 1001
Enter student roll no.: 23456
Enter student name: Smith
Enter student branch: CSE
Enter student house no.: 108
Enter student city: Hyderabad
Enter student city pincode: 500036
Enter student mail id: smith@gmail.com
Enter student phone no.: 9876543210
```

### Output:
```
Student details successfully inserted.
```

### Database Records:
**`Studentdata` Table:**
| STUID | STUROLLNO | STUNAME | STUBRANCH |
|-------|-----------|---------|-----------|
| 1001  | 23456     | Smith   | CSE       |

**`StudentAddress` Table:**
| STUID | STUHNO | CITY       | PINCODE |
|-------|--------|------------|---------|
| 1001  | 108    | Hyderabad  | 500036  |

**`StudentContact` Table:**
| STUID | MID            | PHNO       |
|-------|----------------|------------|
| 1001  | smith@gmail.com | 9876543210 |

## Notes
- Ensure the Oracle database service is running before executing the program.
- Handle potential exceptions such as `SQLException` and `ClassNotFoundException`.

## Author
Milind
