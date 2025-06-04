<p align="center">
  <img src="src\resources\ShopApp_Selenf.png" alt="ShopApp Selenium E2E Logo" width="300"/>
</p>


## 🚀 Getting Started

### Prerequisites

- Java 21
- Maven
- Docker and Docker Compose (for running Selenium Grid)

### Project Setup

1. Clone this repository
2. Build the project: `mvn clean install`

###

Overriding config on powershell
```bash
.\mvnw test -Dtest=LoginTest `
    "-Dcredentials.username=admin" `
    "-Dcredentials.password=admin"
```

Overriding config on bash
```bash
./mvnw test -Dtest=LoginTest -Dcredentials.username='admin' -Dcredentials.password='admin'
```

Then run:

```bash
# On Mac/Linux
docker-compose up

# On Windows
docker compose up
```

## 🧪 Running Tests

### Local Tests

```bash
mvn test -Dtest=*local*
```

Example:
```bash
./mvnw test -Dtest=LoginTest
```

## 📊 Test Reports with Allure

[Allure](https://allurereport.org/docs/gettingstarted-installation/) is required to generate test reports.

```bash
# Run tests with Allure
mvn clean test

# Generate the report
allure generate target/allure-results -o target/allure-report

# Generate and serve the report (single HTML report)
allure generate target/allure-results -o target/allure-report --single-file
```
