package com.naveenautomation.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomation.base.TestBase;

public class CustomListener extends TestBase implements ITestListener {
	/*
	 * in all of this tc's for result of the test case u are running testNg will
	 * automatically do the configuration and it will fetch you the result inside
	 * the result object
	 */
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("*******************Test case started*******************");
		logger.info("-----------------" + result.getMethod().getMethodName() + "-----------------");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("*******************Test case Passed*******************");
		logger.info("-----------------" + result.getMethod().getMethodName() + "-----------------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("!!!!!!!!!!!!!!!!!!Test case failed!!!!!!!!!!!!!!!!!!");
		logger.info("-----------------" + result.getMethod().getMethodName() + ",Taking Screenshot-----------------");

		Utils.failedTestScreenShot(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("???????????????????Test case Skipped???????????????????");
		logger.info("-----------------" + result.getMethod().getMethodName() + "-----------------");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
