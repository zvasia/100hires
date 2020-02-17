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

    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }










}
