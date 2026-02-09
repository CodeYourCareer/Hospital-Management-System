# Hospital Management System

A simple Java-based Hospital Management System that allows users to manage patients, doctors, and appointments through a console application. Built with Java and MySQL.

---

## Features

- Add and view patients  
- View list of doctors  
- Book appointments for patients with doctors  
- Simple and easy-to-use console interface  
- Stores data in a MySQL database  

---

## Technologies Used

- Java (JDK 23)  
- MySQL  
- JDBC for database connectivity  
- IntelliJ IDEA (for development)  

---

## Installation and Setup

1. **Clone the repository**

```bash
git clone https://github.com/CodeYourCareer/Hospital-Management-System.git
cd Hospital-Management-System

---


Set up the MySQL database

Create a database named hospital_db

Create tables for patients, doctors, and appointments

Update your database credentials in the code if needed

Add MySQL Connector

Download mysql-connector-j-9.6.0.jar

Add it to your project classpath

Compile and Run

---


javac -cp .;mysql-connector-j-9.6.0.jar HospitalManagementSystem/HospitalManagementSystem.java
java -cp .;mysql-connector-j-9.6.0.jar HospitalManagementSystem.HospitalManagementSystem


---

## Usage Example
Driver Loaded Successfully.
Database Connected Successfully.

=============== HOSPITAL MANAGEMENT SYSTEM ===============
1. Add Patient
2. View Patients
3. View Doctors
4. Book Appointment
5. Exit
==========================================================
Enter your choice: 1
Enter Patient Name: Vishwajeet Singh
Enter Patient Age: 24
Enter Disease: Fracture
Enter Patient Gender: Male
Patient has been added successfully.

=============== HOSPITAL MANAGEMENT SYSTEM ===============
1. Add Patient
2. View Patients
3. View Doctors
4. Book Appointment
5. Exit
==========================================================
Enter your choice: 2
Patients List
+----+----------------------+-----+----------------------+--------+
| ID | Name                 | Age | Disease              | Gender |
+----+----------------------+-----+----------------------+--------+
| 1  | Ankit Jaiswal        | 22  | Fever                | Male   |
| 2  | Vishwajeet Singh     | 24  | Fracture             | Male   |
+----+----------------------+-----+----------------------+--------+

=============== HOSPITAL MANAGEMENT SYSTEM ===============
1. Add Patient
2. View Patients
3. View Doctors
4. Book Appointment
5. Exit
==========================================================
Enter your choice: 3
Doctors
+------------+------------------------------+---------------------+
| Doctor ID  | Name                         | Specialization      |
+------------+------------------------------+---------------------+
| 1          | Aditi Yadav                  | Physician           |
| 2          | Manish Yadav                 | Neuro               |
+------------+------------------------------+---------------------+

=============== HOSPITAL MANAGEMENT SYSTEM ===============
1. Add Patient
2. View Patients
3. View Doctors
4. Book Appointment
5. Exit
==========================================================
Enter your choice: 4
Enter Patient ID: 2
Enter Doctor ID: 1
Enter Appointment Date (YYYY-MM-DD): 2026-02-09
Appointment booked successfully!

Contributing

This is a personal project. Feel free to fork and make improvements or add features like:

User authentication

Billing system

Advanced appointment scheduling