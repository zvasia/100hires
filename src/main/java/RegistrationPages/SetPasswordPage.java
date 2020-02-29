package RegistrationPages;

import AbstractPages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SetPasswordPage extends AbstractPage {


    @FindBy (id = "setpassword-password")
    private WebElement passwordField;

    public void setPassword(String x) {
        passwordField.sendKeys(x);
    }

    @FindBy (id = "setpassword-confirm_password")
    private WebElement confirmPasswordField;

    public void setConfirmPassword(String x){
        confirmPasswordField.sendKeys(x);
    }

    @FindBy (css = "button.btn-primary")
    private WebElement setPasswordBtn;

    public void clickSetPasswordBtn() {
        setPasswordBtn.click();
    }

    public SetPasswordPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
