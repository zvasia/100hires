import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.Remote;


//регистрация через job description лендинг

public class registrationJobDescr extends AbstractTest{

    @Test
    public void registrationJobDescr() throws InterruptedException {
        MainPage mpage = new MainPage(driver);
        driver.get(BASE_URL);

        //assert driver.getCurrentUrl().equals(BASE_URL);
        mpage.clickJobDescriptionLink();
        JobDescriptionPage jdescrpage = new JobDescriptionPage(driver);
        jdescrpage.cashierJobDescrClick();
        jdescrpage.postJobFreeBtnClick();
        NewJobPage newJobPage = new NewJobPage(driver);
        newJobPage.setJobFormNameField(" (Remote)");
        newJobPage.setJobLocationField("2147 Newhall Street, Santa Clara, CA, USA");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("div.pac-item")));
        newJobPage.setFirstLocationInList();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.
                id("postjobform-remote")));
        newJobPage.setRemoteFormJobCheckbox();
        newJobPage.vacancyDescrAddText("thank you!");
        newJobPage.setEmailForRegistrationField("xxasdas3d123e3sdfe4@test.com");
        newJobPage.publishBtnClick();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.
                id("fieldsform-first_name")));
        newJobPage.setFirstNameToSubmitJobField("Ivan");
        newJobPage.setLastNameToSubmitJobField("Ivanov");
        newJobPage.setCompanyNameField("ACME Group");
        newJobPage.setCompanySiteField("100hires.com");
        newJobPage.setPhoneField("123456789");
        newJobPage.pushNextTwo();
        new WebDriverWait(driver, 10).until((ExpectedConditions.urlContains("check-email")));
        String assertion = driver.findElement(By.cssSelector(".container > h1")).getText();
        assert assertion.equals("Almost done!");



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
