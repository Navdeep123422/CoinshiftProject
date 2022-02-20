# CoinshiftProject

It is Rest Assure Data-Driven framework. it is used to drive test cases and suites from an external data feed. The data feed can be data sheets like xls, xlsx, and csv files.A Data Driven Framework in Selenium is a technique of separating the “data set” from the actual "test case" (code). Since the test case is separated from the data set, one can easily modify the test case of a particular functionality without making changes to the code. 

For API Testing Rest Assured Framework made, All classes and methods are implemented in Java with Maven repository to include all dependencies needed.

Use of TestNG such as Data provider annotation to separate test data in external file and flexible test suites configuration and management. Also, TestNG generates 2 types of reports, HTML and XML reports. The HTML reports are very descriptive with good statistics

# Used tools and frameworks
IDE: Eclipse

Rest-Assured

Maven repository

TestNG

Apache POI to extract test data from Excel files

# Getting Started
1. Clone repository.
2. Use TestNG configuration for Test scripts and check Test Report Generation.
emailable TestNg Report
![image](https://user-images.githubusercontent.com/99684795/154835474-d15258ee-9611-42ae-8561-aba5afe7d098.png)
   
Test suits Result
![image](https://user-images.githubusercontent.com/99684795/154835948-c30b1984-072a-41ff-a84b-861cb3daaf8c.png)
![image](https://user-images.githubusercontent.com/99684795/154835959-74995b93-2392-4e1f-b85b-803692a59a7f.png)

3. Source Data file is on src> test > java > SourceDataFile.xlxs, Test data can be add, update and delete from here.
4. Go to src > test > java > TestAPIClass, Put the url on BaseURI for API testing wanted to continue in both Get and Post method.
5. Data provider annotation can be used to provide data from external files, For File reading we have Generic class as TestExcelUtils using Apache POI.
6. For Different Test Scenarios assert methods can be added and by using TestNG Test script could be checked.




