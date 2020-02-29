import AbstractPages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InvitationPage extends AbstractPage {

    @FindBy (css = "input.invite-form__email")
    private WebElement emailField;

    @Step
    public void setEmail(String x){
        emailField.sendKeys(x);
    }

    @FindBy (css = "button.invite-form__role")
    private WebElement roleDropdown;

    @FindBy (css = "li.foxy-dropdown-list__item")
    List<WebElement> rolesList;

    @Step
    public void chooseRole(String x){
        if (x.equalsIgnoreCase("Internal recruiter")){
            roleDropdown.click();
            rolesList.get(1).click();
        }
        else if(x.equalsIgnoreCase("Reviewer")){
            roleDropdown.click();
            rolesList.get(2).click();
        }
        else if (x.equalsIgnoreCase("administrator")){
        }
    }

    @FindBy (css = "button.invite-form__btn-invite")
    private WebElement inviteBtn;

    @Step
    public void invite(){
        inviteBtn.click();
    }

    public InvitationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
