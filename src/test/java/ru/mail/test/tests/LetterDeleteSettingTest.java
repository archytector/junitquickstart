package ru.mail.test.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ru.mail.test.steps.CheckLetterDeleteSettingsSteps;
import ru.mail.test.steps.LetterSettingsSteps;
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
    @Steps
    private LetterSettingsSteps latterSettingsSteps;
    @Steps
    private CheckLetterDeleteSettingsSteps checkLetterDeleteSettingsSteps;



    @Test
    @Title("Проверка функциональности 'После удаления письма - Переходить к следующему письму'")
    public void checkDeleteLetterOptions1() throws InterruptedException {
        UserData.LoginPassword currentLoginPassword = UserData.EnumSingleton.INSTANCE.getNextLoginPassword();
        try {

            webdriver.get("https://mail.ru");
            prepareSteps.login(currentLoginPassword.getLogin(), currentLoginPassword.getPassword());
            prepareSteps.openSettingsPage();
            prepareSteps.openLetterSettingsPage();

            latterSettingsSteps.chooseGoToNextLetterCheckbox();
            latterSettingsSteps.saveChanges();

            checkLetterDeleteSettingsSteps.openMainMailPage();
            checkLetterDeleteSettingsSteps.deleteLetterNumber(1);
            checkLetterDeleteSettingsSteps.checkAfterDeleteViewNextLetter();

        } finally {
            UserData.EnumSingleton.INSTANCE.freeLoginPasword(currentLoginPassword);
        }
    }

    @Test
    @Title("Проверка функциональности 'После удаления письма - Переходить к списку писем'")
    public void checkDeleteLetterOptions2() throws InterruptedException {
        UserData.LoginPassword currentLoginPassword = UserData.EnumSingleton.INSTANCE.getNextLoginPassword();
        try {
            webdriver.get("https://mail.ru");
            prepareSteps.login(currentLoginPassword.getLogin(), currentLoginPassword.getPassword());
            prepareSteps.openSettingsPage();
            prepareSteps.openLetterSettingsPage();

            latterSettingsSteps.chooseGoToLettersListCheckbox();
            latterSettingsSteps.saveChanges();

            checkLetterDeleteSettingsSteps.openMainMailPage();
            checkLetterDeleteSettingsSteps.deleteLetterNumber(1);
            checkLetterDeleteSettingsSteps.checkAfterDeleteViewLettersList();

        } finally {
            UserData.EnumSingleton.INSTANCE.freeLoginPasword(currentLoginPassword);
        }
    }


}
