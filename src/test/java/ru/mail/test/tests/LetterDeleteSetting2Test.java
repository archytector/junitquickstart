package ru.mail.test.tests;


import net.thucydides.core.annotations.Title;
import org.junit.Test;
import ru.mail.test.utils.UserDataService;


/**
 * Created by olga on 19.08.17.
 */
public class LetterDeleteSetting2Test extends TestBase {

    @Test
    @Title("Проверка функциональности 'После удаления письма - Переходить к следующему письму'")
    public void checkDeleteLetterOptions3() throws InterruptedException {
            latterSettingsSteps.chooseGoToNextLetterCheckbox();
            latterSettingsSteps.saveChanges();
            checkLetterDeleteSettingsSteps.openMainMailPage();
            checkLetterDeleteSettingsSteps.deleteLetterNumber(1);
            checkLetterDeleteSettingsSteps.checkAfterDeleteViewNextLetter();}

}
