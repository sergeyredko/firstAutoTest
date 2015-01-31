package com.autotesting.framework.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.log4j.Logger;

import com.autotesting.framework.screens.MailBaseScreen;

public class Photographer {
    private static String SNAPSHOTS_FOLDER = "test-output/snapshot";
    protected final static Logger log = Logger.getLogger(Photographer.class);

    public static String getSnapshotName(String driverCommand) {
        File folder = new File(SNAPSHOTS_FOLDER);
        if (!folder.exists()) {
            try {
                folder.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String timestamp = nowAsString("yyyyMMdd_HHmmss");
        return folder.getAbsolutePath() + "/" + timestamp + "_" + driverCommand;
    }

    private static String nowAsString(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }

    public static void doScreenshot(String caseName) {
        String filename = getSnapshotName(caseName) + ".png";
        File scrFile = ((TakesScreenshot)WebDriverRunner.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(filename));
        } catch (IOException e) {
            log.error(String.format("Error copy screenshot file from %s to %s",
                    scrFile.getAbsolutePath(), filename));
        }
    }
}
