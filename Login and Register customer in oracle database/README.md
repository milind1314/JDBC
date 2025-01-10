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



Feel free to modify any details according to your preferences or specific project settings.
