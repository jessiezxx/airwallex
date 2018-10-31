# This API test package is written by jessie zhang for the interview of airwallex.

Getting Started 
It's API test about collecting bank info from customers.
These instructions will get you a copy of the project up and running on your local machine for testing purposes. You can start it by command line or testng.xml.

Introduction
It's developed by java8 and use TestNG as the automation framework.
Gradle is used for building this project.

Running the test
Your test URL is configurable to support running test cases for different environments.
You can configure it in testng.xml or as a command line parameter of gradle via the "-D" option.

Run your cases from command line:
```
gradle test -DserverUrl=http://preview.airwallex.com:30001/bank
```
You can open test-output/index.html with a browser to view the test results.
