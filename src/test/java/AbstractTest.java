import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;

import java.nio.file.Files;
import java.util.Date;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Random;


public abstract class AbstractTest {
    public WebDriver driver;
    private static final String STORAGE_PATH = "//TestRun//";

    public static Random rand = new Random();
    public static String randomEmail = MailCheck.
            generateString(rand, MailCheck.charsForMail, 7) + "@trytopic.com";
    public static String BASE_URL = "http://100hires.com";
    public static String companyName = "ACME Group";
    public static String location = "2147 Newhall Street, Santa Clara, CA, USA";
    public static String firstName = "Ivan";
    public static String lastName = "Ivanov";
    public static String companySite = "100hires.com";
    public static String phone = "123456789";
    public static String mailIndex = "https://passport.yandex.ru/auth?from=mail&origin=hostroot_homer_auth_ru" +
            "&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fmail.yandex.ru%3Fnoretpath%3D1";
    public static String registrationPassword = "1234";
    public String login = "zvasia@gmail.com";
    public String password = "123Qwerty";

    @Rule
    public TestWatcher watcher = new TestWatcher() {
         @Override
        protected void finished(Description description) {
            super.finished(description);
            tearDown();

        }

        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
            String filename = (new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")).format(new Date());
            Logger.getLogger(description.getTestClass()).
                    error("Exception on page " + driver.getCurrentUrl(), e);
            Logger.getLogger(description.getTestClass()).info("Screenshot saved as " + filename + ".png");
            takeScreenshot(filename);
        }
    };

    private static String screenPath = null;

    private void takeScreenshot(String filename) throws RuntimeException {
        try {
            String path = Paths.get("").toAbsolutePath().toString() + "//" +
                    STORAGE_PATH + this.getClass().getSimpleName() + "";
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            screenPath = path + filename + ".png";
            FileUtils.copyFile(scrFile, new File(screenPath));


        } catch (IOException e) {
            throw new RuntimeException("Не могу сохранить скриншот", e);
        }
    }
    @Attachment
    public static byte[] allureScrn() throws IOException {
        return Files.readAllBytes(Paths.get(screenPath));
    }

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }



 /*   public void setUp() throws Exception {
        this.driver = DriverInit.getDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(BASE_URL);
    } */



    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected WebDriverWait getWait() {
        return new WebDriverWait(this.driver, 20);
    }

}

