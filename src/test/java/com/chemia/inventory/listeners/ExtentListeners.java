package com.chemia.inventory.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentListeners implements ITestListener  {
	
	private static final String OUTPUT_FOLDER = System.getProperty("user.dir")+"/reports/";
	//private static final String FILE_NAME = "TestExecutionReport_"+getTodaysDateTime()+".html";
	private static final String FILE_NAME = "LIETestExecutionReport.html";
	private static ExtentReports extent = init();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	private static ExtentReports extentReports;

	private static ExtentReports init() {
		Path path = Paths.get(OUTPUT_FOLDER);
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		extentReports = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
		reporter.config().setReportName("Lab Inventory and Equipment_5.1");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("System", "Windows");
		extentReports.setSystemInfo("Author", "Obulesh");
		extentReports.setSystemInfo("Build#", "5.1.1");
		extentReports.setSystemInfo("Team", "TVG");
		return extentReports;
	}

	public void onStart(ITestContext context) {
		System.out.println("Test Suite started!");

	}
	
	public void onFinish(ITestContext context) {
		System.out.println(("Test Suite is ending!"));
		extent.flush();
		test.remove();
		try {
			Desktop.getDesktop().browse(new File(OUTPUT_FOLDER + FILE_NAME).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName()
				//,result.getMethod().getDescription()
				);
		test.set(extentTest);
		test.get().getModel().setStartTime(getTime(result.getStartMillis()));
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " Passed!"));
		String methodName = result.getMethod().getMethodName();
		//test.get().log(Status.PASS, result.getMethod().getMethodName());
		test.get().pass(result.getThrowable(), MediaEntityBuilder
				.createScreenCaptureFromPath(ScreenshotClass.getScreenshot(methodName), methodName).build());
		//test.get().addScreenCaptureFromBase64String(DriverFactory.getBase64Screenshot());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		String methodName = result.getMethod().getMethodName();
		test.get().log(Status.FAIL, methodName);
		test.get().log(Status.FAIL,result.getThrowable());
		//test.get().addScreenCaptureFromBase64String(BaseClass.getBase64Screenshot());
		test.get().fail(result.getThrowable(), MediaEntityBuilder
				.createScreenCaptureFromPath(ScreenshotClass.getScreenshot(methodName), methodName).build());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " Skipped!"));
		String methodName = result.getMethod().getMethodName();
		test.get().log(Status.SKIP, methodName);
		test.get().log(Status.SKIP,result.getThrowable());
		test.get().skip(result.getThrowable(), MediaEntityBuilder
				.createScreenCaptureFromPath(ScreenshotClass.getScreenshot(methodName), methodName).build());
 		
		//test.get().addScreenCaptureFromBase64String(DriverFactory.getBase64Screenshot());
		test.get().getModel().setEndTime(getTime(result.getEndMillis()));
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	
	public static String getTodaysDateTime() {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		LocalDateTime dateNow = LocalDateTime.now();
		return dateNow.format(date).toString();
	}
		
 
	//fail->skip->warning->pass->info


}
