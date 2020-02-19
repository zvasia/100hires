import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewJobPage extends AbstractPage {

    //step 1

    @FindBy (id = "job-title")
    private WebElement jobNameField;

    public void setJobNameField(String jobName){
        jobNameField.sendKeys(jobName);
    }

    @FindBy (name = "job_location[full_address]")
    private WebElement jobLocationField;

    @FindBy (css = "div.pac-item") //span.pac-matched
    private WebElement locationLiElement;

    public void setJobLocationField(String location) {
        jobLocationField.sendKeys(location);
    }

    public void setFirstLocationInList(){
        locationLiElement.click();
    }

    @FindBy (id = "job-remote")
    private WebElement remoteJobCheckbox;

    public void setRemoteJobCheckbox() {
        remoteJobCheckbox.click();
    }

    @FindBy (css = "div.note-editable")
    private WebElement vacancyTextEditor;

    public void vacancyDescrAddText(String x){
        vacancyTextEditor.click();
        vacancyTextEditor.sendKeys(Keys.RETURN);
        vacancyTextEditor.sendKeys(Keys.RETURN);
        vacancyTextEditor.sendKeys(x);
    }

    @FindBy (css = "input#postjobform-email")
    private WebElement emailForRegistrationField;

    public void setEmailForRegistrationField(String x){
        emailForRegistrationField.sendKeys(x);
    }


    @FindBy (css = "button.btn.btn-primary.btn-lg.btn-wide.submit-form")
    private WebElement submitBtn;

    public void pushSubmitBtn() {
        submitBtn.click();
    }

    @FindBy (css = "a.btn.btn-primary.btn-lg.btn-wide")
    private WebElement nextBtn;

    public void pushNext(){

        nextBtn.click();
    }

    @FindBy (css = "button.btn.btn-primary.btn-lg.btn-wide")
    private WebElement nextBtnTwo;
    public void pushNextTwo(){
        nextBtnTwo.click();
    }

    @FindBy (css = "a.btn.btn-primary.btn-lg.btn-wide")
    private WebElement toOptionalStep;
    public void goToOptionalStep(){
        toOptionalStep.click();
    }

    @FindBy (css = "button.btn-primary")
    private WebElement publishBtn;

    public void publishBtnClick(){
        publishBtn.click();
    }

    ///job description registration

    @FindBy (id = "fieldsform-first_name")
    private WebElement firstNameToSubmitJobField;

    public void setFirstNameToSubmitJobField(String x){
        firstNameToSubmitJobField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-last_name")
    private WebElement lastNameToSubmitJobField;

    public void setLastNameToSubmitJobField(String x){
        lastNameToSubmitJobField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-company_name")
    private WebElement companyNameField;

    public void setCompanyNameField(String x){
        companyNameField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-web_site")
    private WebElement companySiteField;

    public void setCompanySiteField(String x){
        companySiteField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-web_site")
    private WebElement phoneField;

    public void setPhoneField(String x){
        phoneField.sendKeys(x);
    }

    @FindBy (id = "postjobform-title")
    private WebElement jobFormNameField;

    public void setJobFormNameField(String jobName){
        jobFormNameField.sendKeys(jobName);
    }

    @FindBy (id = "postjobform-remote")
    private WebElement remoteFormJobCheckbox;

    public void setRemoteFormJobCheckbox() {
        remoteFormJobCheckbox.click();
    }





    public NewJobPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
