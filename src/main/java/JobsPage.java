import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobsPage extends SideMenu {

    @FindBy (css = "a.btn.btn-lg.btn-primary.btn-wide")
    private WebElement addJobBtn;

    public void pushAddJobBtn(){
        addJobBtn.click();
    }



    public JobsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
