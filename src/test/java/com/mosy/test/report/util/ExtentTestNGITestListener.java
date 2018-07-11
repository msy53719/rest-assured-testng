package com.mosy.test.report.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestNGITestListener implements ITestListener {

	private static Logger logger = LoggerFactory.getLogger(ExtentTestNGITestListener.class);

	private static ExtentReports extent = ExtentManager.createInstance("jsandcss/ExtentReport.html");
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	public synchronized void onTestStart(ITestResult result) {
		ExtentTest child = parentTest.get()
				.createNode(result.getTestClass().getRealClass().getName() + "." + result.getMethod().getMethodName());
		test.set(child);
	}

	public synchronized void onTestSuccess(ITestResult result) {
		test.get().pass("Test passed");
	}

	public synchronized void onTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());
	}

	public synchronized void onTestSkipped(ITestResult result) {
		test.get().skip(result.getThrowable());
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public synchronized void onStart(ITestContext context) {
		ExtentTest parent = extent.createTest("Test");
		parentTest.set(parent);
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
