# Hobby Web Application (HWA) - Restaurant Rating API

The task for this project was to create a function front-end, back-end and database for a hobby of choice.  
A Restaurant Rating API was selected for the hobby, with the main use to log all notable restaurant meals, give each a rating and revert back to this list
when looking for a restaurant to eat at. The API allows for a user to input a restaurant name, location, dish and dish rating through the front-end, 
and stored in a local MySQL database. HTML, CSS were used to design the API and Javascript allowed for RESTful interactions between the front-end 
and database. Interactions included reading, creating, updating and deleting existing entities in the database and the front-end was testing using Selenium. 
The back-end of the project was built using the Spring Java framework and tested through Junit SonarQube was also used for static analysis. Back-end testing 
included Unit and Integration testing. 



## Table Of Contents

- Getting Started
- Prerequisite & Installing
- Unit Tests
- Integration Tests
- WebDriver Tests (Selenium)
- Built With
- Authors
- License
- Acknowledgments



## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
Follow this procedure to get a copy of the IMS project and run it:
1. Ensure you are on the Main Feature branch on GitHub. Follow this link if you're unsure: https://github.com/PUgonaQA/PU-HobbyAssessment
2. Once you are here, click on the green "Code" button and select "Download ZIP". Select an appropriate folder and download the file.
3. Open the file location, right click on the file "PU-HobbyAssessment.zip" and extract/unzip to a new folder. If you do not have a file extractor installed, follow the WinRaR Prerequisite below to install one.
4. Once the folder has been extracted, access the "PU-HobbyAssessment" folder.
5. Right click on the empty space in the file explorer and select "GitBash" here. If you do not see "GitBash", you will need to download and install GitBash. Follow the GitBash Prerequisite below to install it.
   Also, you will need to install JavaScript on your device if it is not already installed. Follow the JavaScript Prerequisite below to install it.
6. Once the GitBash command prompt has opened, type in the following commands:
6. a) cd target/  -->Enter
6. b) ls    -->Enter (You should now see the following "ims-0.0.1-jar-with-dependencies.jar" <----- copy this)
6. c) java -jar ims-0.0.1-jar-with-dependencies.jar
7. You should now have access to the Hobby Web API.
8. To access the API, go to a browser installed on you machine (such as Google Chrome or Mozilla Firefox) and type in the following address: http://localhost:9092/
9. You can now add a new restaurant, restaurant location, restaunrant dish and dish rating.
10. Once you input the required fields in the form, the Restaurant Table should begin to populate with your fields.
11. You can manipulate this data through the Update and Delete Buttons
12. The Delete button will ask for validation before deleting a created entity. 
13. The Update button



### Prerequisites & Installation

To be able to run this project, the following applications or software need to be installed on your local system. This includes:

- WinRar(Optional)
  1. Visit the link: https://www.win-rar.com/start.html?&L=0
  2. Click the blue-box with text "Download WinRaR". If you have a 32 bit device install the 32 bit version below the button.
  3. Run the .exe file downloaded and click "Install"
  You should now have WinRAR installed on your device. 
  
- Java (Essential)
  1. Visit the following link to download Java SE Development kit 16: https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html
  2. Select your operating system and download the appropriate file
  3. Once downloaded, run the downloadded file
  4. Continue to click next and install until you have succesfully downloaded Java. 
  5. The JDK will have the following location on Windows " C:/Program Files/Java".
  6. You will now need to set-up the environment variabless for the JDK
  7. Click on the Windows Key, type in "path" and select "Edit the system environment variables"
  8. Click on the tab "advanced", and click on "Environment Variables".
  9. Click on "New" on the "Systems Variables" box at the bottom.
  10. Create a new variable by typing "JAVA_HOME" in the Variable Name box followed by the Variable Value which is the Java Path.
  11. Click OK. Now set the PATH by clicking Edit in the System Variables.
  12. Add the folowing text at the enf of the Variable Value text "%JAVA_HOME%\bin".
  You should now have JavaScript installed on your device.  
  
- GitBash (Essential)
  1. Visit the following link: https://git-scm.com/downloads
  2. Click on your Operating System 
  3. The download should automatically start. If it does not, click on the correct version for your device (32 bit or 64 bit).
  4. Run the downloaded .exe file, follow the instructions to install the appropriate files/
  You should now have GitBash installed on your device. 


## Testing

### Unit Tests 
Unit Tests can be run by opening the Project on a Java IDE such as (Eclipse IDE). 
Once the project has been imported, right click on the project and select "Coverage", then select "Run Test".
The tests should now be running.Testing: These tests are carried out using Junit with the Maven system in Java Eclipse. A unit test is a piece of
code written by a developer that executes a specific functionality in the code to be tested and asserts a certain
behaviour or state

### Integration Tests 
Carried out using Junit in Java Eclipse also. An integration test aims to test the behaviour of a
component or the integration between a set of components. Essentially, these tests covert the user stories into
tests.

### WebDriver Tests (Selenium)
Using Selenium WebDriver to automate web browsers to test website functionality.
Carried out also through Java Eclipse.



### Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [MySQL Wokbench] (https://www.mysql.com/) - Databases Management Application
* [GitBash] (https://git-scm.com/) - Local Repository for version control
* [GitHub] (https://github.com/)- Verison Management and software development platform
* [JUNIT] (https://junit.org/junit4/) - Unit Testing
* [Visual Studios] (https://www.oracle.com/uk/java/) - Back-end programming Language
* [Eclipse IDE] (https://www.oracle.com/uk/java/) - Back-end programming Language
* [Mozilla Firefox] (https://www.oracle.com/uk/java/) - Useful for using Selenium to test the API. 
* [Google Chrome] (https://www.oracle.com/uk/java/) - Selenium Tests were run through this browser.
* [Selenium IDE] (https://www.postman.com/) - Web automation testing
* [PostMan] (https://www.postman.com/) - API HTTP request methods and tesing



### Authors

* **Philip Ugona** - Completed the Restaurant Hobby API



### License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 


### Acknowledgments

* [Bootsrap] (https://getbootstrap.com/) - A framework with pre-defined HTML code and CSS styling.
* [Google Fonts] (https://fonts.google.com/) - Fonts used in the Front-End.
* [QA Community] (https://qa-community.co.uk/) - Useful resources for Project creation.


