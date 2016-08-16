Jed Exam
===============================
###The application does the following: 
  1. Searches (non-case sensitively) a specific Tag from a HighRise user. If found then those Tag/s with its associated Contacts will then be stored in the database.
  2. Views the stored Tags-Contacts which were retrieved from HighRise server. 
  Note: The Contact's FullName and Phone Number are the only details stored in the database.

###Pre-conditions before running the application:
  1. Configure the following in the jedexam\src\main\webapp\config.properties file
    	A. Highrise User credentials; Fill-up using Basic Authentication, a combination of the API Authentication Token as the username and "X" as the password. Sample Basic Authentication value: Basic XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	B. Highrise web service Hostname
	C. Database properties
	D. Hibernate Configuration

###To run this file locally
  1. Build
    ```shell
      $ git clone https://github.com/jedzme/jedexam
      $ mvn clean install
    ```
  2. Deploy _\jedexam\target\_**jedexam.war** in in Tomcat
  3. Access ```http://localhost:8080/jedexam```

###The application has been tested using the following environment details:
  1 Google Chrome web browser Version 52.0.2743.116 m (64-bit)
  2. Postgresql 9.5
  3. Apache Tomcat 7

###The application is built using the following technologies:
  * [Spring Web MVC](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)
  * [Spring Data JPA](http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories)
  * [Hibernate](http://hibernate.org/orm/)
  * [Jersey Client API](https://jersey.java.net/documentation/latest/client.html)
  * [Simple XML](http://simple.sourceforge.net/)

###The application was compiled using JDK 1.7.
