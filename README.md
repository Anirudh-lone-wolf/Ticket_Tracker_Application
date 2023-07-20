# G1B6_BED_GradedProject3
* **Problem Statement : You are required to create a CRUDS (Create, Read, Update, Delete, Search) functionality for a ticket tracker application.**
* This project is created using Spring Boot(version 3.1.1). The Spring Boot autoconfiguration registers and configures the DispatcherServlet automatically. Therefore, we have not included the web.xml file or registered DispatcherServlet manually. The only xml file in this project is the project POM file (Maven is the build tool used here).
* We have used MySQL as the database for this project. All configuration details are in application.properties file in src/main/resources folder. **Password section is lefted blank kindly put your own password before executing this project**.
* The main package is com.glearning.Project which contains the Driver class of the Application There are 5 sub-packages :
    * com.glearning.Project.model - conatains the 'Ticket' entity class
    * com.glearning.Project.doa - contains a 'TicketRepository' interface which extends JpaRepository for database related operations in spring
    * com.glearning.Project.service - contains a 'TicketService' Interface and an implementation class. Here the JpaRepository methods are used for                                                               different CRUD operations as required by the use case - Create, Read, Update, Delete and Search.
    * com.glearning.Project.controller - which will have url mappings to perfom different CRUDS functionalities in the UI
* The UI is created using Thymeleaf. Thymeleaf is a modern server-side Java template engine for both web and standalone environments. Using Thymeleaf we have rendered the back end code on the front end UI so that the user can test out the different functionalities.
This is a group project.
