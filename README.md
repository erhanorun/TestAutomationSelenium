# Test Automation Selenium

## Installation
* First step is installation of `Java JDK` on your PC
* Use `Intellij Idea IDE` for creating `Maven` Project
* Write dependencies in `pom.xml`

## Dependencies
* `Selenium`
* `JUnit`
* `Log4J`
* `webdrivermanager made by Boni Garcia`
* `maven-compiler-plugin for encoding`

## Create Page Oriented Design.

Our Page Oriented Design includes Classes in below:
* `BasePage:` using for common methods (clickElementByID, waitPageLoad etc.)
* `BaseTest:` using for preoperational stages in testing
* `Constants:` using for common constants (user name, site url etc.)
* `TaskMethods:` using for implementing methods in @Test (addProductToCart() etc.)
* `Tests:` using for testing
* `Interface:` includes methods which can be used for overriding in the future and have implemented TaskMethods Class.

## PURPOSE
* My Purpose is creating a page oriented design for test automation of some operations at the website which is [www.gittigidiyor.com](/api.md).
* Some operations are adding product to cart, login to the website, searching any category etc.