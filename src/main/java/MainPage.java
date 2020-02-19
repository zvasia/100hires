import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{

    @FindBy (className = "header__top__login")
    private WebElement toLoginPageButton;

    public void goToLoginPage(){
        toLoginPageButton.click();
    }


    // Footer
    @FindBy(xpath = "//a[contains(.,'Job Descriptions')]")
    private WebElement jobDescriptionLink;

    public void clickJobDescriptionLink(){
        jobDescriptionLink.click();
    }

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }










}
