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
1. **Baseclass** : This class serves as base for all clasess and performs common tasks for eg browser setup ,config file and reporting setup.
2. **pageobjects**:Under this packages all pagebjects are stored along with methods to access them .
3. **utility**: This folder stores Extent manager class and Listner class.
4. **testcases**: This folder contains all testcases . We can directly execute each file or we can execute using testng-xml.xml.
5. **test-output**: Extent reports are stored in this folder.
6. **config.properties** : This is used to store all url and passwords required for applocation.
