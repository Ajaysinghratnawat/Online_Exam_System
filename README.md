# Online Exam System

A Java-based web application for managing questions records using **Servlets, JSP, JDBC, and MySQL**, built with a clean **layered architecture**.

---

## 🚀 Features
- Add, Update, Delete question, Test (CRUD)
- User Authentication (Login & Registration)
- Layered Architecture (Controller, DAO, dto, Util)
- JDBC-based database connectivity
- Simple UI using HTML, CSS

---

## 🛠 Tech Stack
- **Backend:** Java, JDBC, Servlet, JSP  
- **Frontend:** HTML, CSS  
- **Database:** MySQL  
- **Server:** Apache Tomcat  
- **IDE:** Eclipse  

---

## 📥 Clone the Repository

To get a local copy of this project, run the following command:

```bash
https://github.com/Ajaysinghratnawat/Online_Exam_System
```


# Create Databse
```sql
create database oes;
use oes;

CREATE TABLE admin (
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE student (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(50)
);

CREATE TABLE question (
    q_id INT PRIMARY KEY AUTO_INCREMENT,
    question TEXT,
    option1 VARCHAR(255),
    option2 VARCHAR(255),
    option3 VARCHAR(255),
    option4 VARCHAR(255),
    correct_option INT
);

CREATE TABLE result (
    result_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    score INT,
    total INT,
    exam_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO admin(username,password)
VALUES('ajay','123');
);
```
