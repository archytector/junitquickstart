package ru.mail.test.steps;

import net.thucydides.core.annotations.Step;
import ru.mail.test.pages.CommonElementsPage;
import ru.mail.test.pages.MainMailPage;

/**
 * Created by olga on 21.08.17.
 */
public class CheckLetterDeleteSettingsSteps {

    CommonElementsPage commonElementsPage;
    MainMailPage mainMailPage;

    @Step("Переход на страницу со списком писем")
    public void openMainMailPage() {
        commonElementsPage.pressLetterBtn();
        mainMailPage.checkMainMailPageOpened();
    }

    @Step("Удаление письма")
    public void deleteLetterNumber(int letterNumber) {
        mainMailPage.rememberLetterHeader(letterNumber);
        mainMailPage.deleteLetter(letterNumber);
    }

    @Step("Проверяет, что после удаления происходит переход к следующему письму")
    public void checkAfterDeleteViewNextLetter() {
        mainMailPage.checkAfterDeleteOption("view next letter");
    }

    @Step("Проверяет, что после удаления происходит переход к списку писем")
    public void checkAfterDeleteViewLettersList() {
        mainMailPage.checkAfterDeleteOption("view list letters");
    }
}
