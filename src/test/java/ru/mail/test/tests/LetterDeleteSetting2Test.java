package ru.mail.test.tests;


import net.thucydides.core.annotations.Title;
import org.junit.Test;
import ru.mail.test.utils.UserData;


/**
 * Created by olga on 19.08.17.
 */

public class LetterDeleteSetting2Test extends BaseLetterSettingsTest{

   @Test
    @Title("Проверка функциональности 'После удаления письма - Переходить к следующему письму'")
    public void checkDeleteLetterOptions3() throws InterruptedException {
        UserData.LoginPassword currentLoginPassword = UserData.EnumSingleton.INSTANCE.getNextLoginPassword();
        try {
            latterSettingsSteps.chooseGoToNextLetterCheckbox();
            latterSettingsSteps.saveChanges();
            checkLetterDeleteSettingsSteps.openMainMailPage();
            checkLetterDeleteSettingsSteps.deleteLetterNumber(1);
            checkLetterDeleteSettingsSteps.checkAfterDeleteViewNextLetter();
        } finally {
            UserData.EnumSingleton.INSTANCE.freeLoginPasword(currentLoginPassword);
        }
    }
}
