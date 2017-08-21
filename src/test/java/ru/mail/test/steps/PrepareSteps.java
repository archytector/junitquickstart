package ru.mail.test.steps;

import org.junit.Assert;
import ru.mail.test.pages.CommonElenentsPage;
import ru.mail.test.pages.LetterSettingPage;
import ru.mail.test.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import ru.mail.test.pages.SettingsPage;

/**
 * Created by olga on 19.08.17.
 */
public class PrepareSteps {

    LoginPage loginPage;
    CommonElenentsPage commonElenentsPage;
    SettingsPage settingsPage;
    LetterSettingPage letterSettingPage;

    @Step("Авторизация")
    public void login(String email,String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.pressEnterBtn();
    }

    @Step("Открытие страницы настроек")
    public void openSettingsPage() {
        commonElenentsPage.pressEnterBtn();
        commonElenentsPage.pressSettingsBtn();
        settingsPage.checkSettingsPageOpened();
    }

    @Step("Открытие страницы Работа с письмами")
    public void openLetterSettingsPage() {
        settingsPage.pressWorkWithLettersBtn();

    }

}
