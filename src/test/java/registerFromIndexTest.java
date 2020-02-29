import RegistrationPages.RegistrationPage;
import RegistrationPages.SetPasswordPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class registerFromIndexTest extends AbstractTest {


    @Test
    public void registerFromIndex(){
        MainPage mpage = new MainPage(driver);
        driver.get(BASE_URL);
        mpage.enterMail(randomEmail);
        mpage.clickGetStartedForFree();
        RegistrationPage rpage = new RegistrationPage(driver);
        getWait().until((ExpectedConditions.elementToBeClickable(By.
                cssSelector("div.col-sm-2.required"))));
        Assert.assertTrue("Адрес страницы https://app.100hires.com/auth/register не соответствует требованиям: "
                + driver.getCurrentUrl(), driver.getCurrentUrl().equals("https://app.100hires.com/auth/register"));
        rpage.setFirstName(firstName);
        rpage.setLastName(lastName);
        Assert.assertTrue("Адрес email не соответствует введенному в первоначальной заявке",
                driver.findElement(By.cssSelector("input#fieldsform-email")).
                getAttribute("value").equals(randomEmail));
        rpage.setCompanyName(companyName);
        rpage.setCompanySite(companySite);
        rpage.setPhoneField(phone);
        rpage.clickFinishBtn();
        getWait().until((ExpectedConditions.urlContains("check-email")));
        String assertion = driver.findElement(By.cssSelector(".container > h1")).getText();
        Assert.assertTrue("Перехода на страницу не произошло", assertion.equals("Almost done!"));
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

        getWait().until((ExpectedConditions.elementToBeClickable(By.
                cssSelector("span.mail-MessageSnippet-Item.mail-MessageSnippet-Item_subject"))));
        mcheck.openLastMail();

        getWait().until((ExpectedConditions.elementToBeClickable(By.
                cssSelector("a.daria-goto-anchor"))));
        mcheck.confirmMailLink();

        SetPasswordPage setpass = new SetPasswordPage(this.driver);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        getWait().until((ExpectedConditions.
                elementToBeClickable(By.cssSelector("button.btn-primary"))));
        setpass.setPassword(registrationPassword);
        setpass.setConfirmPassword(registrationPassword);
        setpass.clickSetPasswordBtn();

    }

}
