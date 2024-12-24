# Jasper-Report

A Java library for generating, viewing, and exporting reports using [JasperReports](https://community.jaspersoft.com/). This repository provides utility methods to streamline the creation and management of reports using JasperReports.

## Features

- Generate and view reports using:
  - `JTable` as a data source
  - Database `Connection`
  - Empty data source (for static reports)
- Export reports to:
  - PDF
  - HTML

## Prerequisites

Ensure the following are installed before using this project:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (Version 8 or later)
- [JasperReports Library](https://community.jaspersoft.com/project/jasperreports-library)
- [NetBeans](https://netbeans.apache.org/) or any preferred IDE

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/lochan2005/Jasper-Report.git
   ```

2. Import the project into your preferred Java IDE.

3. Add the required JasperReports dependencies to your project.

## Usage

### 1. Generate and View Reports

The `Jasper` class provides multiple `viewReport` methods for generating and viewing reports. Below is an example of how to use them:

#### Example 1: Using `JTable` as a Data Source
```java
import java.util.HashMap;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperPrint;

public class Main {
    public static void main(String[] args) throws Exception {
        Jasper jasper = new Jasper();
        JTable table = new JTable(); // Populate table with your data
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("paramName", "paramValue");

        JasperPrint jasperPrint = jasper.viewReport("reportName.jasper", parameters, table);
    }
}
```

#### Example 2: Using a Database Connection
```java
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperPrint;

public class Main {
    public static void main(String[] args) throws Exception {
        Jasper jasper = new Jasper();
        Connection connection = // Obtain a database connection
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("paramName", "paramValue");

        JasperPrint jasperPrint = jasper.viewReport("reportName.jasper", parameters, connection);
    }
}
```

### 2. Export Reports

The `Jasper` class also provides methods for exporting reports to PDF and HTML formats.

#### Export to PDF
```java
jasper.exportReportPDF(jasperPrint, "output.pdf");
```

#### Export to HTML
```java
jasper.exportReportHTML(jasperPrint, "output.html");
```

## Project Structure

```
Jasper-Report/
├── lib/         # Libraries required for the project
├── src/         # Source code of the project
│   ├── Model/   # Contains the Jasper.java file
├── README.md    # Documentation file
```

## Author

**Lochana2005**

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

