import Loginned.InsideSideMenu;
import Loginned.MyTasksPage;
import Loginned.SideMenu;
import RegistrationPages.InvitationSignUpPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class registerFromInvitationTest extends AbstractTest {

    @Test
    public void registerFromInvitation() throws InterruptedException {
        MainPage mpage = new MainPage(driver);
        driver.get(BASE_URL);

        String currentAdress = driver.getCurrentUrl();
        assertEquals(currentAdress, "https://100hires.com/");

        //login
        mpage.goToLoginPage();
        LoginPage lpage = new LoginPage(driver);
        lpage.setLoginField(login);
        lpage.setPasswordField(password);
        lpage.pushLoginBtn();

        //send invitation
        MyTasksPage mtpage = new MyTasksPage(driver);
        getWait().until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("a[href$=\"/team\"]")));

        SideMenu sideMenu = new SideMenu(driver);
        sideMenu.sideMenuClick("settings");

        InsideSideMenu sideMenu2 = new InsideSideMenu(driver);
        getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.settings-nav__item-link")));
        sideMenu2.insideMenuClick("team");



        InvitationPage invitepage = new InvitationPage(driver);
        getWait().until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("input.form-control")));
        invitepage.setEmail(randomEmail);
        invitepage.chooseRole("Reviewer"); // "Administrator", "Reviewer", "Internal recruiter"
        invitepage.invite();

        //open invitation link
        MailCheck mcheck = new MailCheck(driver);
        driver.get(mailIndex);
        getWait().until((ExpectedConditions.elementToBeClickable(By.
                cssSelector("label.passp-form-field__label"))));
        mcheck.setMailLogin();

        getWait().until((ExpectedConditions.elementToBeClickable(By.
                id("passp-field-passwd"))));
        mcheck.setPass();

        /* if (new WebDriverWait(driver, 5).until(ExpectedConditions.
                elementToBeClickable(By.cssSelector("button.button2_theme_normal"))) == true);
            mcheck.notNowClick(); */

        getWait().until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("span.mail-MessageSnippet-Item.mail-MessageSnippet-Item_subject")));
        mcheck.openLastMail();

        getWait().until((ExpectedConditions.elementToBeClickable(By.
                cssSelector("a.daria-goto-anchor"))));
        mcheck.confirmMailLink();

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        //fill in sign up form
        InvitationSignUpPage invSignUpPage = new InvitationSignUpPage(this.driver);
        getWait().until(ExpectedConditions.
                elementToBeClickable(By.cssSelector("button.btn")));
        invSignUpPage.setFirstName(firstName);
        invSignUpPage.setLastName(lastName);
        invSignUpPage.setPhone(phone);
        Assert.assertEquals("Отображается неверный email", invSignUpPage.getEnteredMail(), randomEmail);
        invSignUpPage.signUpClick();

    }

}
