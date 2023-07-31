# CRUD Employee System using Spring MVC, Spring Boot, and Thymeleaf

This is a sample Employee Management System built using Spring MVC, Spring Boot, and Thymeleaf. This application allows you to perform CRUD (Create, Read, Update, Delete) operations on employee records.

## Technologies Used

- Spring MVC
- Spring Boot
- Spring Data
- Thymeleaf

## Getting Started

### Installing

1. Clone the repository:

```sh[
https://github.com/mohamedehab00/Simple-Employee-Managment-System.git
```

2. Create a MySQL database named `employee_management`:

```sh
CREATE DATABASE employee_directory;
```

3. Configure the database connection in the `application.properties` file located in the `src/main/resources` directory:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=create
```

4. Run the application using Maven:

```sh
mvn spring-boot:run
```

5. Access the application by visiting `http://localhost:8080` in your web browser.

## Usage

### Viewing Employees

To view a list of all employees, click on the "Employees" link in the navigation bar. This will take you to the employee list page, where you can see all the employees in the database.

### Adding Employees

To add a new employee, click on the "Add Employee" button on the employee list page. This will take you to the add employee form, where you can enter the employee details and submit the form to add the employee to the database.

### Updating Employees

To update an existing employee, click on the "Edit" button next to the employee on the employee list page. This will take you to the edit employee form, where you can update the employee details and submit the form to save the changes to the database.

### Deleting Employees

To delete an existing employee, click on the "Delete" button next to the employee on the employee list page. This will prompt you to confirm the deletion, and if you confirm, the employee will be deleted from the database.
