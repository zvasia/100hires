import Loginned.JobsPage;
import Loginned.NewJobPage;
import Loginned.SideMenu;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class createJobTest extends AbstractTest{

    private String jobname = "Java developer";
    private String newQuestion = "New question";

    @Test
    public void createJobTest(){
        MainPage mpage = new MainPage(driver);
        driver.get(BASE_URL);

        String currentAdress = driver.getCurrentUrl();
        Assert.assertTrue("Страница недоступна", driver.getCurrentUrl().equals("https://100hires.com/"));

        mpage.goToLoginPage();
        LoginPage lpage = new LoginPage(driver);
        lpage.setLoginField(login);
        lpage.setPasswordField(password);
        lpage.pushLoginBtn();

        SideMenu sideMenu = new SideMenu(driver);
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector("span.fas.fa-file-alt.sidebar-menu__item-icon")));

        sideMenu.sideMenuClick("jobs");
        JobsPage jpage = new JobsPage(driver);

        jpage.pushAddJobBtn();

        //new job
        NewJobPage newjob = new NewJobPage(driver);
        newjob.setJobNameField(jobname);
        newjob.setJobLocationField(location);
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.
                cssSelector(".pac-item")));
        newjob.setFirstLocationInList();
        getWait().until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("button.btn.btn-primary.btn-lg.btn-wide.submit-form")));
        newjob.vacancyDescrAddText("thank you!");
        newjob.pushSubmitBtn();

        //Application

        newjob.addQuestion(0, driver);
        newjob.addCustomQuestion(newQuestion);
        /* todo меняю порядок вопросов - переношу New question с последнего на предпоследнее место
обновляю страницу, проверяю, что New question на предпоследнем месте и со статусом Required */


    }


}
/*
залогинившись из левого сайдбар меню кликаю по ссылке Jobs
на открывшейся странице кликаю по кнопке с текстом Add job
в Job title ввожу Java developer
в поле Job location вписываю "2147 Newhall Street, Santa Clara, CA, USA"
в textarea с джоб дескрипшеном добавляю с новой строки текст "thank you!"
кликаю по большой кнопке c текстом Next

на открывшейся странице в дропдауне Add question добавляю стандартный вопрос Zip code
в дропдауне Add question добавляю новый нестандартный вопрос New question
меняю ему статус с Optional на Required
меняю порядок вопросов - переношу New question с последнего на предпоследнее место
обновляю страницу, проверяю, что New question на предпоследнем месте и со статусом Required
кликаю по большой кнопке c текстом Next

на открывшейся странице в поле email ввожу существующий неиспользованный email
меняю в дропдауне статус на Reviewer
кликаю на кнопку Invite
проверяю, что пришлашенный email отобразился в списке на этой странице
кликаю по большой кнопке c текстом Next

на следующей странице в дропдауне Add question добавляю новый нестандартный вопрос New evaluation question
меняю ему статус с Optional на Required
меняю порядок вопросов - переношу New evaluation question с последнего на предпоследнее место
обновляю страницу, проверяю, что New evaluation question на предпоследнем месте и со статусом Required
кликаю по большой кнопке c текстом Next
на следующей странице в дропдауне Add pipeline stage добавляю новый нестандартный New pipeline stage
меняю порядок cтейджей - переношу New pipeline stage с последнего на предпоследнее место
обновляю страницу, проверяю, что New pipeline stage на предпоследнем месте
кликаю по большой кнопке c текстом Next
заполняю все поля в открывшейся вкладке Optional
кликаю по большой кнопке c текстом Next
на вкладке Publish меняю в дропдауне статус джобы на Public
в дропдауне Trackable link добавляю новый нестандартный New source
проверяю что добавился для этого сорса trackable link
кликаю по большой кнопке c текстом Save
проверяю, что происходит переход на pipeline view этой джобы
в левом нижнем углу фиолетового сайдбара перехожу по ссылке Career site
проверяю, что появилась ссылка на страницу этой новой джобы
 */