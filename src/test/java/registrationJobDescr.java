import Loginned.NewJobPage;
import RegistrationPages.SetPasswordPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


//регистрация через job description лендинг

public class registrationJobDescr extends AbstractTest{

    @Test
    public void registrationJobDescr() throws InterruptedException {
        MainPage mpage = new MainPage(driver);
        driver.get(BASE_URL);

        mpage.clickJobDescriptionLink();
        JobDescriptionPage jdescrpage = new JobDescriptionPage(driver);
        jdescrpage.cashierJobDescrClick();
        jdescrpage.postJobFreeBtnClick();
        NewJobPage newJobPage = new NewJobPage(driver);
        newJobPage.setJobFormNameField(" (Remote)");
        newJobPage.setJobLocationField("2147 Newhall Street, Santa Clara, CA, USA");
        getWait().until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("div.pac-item")));
        newJobPage.setFirstLocationInList();
        getWait().until(ExpectedConditions.elementToBeClickable(By.
                id("postjobform-remote")));
        newJobPage.setRemoteFormJobCheckbox();
        newJobPage.vacancyDescrAddText("thank you!");
        newJobPage.setEmailForRegistrationField(randomEmail);
        newJobPage.publishBtnClick();
        getWait().until(ExpectedConditions.elementToBeClickable(By.
                id("fieldsform-first_name")));
        newJobPage.setFirstNameToSubmitJobField(firstName);
        newJobPage.setLastNameToSubmitJobField(lastName);
        Assert.assertTrue("Email не соответствует введенному ранее",
                driver.findElement(By.cssSelector("input#fieldsform-email")).
                getAttribute("value").equals(randomEmail));
        newJobPage.setCompanyNameField(companyName);
        newJobPage.setCompanySiteField(companySite);
        newJobPage.setPhoneField(phone);
        newJobPage.pushNextTwo();
        getWait().until((ExpectedConditions.urlContains("check-email")));
        String assertion = driver.findElement(By.cssSelector(".container > h1")).getText();
        Assert.assertTrue("Заголовок на странице не соответствует требованию",
                assertion.equals("Almost done!"));

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
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        getWait().until((ExpectedConditions.
                elementToBeClickable(By.cssSelector("button.btn-primary"))));
        setpass.setPassword(registrationPassword);
        setpass.setConfirmPassword(registrationPassword);
        setpass.clickSetPasswordBtn();



        /*
            на открывшейся странице дописываю в job title " (Remote)"
            в поле Job location вписываю "2147 Newhall Street, Santa Clara, CA, USA"
            кликаю по первой рекомендации из выпадающего списка google maps автокомплиттера
            кликаю по чекбоксу Remote
            в textarea с джоб дескрипшеном добавляю с новой строки текст "thank you!"
            в поле Email вписываю существующий незарегистрированный email
            кликаю по большой фиолетовой кнопке
            на следующей странице ввожу в поле First name: Ivan
            ввожу в поле Last name: Ivanov
            ввожу Company name: ACME Group
            ввожу Company website or Facebook page: 100hires.com
            ввожу Phone: 123456789
            нажимаю кнопку Finish
            проверяю на следующей странице наличие надписи: Almost done!
            перехожу, в почту, открываю письмо, кликаю по ссылке из письма
             на странице ввода пароля ввожу пароль и его подтверждение: 12345678
          кликаю на кнопку с текстом Set password */
    }
}
