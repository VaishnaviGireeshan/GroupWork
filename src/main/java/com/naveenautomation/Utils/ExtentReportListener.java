package com.naveenautomation.Utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;

	public ExtentReports extent;

	public ExtentTest test;

	@Override
	public void onStart(ITestContext testContext) {

		String timeStamp = Utils.getCurrentDateTimeStamp();
		String repName = "My Account Portal " + " ------" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\Vishnu\\eclipse-workspace\\NaveenAutomationLab\\Extent Reports\\" + repName);
		// C:\Users\Vishnu\eclipse-workspace\NaveenAutomationLab
		htmlReporter.loadXMLConfig("C:\\Users\\Vishnu\\eclipse-workspace\\NaveenAutomationLab\\extent-config.xml");

		htmlReporter.config().setReportName("My Account Portal Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);// build and perform

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.WHITE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();//
	}

}
