package Loginned;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InsideSideMenu extends SideMenu {

    @FindBy(css = "a.settings-nav__item-link")
    List<WebElement> sideBarMenuItem;

    @Step
    public void insideMenuClick(String x){
        if (x.equalsIgnoreCase("Company"))
            sideBarMenuItem.get(0).click();
        else if (x.equalsIgnoreCase("User"))
            sideBarMenuItem.get(1).click();
        else if (x.equalsIgnoreCase("Team"))
            sideBarMenuItem.get(2).click();
        else if (x.equalsIgnoreCase("Integrations"))
            sideBarMenuItem.get(3).click();
        else if (x.equalsIgnoreCase("Message templates"))
            sideBarMenuItem.get(4).click();
        else if (x.equalsIgnoreCase("Profile fields"))
            sideBarMenuItem.get(5).click();
        else if (x.equalsIgnoreCase("Forms"))
            sideBarMenuItem.get(6).click();
        else if (x.equalsIgnoreCase("Evaluation forms"))
            sideBarMenuItem.get(7).click();
        else if (x.equalsIgnoreCase("Workflows"))
            sideBarMenuItem.get(8).click();
        else if (x.equalsIgnoreCase("Pipeline stages"))
            sideBarMenuItem.get(9).click();
        else if (x.equalsIgnoreCase("Tags"))
            sideBarMenuItem.get(10).click();
        else if (x.equalsIgnoreCase("Disqualification reasons"))
            sideBarMenuItem.get(11).click();
        else if (x.equalsIgnoreCase("Sources"))
            sideBarMenuItem.get(12).click();
        else if (x.equalsIgnoreCase("Departments"))
            sideBarMenuItem.get(13).click();
        else if (x.equalsIgnoreCase("Interviews titles"))
            sideBarMenuItem.get(14).click();
    }



    public InsideSideMenu(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
