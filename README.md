# Bloodify-Appium_SkillDemo

## Overview
Bloodify-Appium_SkillDemo is a project built to efficiently automate mobile application testing across Android platforms. It demonstrates expertise in Java, Appium, mobile testing, TestNG, device handling, CI/CD integration, and strong problem-solving and debugging skills for cross-platform environments.

## Features
- Built using **Appium** and **TestNG** for robust and scalable test automation.
- Integrated with **Maven Wrapper** for easier build management and dependency handling.
- CI/CD enabled through **GitHub Actions**.
- Automatically generates detailed test reports using **Allure Report**.

## Prerequisites
Before setting up and running the project, ensure you have the following installed:
- [Amazon Corretto JDK 17.0.14](https://aws.amazon.com/corretto/)
- [Maven](https://maven.apache.org/install.html) (optional if using Maven Wrapper)
- [Git](https://git-scm.com/downloads)
- Appium, Selenium-Java, TestNG, and Allure libraries (managed via Maven)

## APK Path
- The APK used for testing is located in the following path:
  ```
  src/test/resources/apk
  ```

## Appium Server Initialization
On a new machine, the Appium Server must be initialized for the first time using:
```sh
appium server --allow-insecure chromedriver_autodownload
```
After that, for future executions, you can simply run:
```sh
appium server
```

## Device Setup
Before running the tests:
- Start the Android emulator **or** connect a physical device.
- Ensure the correct APK is already installed on the device.

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/DiegoPatcheco/Bloodify-Appium_SkillDemo.git
   ```
2. Navigate into the project directory:
   ```sh
   cd Bloodify-Appium_SkillDemo
   ```
3. Build the project using Maven Wrapper:
   ```sh
   ./mvnw clean install
   ```

## Running Tests
To execute the automated test suite:
```sh
./mvnw clean test
```

You can also run a predefined suite using:
```sh
./runSuite.sh
```

## Allure Report
- The **Allure Report** is generated automatically after test execution.
- To view the report locally:
  ```sh
  ./openAllure.sh
  ```

## CI/CD Integration
- GitHub Actions is configured to automatically trigger test execution on every push or pull request.
- Allure reports and test results are available in the GitHub Actions artifacts after each run.

## Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new feature branch.
3. Commit and push your changes.
4. Open a pull request.

## Author
Developed by [Diego Patcheco](https://github.com/DiegoPatcheco).

