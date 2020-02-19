import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobDescriptionPage extends AbstractPage {
    @FindBy (css = "div.decription-item")
    private WebElement cashierJobDescr;

    public void cashierJobDescrClick(){
        cashierJobDescr.click();
    }


    //job descr detail page

    @FindBy (css = "div.post-btn")
    private WebElement postJobFreeBtn;

    public void postJobFreeBtnClick(){
        postJobFreeBtn.click();
    }

    public JobDescriptionPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
