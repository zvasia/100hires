import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTasksPage extends AbstractPage {
    @FindBy (xpath = "//a[contains(@text,'Create a job')]")
    private WebElement createJobLink;

    public void CreateJob(){
        createJobLink.click();
    }



    public MyTasksPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
