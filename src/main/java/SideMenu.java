import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenu extends AbstractPage {
    @FindBy(css = "span.fas.fa-file-alt.sidebar-menu__item-icon")
    private WebElement jobSideMenuLink;

    public void goToJobsPage(){
        jobSideMenuLink.click();
    }

    public SideMenu(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
