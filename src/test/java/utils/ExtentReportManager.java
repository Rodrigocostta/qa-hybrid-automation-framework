package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    private ExtentReportManager() {
    }

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter = new ExtentSparkReporter(
                    "target/reports/extent-report.html");

            extent = new ExtentReports();

            extent.attachReporter(reporter);
        }

        return extent;
    }

}