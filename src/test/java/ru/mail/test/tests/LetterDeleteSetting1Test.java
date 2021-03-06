package ru.mail.test.tests;

import net.thucydides.core.annotations.Title;
import org.junit.Test;


/**
 * Created by olga on 19.08.17.
 */

public class LetterDeleteSetting1Test extends TestBase {

    @Test
    @Title("Проверка функциональности 'После удаления письма - Переходить к списку писем'")
    public void checkDeleteLetterOptions2() throws InterruptedException {
        latterSettingsSteps.chooseGoToLettersListCheckbox();
        latterSettingsSteps.saveChanges();
        checkLetterDeleteSettingsSteps.openMainMailPage();
        checkLetterDeleteSettingsSteps.deleteLetterNumber(1);
        checkLetterDeleteSettingsSteps.checkAfterDeleteViewLettersList();
    }
}
