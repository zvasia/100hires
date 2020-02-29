import AbstractPages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    @FindBy (className = "header__top__login")
    private WebElement toLoginPageButton;

    @Step
    public void goToLoginPage(){
        toLoginPageButton.click();
    }

    @FindBy (id = "emailform-email")
    private WebElement emailField;

    @Step
    public void enterMail(String x){
        emailField.sendKeys(x);
    }

    @FindBy (css = "button.btn.btn-lg.btn-purple.signup-form__submit")
    private WebElement getStartedForFree;

    @Step
    public void clickGetStartedForFree(){
        getStartedForFree.click();
    }


    // Footer
    @FindBy(xpath = "//a[contains(.,'Job Descriptions')]")
    private WebElement jobDescriptionLink;

    @Step
    public void clickJobDescriptionLink(){
        jobDescriptionLink.click();
    }

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }










}
