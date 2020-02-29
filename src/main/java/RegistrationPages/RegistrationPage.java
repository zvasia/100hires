package RegistrationPages;

import AbstractPages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends AbstractPage {

    @FindBy (id = "fieldsform-first_name")
    private WebElement firstNameField;

    public void setFirstName(String x){
        firstNameField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-last_name")
    private WebElement lastNameField;

    public void setLastName(String x){
        lastNameField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-company_name")
    private WebElement companyNameField;

    public void setCompanyName(String x){
        companyNameField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-web_site")
    private WebElement companySiteField;

    public void setCompanySite(String x){
        companySiteField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-phone")
    private WebElement phoneField;

    public void setPhoneField(String x){
        phoneField.sendKeys(x);
    }

    @FindBy (css = "button.btn.btn-primary.btn-lg.btn-wide")
    private WebElement finishButton;

    public void clickFinishBtn(){
        finishButton.click();
    }




    public RegistrationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
