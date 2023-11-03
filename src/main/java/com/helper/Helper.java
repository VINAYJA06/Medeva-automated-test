package com.helper;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;

/*import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;*/

public class Helper {

    private static final int T_SLEEP_ROBOT_TY = 200;
    private static final String ASC = "Asc";
    private static final String DESC = "Desc";
    private static final String DATE_PATTERN = "dd-MM-yyyy";
    private static final String LAST_DATE = "12-12-3000";
    private static final String FIRST_DATE = "00-00-0000";
    public Duration waitInSecs = Duration.ofSeconds(15);
    public Duration waitInMilliSecs = Duration.ofMillis(100);
    private static WebDriver driver;
    private int sleepShort = 2500;
    private int sleepMedium = 5000;
    private int sleepDlLong = 10000;
    private JavascriptExecutor javaScriptExecutor;
    private WebDriver webDriver = null;
    private static WebDriverWait wait = null;
    private static final String CLICK_ON_ELEMENT = "arguments[0].click();";
    private static final String SCROLL_TO_ELEMENT = "arguments[0].scrollIntoView();";
    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public Helper(WebDriver driver, String className) {
        this.webDriver = driver;
        javaScriptExecutor = (JavascriptExecutor) driver;
        wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofMillis(100)).ignoring(StaleElementReferenceException.class);
    }

    public Helper() {
    }

    public static void clickOnElement(WebElement element) {
        isElementPresent(wait, element);
        try {
            element.click();
        } catch (ElementClickInterceptedException ecie) {
            try {
                element.click();
            } catch (ElementClickInterceptedException ece) {
                element.sendKeys(Keys.ENTER);
            }
            ecie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getTextOfElement(WebElement element) {
        Helper.Logger("Text of the {}");
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void scrollToElement(WebElement element) {
        javaScriptExecutor.executeScript(SCROLL_TO_ELEMENT, element);

    }

//    public static WebElement waitForElement(WebDriverWait waits,WebElement element) {
////        return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
//        try {
//            waits.until(ExpectedConditions.visibilityOf(element));
//        } catch (NoSuchElementException | TimeoutException ignored) {
//            System.out.println("Element not found");
//            Assert.fail();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return element;
//    }

    public static void isElementPresent(WebDriverWait wait, WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException | TimeoutException ignored) {
            System.out.println("Element not found");
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendKeysToElement(WebElement element, String keyToSend) {
        isElementPresent(wait, element);
        element.clear();
        element.sendKeys(keyToSend);
    }

//    public static void sendKeysToElement(WebElement element, String textToSend) {
//        waitForElement(wait,element).sendKeys(Keys.chord(Keys.CONTROL, "a"));
//        waitForElement(wait,element).sendKeys(Keys.BACK_SPACE);
//        wait.until((ExpectedCondition<Boolean>) waitForEmptyField -> element.getAttribute("value").equalsIgnoreCase(""));
//        waitForElement(wait,element).sendKeys(textToSend);
//        log.info("Sent text: {} to field", textToSend);
//    }

    public static void sleep(int timeToSleep) {
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void dragAndDrop(WebElement from, WebElement to){
        Actions act=new Actions(driver);
        act.dragAndDrop(from, to).build().perform();
    }

    public static String getLocalTime() {
        Calendar calder = Calendar.getInstance();
        System.out.println(calder.getTime());
        return calder.getTime().toString();
    }

    public String replaceNull(String input) {
        return input == null ? "" : input;
    }

    public static void assertSingleFieldVal(String expected, String actual) {
        try {
            if (expected.equals(actual)) {
                System.out.println("\nExpected:\t" + expected + "\nActual:\t\t" + actual);
            } else {
                System.out.println("\nExpected:\t" + expected + "\nActual:\t\t" + actual);
            }
            Assert.assertEquals(expected, actual);
            System.out.println("Matched!");
        } catch (AssertionError ae) {
            System.out.println("Assertion error has occurred: " + ae);
            Assert.fail();
        }
    }

    public static void assertSingleFieldValidation(boolean expected, boolean actual) {
        try {
            System.out.println("\nExpected:\t" + expected + "\nActual:\t\t" + actual);
            Assert.assertEquals(expected, actual);
            System.out.println("Matched!");
        } catch (AssertionError ae) {
            System.out.println("Assertion error has occurred: " + ae);
            Assert.fail();
        }
    }

    public void assertStringContains(String expected, String actual) {
        try {
            System.out.println("\nExpected:\t" + expected + "\nActual:\t\t" + actual);
            Assert.assertThat(actual, containsString(expected));
            System.out.println("Matched!");
        } catch (AssertionError ae) {
            System.out.println("Assertion error has occurred: " + ae);
            Assert.fail();
        }
    }

    public void assertFieldsVal(String[][] validations) {
        ArrayList<Boolean> matched = new ArrayList<>();

        for (int i = 0; i < validations[0].length; i++) {
            try {
                System.out.println("\nExpected:\t" + validations[0][i] + "\nActual:\t\t" + validations[1][i]);
                matched.add(validations[0][i].equals(validations[1][i]));
                Assert.assertEquals(validations[0][i], validations[1][i]);
                System.out.println("Matched!");
            } catch (AssertionError ae) {
                System.out.println("Assertion error has occurred: " + ae);
            }
        }

        for (boolean s : matched) {
            if (!s) {
                System.out.println("\nFields did not match");
                Assert.fail();
            }
        }
    }

    public static void returnColumnData(List<WebElement> element) {
        ArrayList<String> listColumnData = new ArrayList<>();
        for (WebElement s : element) {
            listColumnData.add(s.getText());
        }
        System.out.println(listColumnData);
    }

    public static void captureScreenshot(WebDriver driver) throws IOException {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "E:\\Medeva Automation WorkSpace\\Screenshots\\";

            File destinationPath = new File(path + "SS" + System.currentTimeMillis() + ".png");
            FileUtils.copyFile(screenshot, destinationPath);
            System.out.println("Screenshot Taken");
        } catch (Exception e) {
            System.out.println("screenshot error\n " + e);
        }
    }

    public static void takeScreenShot() {
        try {
            DateTimeFormatter formatForDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDateTime now = LocalDateTime.now();
            String folderDate = formatForDateTime.format(now);

            int num = 0;
            String ext = ".png";
            String fileName;
            String directoryForScreenshots;
            fileName = "SS" + "testName"/*NAME.getMethodName()*/ + ext;
            directoryForScreenshots = "src/test/screenshot" + "/" + folderDate;
            new File(directoryForScreenshots).mkdirs();
            File myFile = new File(directoryForScreenshots, fileName);
            while (myFile.exists())
            {
                fileName = "SS" + "testName"/*NAME.getMethodName()*/ + (num++) + ".png";
                myFile = new File(directoryForScreenshots, fileName);
            }
            FileOutputStream out = new FileOutputStream(myFile);
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
            System.out.println("Screenshot Taken");
        } catch (Exception e) {
            System.out.println("screenshot error\n " + e);
        }
    }

    public int lastStringIntoArraySplit(String paginatorString) {
        String[] arrayPagSplitTxt = paginatorString.split(" ");
        int getStringlenght = arrayPagSplitTxt.length - 1;
        System.out.println("\nNumber of Rows Returned: " + arrayPagSplitTxt[getStringlenght] + "\n");
        return Integer.parseInt(arrayPagSplitTxt[getStringlenght]);
    }

    public int noRowReturned(int paginatorInt) {
        if (paginatorInt > 10) {
            paginatorInt = 10;
        }
        return paginatorInt;
    }

    public String getAscOrderTxt() {
        return ASC;
    }

    public String getDescOrderTxt() {
        return DESC;
    }

    public int getSleepShort() {
        return sleepShort;
    }

    public int getSleepMedium() {
        return sleepMedium;
    }

    public int getSleepDlLong() {
        return sleepDlLong;
    }

    public void compareAlphabeticalOrder(ArrayList<String> list, String order) {
        String ascPrevious = "";
        String descPrevious = "zzzz";
        switch (order) {
            case "Asc":
                for (String current : list) {
                    if (current.compareTo(ascPrevious) < 0) {
                        System.out.println("Wrong order:\t" + current);
                        takeScreenShot();
                        Assert.fail();
                    } else {
                        ascPrevious = current;
                        System.out.println("Asc order:\t\t" + ascPrevious);
                    }
                }
                System.out.println("");
                break;
            case "Desc":
                for (String current : list) {
                    if (current.compareTo(descPrevious) > 0) {
                        System.out.println("Wrong order:\t" + current);
                        takeScreenShot();
                        Assert.fail();
                    } else {
                        descPrevious = current;
                        System.out.println("Desc order:\t\t" + descPrevious);
                    }
                }
                break;

        }

    }

    /**
     * compares dates in Asc/Desc order Asc - compare the 1st date in list to an older date Desc -
     * compare 1st date to the current date then compare the next date in list to the previous
     */
    public void compareDateOrder(ArrayList<String> list, String order) throws ParseException {
        String ascPrevious = FIRST_DATE;
        DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        //descPrevious for desc order can be a future date
        String descPrevious = LAST_DATE;//dateFormat.format(new Date());
        switch (order) {
            case "Asc":
                for (String dateStr : list) {
                    if (dateFormat.parse(dateStr).compareTo(dateFormat.parse(ascPrevious)) < 0) {
                        System.out.println("Wrong order:\t" + dateStr);
                        takeScreenShot();
                        Assert.fail();
                    } else {
                        ascPrevious = dateStr;
                        System.out.println("Asc order:\t\t" + ascPrevious);
                    }
                }
                break;
            case "Desc":
                for (String dateStr : list) {
                    if (dateFormat.parse(dateStr).compareTo(dateFormat.parse(descPrevious)) > 0) {
                        System.out.println("Wrong order:\t" + dateStr);
                        takeScreenShot();
                        Assert.fail();
                    } else {
                        descPrevious = dateStr;
                        System.out.println("Desc order:\t\t" + descPrevious);
                    }
                }
                break;

        }

    }

    /**
     * keyboard key press press a key on the keyboard example enter key escape key etc...
     */
    public void keyboardKeyPress(int keyEvent) {
        try {
            Robot T1000 = new Robot();
            T1000.keyPress(keyEvent);
            T1000.delay(T_SLEEP_ROBOT_TY);
            T1000.keyRelease(keyEvent);
        } catch (AWTException e) {
            System.out.println("keypress error " + e);
            Assert.fail();
        }
    }

    public File lastFileModified(String dir) {
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        });

        long lastMod = Long.MIN_VALUE;
        File choice = null;
        for (File file : files) {
            if (file.lastModified() > lastMod) {
                choice = file;
                lastMod = file.lastModified();
            }
        }
        return choice;
    }
    public static void Logger(String logger) {
//        private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
//        Logger log = Logger.getLogger(LoginSteps.class.getName());
        Logger log =  LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
      log.info(logger);
    }

}
