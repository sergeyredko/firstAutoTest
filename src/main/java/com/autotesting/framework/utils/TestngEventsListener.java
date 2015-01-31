package com.autotesting.framework.utils;

import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class TestngEventsListener implements ITestListener,IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        handleFailure(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    private void handleFailure(ITestResult result) {
        if (WebDriverRunner.getDriver() != null) {
            String caseName = getCaseName(result);
            Photographer.doScreenshot(caseName);
        }
    }

    private String getCaseName(ITestResult result) {
        return result.getTestClass().getRealClass().getSimpleName() + "."  + result.getMethod().getMethodName();
    }
}
