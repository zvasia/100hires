import AbstractPages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    @FindBy (id = "loginform-email")
    private WebElement loginField;

    @Step
    public void setLoginField(String login){
        loginField.sendKeys(login);
    }

    @FindBy (id = "loginform-password")
    private WebElement passwordField;

    @Step
    public void setPasswordField(String pass){
        passwordField.sendKeys(pass);
    }

    @FindBy (name = "login-button")
    private WebElement loginBtn;

    @Step
    public void pushLoginBtn(){
        loginBtn.click();
    }

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
