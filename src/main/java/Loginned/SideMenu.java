package Loginned;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractPages.AbstractPage;
import java.util.ArrayList;
import java.util.List;

public class SideMenu extends AbstractPage {



    @FindBy (css = "li.sidebar-menu__item")
    List<WebElement> sideBarMenuItem;
    @Step
    public void sideMenuClick(String x){
        if (x.equalsIgnoreCase("candidates"))
            sideBarMenuItem.get(0).click();
        else if (x.equalsIgnoreCase("jobs"))
            sideBarMenuItem.get(1).click();
        else if (x.equalsIgnoreCase("mailbox"))
            sideBarMenuItem.get(2).click();
        else if (x.equalsIgnoreCase("tasks"))
            sideBarMenuItem.get(3).click();
        else if (x.equalsIgnoreCase("settings"))
            sideBarMenuItem.get(4).click();
        else if (x.equalsIgnoreCase("career site"))
            sideBarMenuItem.get(5).click();
        else if (x.equalsIgnoreCase("collapse menu"))
            sideBarMenuItem.get(6).click();
    }

    @FindBy(css = "span.fas.fa-file-alt.sidebar-menu__item-icon")
    private WebElement jobSideMenuLink;

    @Step
    public void goToJobsPage(){
        jobSideMenuLink.click();
    }

    public SideMenu(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
