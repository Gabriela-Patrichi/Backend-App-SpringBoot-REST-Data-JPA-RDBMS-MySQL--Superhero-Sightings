# Superhero-Sightings - Backend Application

**Backend:**
- Developed in IntelliJ using Java.
- Uses SpringBoot Framework, including Spring Data JPA with ORM for management of relational data.
- Implements both unidirectional and bidirectional mappings for relationships.
- Provides full CRUD operations for all entities, along with additional custom finder methods.
- Well-structured, layered architecture pattern consisting of Controller, Service, DAO, and Model packages.
- Implements an Exception package, with a GlobalExceptionHandler class for handling errors.
- All endpoints have been tested using Postman.
  
**Database:**
- Constructed using MySQL Workbench.
- Ensures that each table possesses an appropriate Primary Key or a suitable composite key.
- Accurately expresses relationships between tables through the use of Foreign Keys on entity tables for one-to-many relationships and bridge tables for many-to-many relationships.
- Adheres to the principles of normalization up to the third normal form (3NF).
- Includes schema and data .sql files, as well as an Entity-Relationship Diagram (ERD) for comprehensive documentation.



Scenario: 

With the rising popularity of superhero movies, there has been a heightened awareness of superheroes in our midst. The frequency of superhero (and supervillain) sightings is increasing at an alarming rate. Given this development, the Hero Education and Relationship Organization (HERO) has asked our company to develop a database and data layer for their new superhero sightings web application.

The system has the following requirements:
- It must keep track of all superhero/supervillain information.
- Heroes have names, descriptions, and a superpower.
- Heroes are affiliated with one or more superhero/supervillain organizations.
- It must keep track of all location information:
- Locations have names, descriptions, address information, and latitude/longitude coordinates.
- It must keep track of all superhero/supervillain organization information:
- Organizations have names, descriptions, and address/contact information.
- Organizations have members.
- A user must be able to record a superhero/supervillain sighting for a particular location and date.
- The system must be able to report all of the superheroes sighted at a particular location.
- The system must be able to report all of the locations where a particular superhero has been seen.
- The system must be able to report all sightings (hero and location) for a particular date.
- The system must be able to report all of the members of a particular organization.
- The system must be able to report all of the organizations a particular superhero/villain belongs to.
