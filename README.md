# Bloodify-Appium\_SkillDemo

## Overview

Bloodify-Appium\_SkillDemo is a project developed to efficiently automate mobile application testing across Android platforms. It showcases skills in Java, Appium, mobile testing, TestNG, device handling, CI/CD integration, and strong problem-solving and debugging capabilities in cross-platform environments.

## Features

- Built using **Appium** and **TestNG** for robust mobile automation.
- Integrated with **Maven Wrapper** for simplified build and dependency management.
- CI/CD integration with **GitHub Actions** to ensure continuous testing and delivery.
- Automatically generates detailed test reports using **Allure Report**.

## Prerequisites

Before setting up the project, make sure you have the following installed:

- [Amazon Corretto JDK 17.0.14](https://aws.amazon.com/corretto/)
- [Maven](https://maven.apache.org/install.html) (if not using Maven Wrapper)
- [Git](https://git-scm.com/downloads)
- Libraries: Appium, Selenium-Java, TestNG, Allure (managed via Maven)

## APK Location

The APK used for testing is located at:

```
src/test/resources/apk
```

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/DiegoPatcheco/Bloodify-Appium_SkillDemo.git
   ```
2. Navigate to the project directory:
   ```sh
   cd Bloodify-Appium_SkillDemo
   ```
3. Install dependencies and build the project using Maven Wrapper:
   ```sh
   ./mvnw clean install
   ```
   *(On Windows use ******`mvnw.cmd`****** instead)*

## Running Tests

To run the test suite:

```sh
./mvnw clean test
```

You can also run a predefined test suite with:

```sh
./runSuite.sh
```

## Allure Reports

- The **Allure Report** is generated automatically after test execution.
- To view the report locally:
  ```sh
  ./openAllure.sh
  ```

## CI/CD Integration

- The project is integrated with **GitHub Actions**, which triggers the test suite on every push or pull request.
- Test results and **Allure Reports** are accessible via the **Actions** tab in GitHub.

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch (`feature-branch`).
3. Commit your changes.
4. Push to your branch and submit a pull request.

## Author

Developed by [Diego Patcheco](https://github.com/DiegoPatcheco).
