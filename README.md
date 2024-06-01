# CoinDesk

This application consumes data from the CoinDesk Bitcoin Price Index (BPI) API and stores it in a database.

## Prerequisites
Before running the application, ensure you have the following installed:
* Java 21 or later
* Maven 3.6.x above
* MySQL or PostgreSQL database server


## Configuration
* Clone the repository to your local machine:
```
git clone https://github.com/ZainNoushad/CoinDesk.git
```
* Navigate to the project directory:
```
cd CoinDesk
```
* Open the `src/main/resources/application.properties file and configure the database connection settings according to your environment:
```
spring.datasource.url=jdbc:mysql://localhost:3306/YOUR_DB_NAME
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
```
* Ensure that the database schema is created. You can find the SQL script for creating the schema under `/src/main/resources/` in the `ddl-queries` directory.


## Build and Run
* Build the application using Maven:
```
mvn clean package
```
* Run the application with Maven, passing the database configuration values as program arguments:
```
mvn spring-boot:run
```


## Usage
Once the application is running, it will fetch data from the CoinDesk API and store it in the configured database. You can access the stored data through the database tables.


## Additional Notes
* Make sure your database server is running before starting the application.