# Login and Registration System

This is a simple login and registration system built with Spring Boot, Thymeleaf, and MySQL. Users can register and log in to the system, and their details will be stored in a MySQL database.

## Features

- User registration
- User login
- User logout
- Session-based success messages

## Technologies Used

- Spring Boot
- Thymeleaf
- MySQL
- Bootstrap 5

## Getting Started

These instructions will help you set up the project on your local machine for development and testing purposes.

### Prerequisites

- Java 8 or higher
- Maven
- MySQL

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/AminduBhashana/springboot_login_register_system.git
    ```

2. Navigate to the project directory:
    ```bash
    cd springboot_login_register_system
    ```

3. Configure MySQL database:
    - Create a database named `newDB`.
    - Update the `application.properties` file with your MySQL username and password.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/newDB?createDatabaseIfNotExist=true
    spring.datasource.username=<yourusername>
    spring.datasource.password=<yourpassword>
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```

4. Build the project using Maven:
    ```bash
    mvn clean install
    ```

5. Run the application:
    ```bash
    mvn spring-boot:run
    ```

6. Open your browser and navigate to `http://localhost:8080` to see the application in action.

## Usage

### Register

1. Click on the "Register" button on the navbar.
2. Fill out the registration form with your email, name, contact number, and password.
3. Click the "Register" button to submit the form.
4. A success message will be displayed upon successful registration.

### Login

1. Click on the "Login" button on the navbar.
2. Enter your registered email and password.
3. Click the "Login" button to log in.

### Logout

1. Click on the "Logout" button on the navbar to log out of the application.

## Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Bootstrap](https://getbootstrap.com/)
