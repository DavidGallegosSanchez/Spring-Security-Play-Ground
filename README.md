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
> **Section3/DefiningAndManagingUsers** -> **How to configure multiple users using _InMemoryUserDetailsManager_ and creating _MySQL docker data base_**
>
>
> Command to create MySQL image in Docker: docker run -p 3306:3306 --name springsecurity -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=eazybank -d mysql
>
> Run script.sql (..resource/sql/scropts.sql) in the IDE of MySQL to create tables, users and authorities.
>
>  **Username: johndoe@example.com**
> 
> **Password: 54321**


> [!NOTE]
> **Section4/PasswordManagement** -> **Password management with password encoders**
>
> How to encode password when we create a new user (LoginController):
> 
> String hashPwd = passwordEncoder.encode(customer.getPwd());
> 
> customer.setPwd(hashPwd);


> [!NOTE]
> **Section5/AuthenticationProvider** 
>
> Use the customer created in the section 4 with password encode to try the login.


> [!NOTE]
> **Section6/CORs&CSRF** 
>
> Run the new schema in DataBase before run the app.
> Install Node.js, Angula CLI and Visual Studio.
> Start the forntend with ng serve.
> 
> How to fix CORs -> **@CrossOrigin** or http.cors().configurationSource() see **ProjectSceurityConfig.java configuration class**.
> 
> How to fix CRSF -> see **defaultSecurityFilterChain method of ProjectSceurityConfig.java configuration class** and **validateUser metohs of login.component, validateLoginDetail method of login.service and app.request.interceptor.ts file (line 21) in frontend**


> [!NOTE]
> **Section7/Authorization** 
> 
> Execute sql whith authority entity and vules.
> 
> Configuration for Authority and role in **defaultSecurityFilterChain method of class**
> 
> 401 -> Authentication Error
> 
> 403 -> Authorization Error


> [!NOTE]
> **Section8/Filters** 
>
> Create specific filters in a filter package
> 
> **Before** -> .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class), see **ProjectSecurityConfig.class**
>
> **At** -> .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class), see **ProjectSecurityConfig.class**
>
> **After** -> .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class), see **ProjectSecurityConfig.class**

> [!NOTE]
> **Section9/JSONWebToken** 
>
> Add **jsonwebtoken dependencies** in pom x3
>
> New filter to create a JWT -> **JWTTokenGeneratorFilter.class** and add .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class) in **ProjectSecurityConfig.class**
>
> New filter to validate a JWT -> **JWTTokenValidatorFilter** and add .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class) in **ProjectSecurityConfig.class**

> [!NOTE]
> **Section10/SecurityLevel** 
>
> Modify **requests.requestMatchers("/myLoans").authenticated();** in ProjectSecurityConfig.class and add **@EnableMethodSecurity(prePostEnabled = true,  securedEnabled = true,  jsr250Enabled = true)** in BankBackendApplication.class.
> 
> Add **@PreAuthorize("hasRole('USER')")** annotation of AOP in LoanRepository
>
> Add **@PostAuthorize("hasRole('USER')")** annotation of AOP in getLoanDetails method of LoansController
>
> Add **@PreFilter("filterObject.contactName != 'Test'")** in saveContactInquiryDetails method of ContactController
>
> Add **@PostFilter("filterObject.contactName != 'Test'")** in saveContactInquiryDetails method of ContactController
