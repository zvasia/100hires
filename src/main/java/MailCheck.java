import AbstractPages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class MailCheck extends AbstractPage {

    public static String charsForMail = "abcdefghijklmnopqrstyuxyz";
    private String mailLogin = "for-trash@trytopic.com";
    private String mailPass = "va8EKbZybJMNh";
    private static String mailIndex = "https://passport.yandex.ru/auth?from=mail&origin=hostroot_homer_auth_ru" +
            "&retpath=https%3A%2F%2Fmail.yandex.ru%2F&backpath=https%3A%2F%2Fmail.yandex.ru%3Fnoretpath%3D1";



    public static String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }


    //passport.yandex.ru
    @FindBy (id = "passp-field-login")
    private WebElement mailLoginField;

    @FindBy (css = "div.passp-button.passp-sign-in-button")
    private WebElement enterBtn;

    @Step
    public void setMailLogin(){
        mailLoginField.sendKeys(mailLogin);
        enterBtn.click();
    }

    @FindBy (id = "passp-field-passwd")
    private WebElement passField;

    @Step
    public void setPass(){
        passField.sendKeys(mailPass);
        enterBtn.click();
    }

    @FindBy (css = "button.button2_theme_normal")
    private WebElement notNowBtn;

    @Step
    public void notNowClick(){
        notNowBtn.click();
    }

    @FindBy (css = "span.mail-MessageSnippet-Item.mail-MessageSnippet-Item_subject")
    private WebElement lastMail;

    @Step
    public void openLastMail(){
        lastMail.click();
    }

    @FindBy (css = "a.daria-goto-anchor")
    private WebElement emailConfirmationLink;

    @Step
    public void confirmMailLink(){
        emailConfirmationLink.click();
    }








    public MailCheck(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
