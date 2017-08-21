package ru.mail.test.steps;

import ru.mail.test.pages.CommonElenentsPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by olga on 19.08.17.
 */
public class LatterSettingsSteps {

    CommonElenentsPage commonElenentsPage;

    @Step("Открытие страницу работы с письмами")
    public void openWorkWithLettersPage() {
        commonElenentsPage.pressEnterBtn();
        commonElenentsPage.pressSettingsBtn();
    }



}
