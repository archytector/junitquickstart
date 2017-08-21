package ru.mail.test.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ru.mail.test.steps.PrepareSteps;
import ru.mail.test.utils.UserData;


/**
 * Created by olga on 19.08.17.
 */
@RunWith(SerenityRunner.class)
public class LetterDeleteSettingTest {

    @Managed()
    private WebDriver webdriver;
    @Steps
    private PrepareSteps prepareSteps;

    @Before
    public void prepareData() {
        webdriver.get("https://mail.ru");
    }

    @Test
    @Title("Проверка функциональности После удаления письма - Переходить к следующему письму")
    public void checkDeleteLetterOptions() throws InterruptedException {
        UserData.LoginPassword currentLoginPassword = UserData.EnumSingleton.INSTANCE.getNextLoginPassword();
        try {
            prepareSteps.login(currentLoginPassword.getLogin(), currentLoginPassword.getPassword());
            prepareSteps.openSettingsPage();
            prepareSteps.openLetterSettingsPage();
        } finally {
            UserData.EnumSingleton.INSTANCE.freeLoginPasword(currentLoginPassword);
        }
    }


}
