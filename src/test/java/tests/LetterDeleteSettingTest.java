package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.PrepareSteps;


/**
 * Created by olga on 19.08.17.
 */
@RunWith(SerenityRunner.class)
public class LetterDeleteSettingTest {

    @Managed()
    public WebDriver webdriver;
    @Steps
    public PrepareSteps prepareSteps;
    String email;
    //UserData.LoginPassword currentLoginPassword;
    String password;

    @Before
    public void prepareData() {
        webdriver.get("https://mail.ru");
        email = "emili_k@bk.ru";
        password = "18101964Olga";
    }

    @Test
    @Title("Проверка функциональности После удаления письма - Переходить к следующему письму")
    public void edit_lastname() {
    }

    @Test
    @Title("Проверка функциональности После удаления письма - Переходить к следующему письму")
    public void edit_lastname2() {
        prepareSteps.login(email, password);
    }


}
