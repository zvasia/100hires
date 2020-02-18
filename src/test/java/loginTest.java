import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class loginTest extends AbstractTest{

    private String login = "zvasia@gmail.com";
    private String password = "123Qwerty";
    private String jobname = "Software developer";
    private String location = "New York, NY, US";

    @Test
    public void jobCreationTest() throws InterruptedException {
        MainPage mpage = new MainPage(driver);
        driver.get(BASE_URL);

        String currentAdress = driver.getCurrentUrl();
        assertEquals(currentAdress, "https://100hires.com/");

        mpage.goToLoginPage();
        LoginPage lpage = new LoginPage(driver);
        lpage.setLoginField(login);
        lpage.setPasswordField(password);
        lpage.pushLoginBtn();

        SideMenu sideMenu = new SideMenu(driver);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector("span.fas.fa-file-alt.sidebar-menu__item-icon")));

        sideMenu.goToJobsPage();
        JobsPage jpage = new JobsPage(driver);
        jpage.pushAddJobBtn();

        System.out.println("It's create");
        NewJobPage newjob = new NewJobPage(driver);
        newjob.setJobNameField(jobname);
        newjob.setJobLocationField(location);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector(".pac-item")));
        newjob.setLocationInList();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("button.btn.btn-primary.btn-lg.btn-wide.submit-form")));
        newjob.pushSubmitBtn();

        ///
        System.out.println("It's applicant-form");
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector("a.btn.btn-primary.btn-lg.btn-wide")));
        newjob.pushNext();
        ///
        System.out.println("It's team");
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector("a.btn.btn-primary.btn-lg.btn-wide")));
        newjob.pushNext();

        ///
        System.out.println("It's evaluation");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("button.btn.btn-primary.btn-lg.btn-wide")));
        newjob.pushNextTwo();
        //
        System.out.println("It's workflow");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("a.btn.btn-primary.btn-lg.btn-wide")));
        newjob.goToOptionalStep();
        //
        System.out.println("It's Optionals");
        newjob.pushNextTwo();
        //
        System.out.println("Publish");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("a.btn.btn-primary.btn-lg.btn-wide")));
        newjob.goToOptionalStep();

    }

}
