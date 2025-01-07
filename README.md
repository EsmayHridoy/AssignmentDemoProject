# Book Shop Management Project

## Overview  
The **Book Shop Management Project** is a web-based application designed to manage book shop operations efficiently. It provides functionalities for user authentication, book management, and user management with role-based access control. This project implements full CRUD (Create, Read, Update, Delete) operations for both users and books, ensuring seamless management of data throughout the system. 
---

## Tools Used  
- **IDE**: IntelliJ IDEA  
- **Server**: Apache Tomcat  
- **Database**: MySQL Server  

---

## Technologies  

### Backend  
- **Programming Language**: Java  
- **Frameworks & APIs**:  
  - Java Servlet  
  - Servlets Filter (for Authentication and Authorization)  
- **Database**:  
  - JDBC  
  - SQL  

### Frontend  
- **Technologies**:  
  - HTML  
  - CSS  
  - JSP  

---

## Features  

### Authentication and Authorization  
- **Login**: Secure user login functionality.  
- **Registration**: User sign-up with role assignment (default roles: User, Admin).  

### Book Management  
- **Add Book**: Admin-only functionality to add new books to the catalog.  
- **Delete Book**: Admin-only functionality to remove books from the catalog.  
- **Edit Book Details**: Available to Admins to modify book information.  

### User Management  
- **Show User List**: Admin-only access to view all registered users.  
- **Modify User Role**: Admins can change user roles (e.g., User to Admin).  
- **Edit User Details**: Users can update their personal information.  

### Purchase Management  
- **Buy Book**: Available to both Admin and User roles to purchase books.  

### Security  
- Passwords are stored securely using Base64 hash encoding.  

---

## Database Schema  

### Database: `book_shop`  

#### Tables  

1. **`user_table`**  
   - `user_id`: Unique identifier for users  
   - `name`: User's full name  
   - `email`: User's email address  
   - `password`: Hashed password  
   - `role`: User's role (e.g., User, Admin)  

2. **`book_table`**  
   - `book_id`: Unique identifier for books  
   - `book_name`: Name of the book  
   - `author`: Author of the book  
   - `price`: Price of the book  
   - `book_count`: Available quantity of the book  

---

## Next Steps  
- **Add Purchase History**: Implement a feature to record and display users' purchase history.  

---  

## Installation and Setup  
1. Clone the repository.  
2. Configure the database by importing the `book_shop` schema.  
3. Update database connection settings in the project code.  
4. Deploy the project on Tomcat Server via IntelliJ IDEA.  
5. Access the application through the configured local server.  

Feel free to contribute or suggest improvements!
