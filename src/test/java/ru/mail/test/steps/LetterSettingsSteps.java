package ru.mail.test.steps;

import net.thucydides.core.annotations.Step;
import ru.mail.test.pages.LetterSettingPage;

/**
 * Created by olga on 19.08.17.
 */
public class LetterSettingsSteps {

    LetterSettingPage letterSettingPage;

    @Step("Выбран читбокс 'Переходить к следующему письму'")
    public void chooseGoToNextLetterCheckbox() {
        letterSettingPage.clickGoToNextLetterCheckbox();
    }


    @Step("Выбран читбокс 'Переходить к списку писем'")
    public void chooseGoToLettersListCheckbox() {
        letterSettingPage.clickGoToLettersListCheckbox();
    }

    @Step("Изменения сохранены")
    public void saveChanges() {
        letterSettingPage.pressSaveBtn();
    }

}
