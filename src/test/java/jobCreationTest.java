import Loginned.JobsPage;
import Loginned.NewJobPage;
import Loginned.SideMenu;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jobCreationTest extends AbstractTest{


    private String jobname = "Software developer";

    @Test
    public void jobCreationTest() throws Exception {

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
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector("span.fas.fa-file-alt.sidebar-menu__item-icon")));

        sideMenu.sideMenuClick("jobs");
        JobsPage jpage = new JobsPage(driver);
        jpage.pushAddJobBtn();

        NewJobPage newjob = new NewJobPage(driver);
        newjob.setJobNameField(jobname);
        newjob.setJobLocationField(location);
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector(".pac-item")));
        newjob.setFirstLocationInList();
        getWait().until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("button.btn.btn-primary.btn-lg.btn-wide.submit-form")));
        newjob.pushSubmitBtn();

        ///
        System.out.println("It's applicant-form");
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector("a.btn.btn-primary.btn-lg.btn-wide")));
        newjob.pushNext();
        ///
        System.out.println("It's team");
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector("a.btn.btn-primary.btn-lg.btn-wide")));
        newjob.pushNext();

        ///
        System.out.println("It's evaluation");
        getWait().until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("button.btn.btn-primary.btn-lg.btn-wide")));;
        newjob.pushNextTwo();
        //
        System.out.println("It's workflow");
        getWait().until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("a.btn.btn-primary.btn-lg.btn-wide")));
        newjob.goToOptionalStep();
        //
        System.out.println("It's Optionals");
        newjob.pushNextTwo();
        //
        System.out.println("Publish");
        getWait().until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("a.btn.btn-primary.btn-lg.btn-wide")));
        newjob.goToOptionalStep();

    }

}
