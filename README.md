# Repository created from the execution of the following course

[![Image](https://github.com/eazybytes/springsecurity6/blob/3.2.0/Spring%20Security.png "Spring Security Zero to Master along with JWT,OAUTH2")](https://www.udemy.com/course/spring-security-zero-to-master/?referralCode=87DD08821FF0A3685D1C)

'Spring Security Zero to Master' course will help in understanding the Spring Security Architecture, important packages, interfaces, classes inside it which handles authentication and authorization requests in the web applications. It also covers most common security related topics like CORs, CSRF, JWT, OAUTH2, password management, method level security, user, roles & authorities management inside web applications.

> [!NOTE]
> **Section1/SpringSecurityBasic**
> 
> Securing Spring Boot basic app using Spring Security and static credentials configuration inside the application properties file.
>
> **Username: dgallegos**
> 
> **Password: 12345**
>


> [!NOTE]
> **Section2/SpringSecurity** -> **Changing the default security configurations**
> 
> Backend REST services (Account, Balance, Card, Contact, Loan and Notice) and setup **default configuration**, **permitAll** and **denyAll**.
>
> Secure -> myAccount, myBalance, myLoans, myCards
> 
> No Secure -> contact, notices
>
> **Username: dgallegos**
> 
> **Password: 12345**



> [!NOTE]
> **Section3/SpringSecurity** -> **How to configure multiple users using _InMemoryUserDetailsManager_ and creating _MySQL docker data base_**
>
>
> Command to create MySQL image in Docker: docker run -p 3306:3306 --name springsecurity -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=eazybank -d mysql
>
> Run script.sql (..resource/sql/scropts.sql) in the IDE of MySQL to create tables, users and authorities.
>
>  **Username: johndoe@example.com**
> 
> **Password: 54321**
