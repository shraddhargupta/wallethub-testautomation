# wallethub-testautomation

##Project Description

This is GUI Automation framework designed using selenium web driver (Java) , TestNG to verify facebook login and wallethub review functionality.


## Software Requirement

|  Name         |  Version      |
|-------------- |---------------|
|jdk            | 1.8           |
|Maven          | NA            |
|Intelij/eclipse| NA            |


All dependant library files can be downloaded using pom.xml

## Framework Architecure:
# Baseclass : This class serves as base for all clasess and performs common tasks for eg browser setup ,config file and reporting setup.
# pageobjects:Under this packages all pagebjects are stored along with methods to access them .
# utility: This folder stores Extent manager class and Listner class
# testcases: This folder contains all testcases . We can directly execute each file or we can execute using testng-xml.xml
# test-output : Extent reports are stored in this folder
# config.properties : This is used to store all url and passwords required for applocation
