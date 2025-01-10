# Login and Registration System

## Description

This is a Java-based customer login and registration system connected to an Oracle database. The system allows customers to register, login, and perform various actions, such as updating customer details, deleting customers, and displaying customers with prime IDs. It uses JDBC for database interactions.

## Features

1. **Customer Registration**
   - Customers can register by providing details such as ID, Username, Password, First Name, Last Name, Email, and Phone Number.
   
2. **Customer Login**
   - Customers can log in using their Username and Password.
   
3. **Post-Login Features**
   - **Show all Customers**: Displays a list of all customers.
   - **Update Customer Details**: Allows updating the Email ID and Phone Number of a customer by ID.
   - **Delete Customers with Name Starting with 'S'**: Deletes customers whose name starts with 'S'.
   - **Show Customers with Prime IDs**: Displays customers whose IDs are prime numbers.
   
4. **Exit Option**: Exit the application gracefully.

## Prerequisites

- **JDK 8 or higher** for running the Java application.
- **Oracle Database** for the backend. The application uses JDBC to connect to an Oracle database with the following credentials:
  - Host: `localhost`
  - Port: `1521`
  - SID: `orcl`
  - Username: `c##mydbhome`
  - Password: `home`

- **Oracle JDBC Driver** (`ojdbc8.jar`) must be available in the classpath.

Database Setup
Ensure the Oracle Database is running and the following table exists:

# Customer Registration & Login System

## Project Overview

This project allows users to register, login, update their information, and perform various actions on their profile in a customer database.

## Prerequisites

- **Java**: JDK 8 or later
- **Oracle Database**: Version 12c or later
- **Oracle JDBC Driver**: Required for connecting Java with Oracle Database
- **IDE**: Any Java IDE (Eclipse, IntelliJ IDEA, etc.)

## Setting Up the Database

Ensure that your Oracle Database is running and that the following steps are followed to set up the `customer_login` table.

### 1. **Start Oracle Database**

Ensure that the Oracle Database is running. You can check this by connecting to the database using tools like SQL*Plus, SQL Developer, or any other database client.

### 2. **Create the `customer_login` Table**

To create the required table in the database, execute the following SQL query:

```sql
CREATE TABLE customer_login (
    CUSTOMER_ID INT PRIMARY KEY,
    CUSTOMER_NAME VARCHAR(50),
    CUSTOMER_PASSWORD VARCHAR(50),
    CUSTOMER_FNAME VARCHAR(50),
    CUSTOMER_LNAME VARCHAR(50),
    CUSTOMER_MAILID VARCHAR(100),
    CUSTOMER_PHONENUMBER BIGINT
);



## Feel free to modify any details according to your preferences or specific project settings.
