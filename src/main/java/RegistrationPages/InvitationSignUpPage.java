package RegistrationPages;

import AbstractPages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvitationSignUpPage extends AbstractPage {
    @FindBy (id = "minisignupform-first_name")
    private WebElement firstNameField;

    public void setFirstName(String x){
        firstNameField.sendKeys(x);
    }

    @FindBy (id = "minisignupform-last_name")
    private WebElement lastNameField;

    public void setLastName(String x){
        lastNameField.sendKeys(x);
    }

    @FindBy (id = "minisignupform-email")
    private WebElement emailField;

    public String getEnteredMail(){
        return emailField.getAttribute("value");
    }

    @FindBy (id = "minisignupform-phone")
    private WebElement phoneField;

    public void setPhone(String x){
        phoneField.sendKeys(x);
    }

    @FindBy (css = "button.btn")
    private WebElement signUpBtn;

    public void signUpClick(){
        signUpBtn.click();
    }

    public InvitationSignUpPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
