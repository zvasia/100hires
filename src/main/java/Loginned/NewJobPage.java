package Loginned;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewJobPage extends SideMenu {

    //step 1

    @FindBy (id = "job-title")
    private WebElement jobNameField;

    @Step
    public void setJobNameField(String jobName){
        jobNameField.sendKeys(jobName);
    }

    @FindBy (name = "job_location[full_address]")
    private WebElement jobLocationField;

    @FindBy (css = "div.pac-item") //span.pac-matched
    private WebElement locationLiElement;

    @Step
    public void setJobLocationField(String location) {
        jobLocationField.sendKeys(location);
    }

    @Step
    public void setFirstLocationInList(){
        locationLiElement.click();
    }

    @FindBy (id = "job-remote")
    private WebElement remoteJobCheckbox;

    @Step
    public void setRemoteJobCheckbox() {
        remoteJobCheckbox.click();
    }

    @FindBy (css = "div.note-editable")
    private WebElement vacancyTextEditor;

    @Step
    public void vacancyDescrAddText(String x){
        vacancyTextEditor.click();
        vacancyTextEditor.sendKeys(Keys.RETURN);
        vacancyTextEditor.sendKeys(Keys.RETURN);
        vacancyTextEditor.sendKeys(x);
    }

    @FindBy (css = "input#postjobform-email")
    private WebElement emailForRegistrationField;

    @Step
    public void setEmailForRegistrationField(String x){
        emailForRegistrationField.sendKeys(x);
    }


    @FindBy (css = "button.btn.btn-primary.btn-lg.btn-wide.submit-form")
    private WebElement submitBtn;

    @Step
    public void pushSubmitBtn() {
        submitBtn.click();
    }

    @FindBy (css = "a.btn.btn-primary.btn-lg.btn-wide")
    private WebElement nextBtn;

    @Step
    public void pushNext(){

        nextBtn.click();
    }

    @FindBy (css = "button.btn.btn-primary.btn-lg.btn-wide")
    private WebElement nextBtnTwo;

    @Step
    public void pushNextTwo(){
        nextBtnTwo.click();
    }

    @FindBy (css = "a.btn.btn-primary.btn-lg.btn-wide")
    private WebElement toOptionalStep;

    @Step
    public void goToOptionalStep(){
        toOptionalStep.click();
    }

    @FindBy (css = "button.btn-primary")
    private WebElement publishBtn;

    @Step
    public void publishBtnClick(){
        publishBtn.click();
    }
///Application


    @FindBy (css = ".question-autocomplete > input")
    private WebElement addQuestion;

    @FindBy (css = "li.question-autocomplete-options__item:nth-child(1)")
    private WebElement zipCode;

    @FindBy (css = "li.question-autocomplete-options__item")
    private List<WebElement> addQuestionList;

    @FindBy (css = "button.foxy-question-header__status-btn")
    private List<WebElement> statusList;

    @FindBy (css = "div.question-autocomplete-options__add:nth-child(1)")
    private WebElement addNewCustomQuestion;

    //@FindBy (css = "div.foxy-question:nth-child(" +  + " ) > div:nth-child(2) > div:nth-child(2) > ul")
    private List<WebElement> statusDefaultQuestionsList;

    @Step
    public void addQuestion(int x, WebDriver driver){
        addQuestion.click();
        addQuestionList.get(x).click();
    }

    @Step
    public void addCustomQuestion(String s){
        addQuestion.sendKeys(s);
        addNewCustomQuestion.click();
    }

    @Step
    public int questionPos(String x){
        //todo
        return 0;
    }

    @Step
    public void changeQuestionStatus(String s, int x){

    }




    ///job description registration

    @FindBy (id = "fieldsform-first_name")
    private WebElement firstNameToSubmitJobField;

    @Step
    public void setFirstNameToSubmitJobField(String x){
        firstNameToSubmitJobField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-last_name")
    private WebElement lastNameToSubmitJobField;

    @Step
    public void setLastNameToSubmitJobField(String x){
        lastNameToSubmitJobField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-company_name")
    private WebElement companyNameField;

    @Step
    public void setCompanyNameField(String x){
        companyNameField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-web_site")
    private WebElement companySiteField;

    @Step
    public void setCompanySiteField(String x){
        companySiteField.sendKeys(x);
    }

    @FindBy (id = "fieldsform-phone")
    private WebElement phoneField;

    @Step
    public void setPhoneField(String x){
        phoneField.sendKeys(x);
    }

    @FindBy (id = "postjobform-title")
    private WebElement jobFormNameField;

    @Step
    public void setJobFormNameField(String jobName){
        jobFormNameField.sendKeys(jobName);
    }

    @FindBy (id = "postjobform-remote")
    private WebElement remoteFormJobCheckbox;

    @Step
    public void setRemoteFormJobCheckbox() {
        remoteFormJobCheckbox.click();
    }


    public NewJobPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
