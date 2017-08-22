package ru.mail.test.steps;

import net.thucydides.core.annotations.Step;
import ru.mail.test.pages.CommonElementsPage;
import ru.mail.test.pages.LetterSettingPage;
import ru.mail.test.pages.LoginPage;
import ru.mail.test.pages.SettingsPage;

/**
 * Created by olga on 19.08.17.
 */
public class PrepareSteps {

    LoginPage loginPage;
    CommonElementsPage commonElementsPage;
    SettingsPage settingsPage;
    LetterSettingPage letterSettingPage;

    @Step("Авторизация")
    public void login(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.pressEnterBtn();
    }

    @Step("Открыта страница настроек")
    public void openSettingsPage() {
        commonElementsPage.pressEnterBtn();
        commonElementsPage.pressSettingsBtn();
        settingsPage.checkSettingsPageOpened();
    }

    @Step("Открыта страница 'Работа с письмами'")
    public void openLetterSettingsPage() {
        settingsPage.pressWorkWithLettersBtn();
        letterSettingPage.checkLetterSettingsPageOpened();
    }

}
