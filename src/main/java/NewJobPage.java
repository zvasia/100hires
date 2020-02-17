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

    @FindBy (css = "span.pac-matched")
    private WebElement locationLiElement;

    public void setJobLocationField(String location) {
        jobLocationField.sendKeys(location);
    }

    public void setLocationInList(){
        locationLiElement.click();
        //jobLocationField.sendKeys(Keys.RETURN);
    }

    @FindBy (id = "job-remote")
    private WebElement remoteJobCheckbox;

    public void setRemoteJobCheckbox() {
        remoteJobCheckbox.click();
    }

    @FindBy (css = "button.btn.btn-primary.btn-lg.btn-wide.submit-form")
    private WebElement submitBtn;

    public void pushSubmitBtn() {
        submitBtn.click();
    }

    // step 2

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



    public NewJobPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
