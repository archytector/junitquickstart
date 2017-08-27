package ru.mail.test.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ru.mail.test.steps.CheckLetterDeleteSettingsSteps;
import ru.mail.test.steps.LetterSettingsSteps;
import ru.mail.test.steps.PrepareSteps;
import ru.mail.test.utils.Constants;
import ru.mail.test.utils.UserData;

import java.io.IOException;


/**
 * Created by olga on 19.08.17.
 */
@RunWith(SerenityRunner.class)
public class TestBase {

    @Managed(uniqueSession = true)
    protected WebDriver webdriver;

    @Steps
    protected PrepareSteps prepareSteps;
    @Steps
    protected LetterSettingsSteps latterSettingsSteps;
    @Steps
    protected CheckLetterDeleteSettingsSteps checkLetterDeleteSettingsSteps;

    UserData.LoginPassword currentLoginPassword;

    @Before
    public void prepareData() throws InterruptedException, IOException {
        String baseUrl = Constants.BASE_URL;
        webdriver.get(baseUrl);
        currentLoginPassword = UserData.EnumSingleton.INSTANCE.getNextLoginPassword();
        prepareSteps.login(currentLoginPassword.getLogin(), currentLoginPassword.getPassword());
        prepareSteps.openSettingsPage();
        prepareSteps.openLetterSettingsPage();
    }



    @After
    public void stopDriver() {
        webdriver.quit();
        UserData.EnumSingleton.INSTANCE.freeLoginPasword(currentLoginPassword);
    }


}
