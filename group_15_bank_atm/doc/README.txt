Fancy Bank ATM

The application needs to have MySQL server installed to be able to run properly. 
Create a database by executing the SQL Script, bank_atm.sql.
Change the connection setting at DBManager.java by using the user id and password you created. 
User: admin
Password: admin

 con=DriverManager.getConnection(
                	"jdbc:mysql://localhost:3306/bank_atm","admin","admin");


This is a console application for Fancy Bank ATM application. The main method is located in Main.java

To run the program: run as per regular java program. 

javac *.java
java Main
