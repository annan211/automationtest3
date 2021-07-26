package com.aia.glory.id;

import com.aia.glory.id.utils.ExtentUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

public abstract class TestReports {

    private static ExtentReports extent;

    @BeforeClass
    public static void beforeClass() {
        String reportPath = "reports/glory/extent.html";
        extent = new ExtentReports(reportPath, false, NetworkMode.OFFLINE);
    }

    @Rule
    public ExtentUtils eu = new ExtentUtils(extent);

    @AfterClass
    public static void afterClass() {
        extent.close();
    }
}
