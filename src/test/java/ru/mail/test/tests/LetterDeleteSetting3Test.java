package ru.mail.test.tests;

import net.thucydides.core.annotations.Title;
import org.junit.Test;
import ru.mail.test.utils.UserData;


/**
 * Created by olga on 19.08.17.
 */

public class LetterDeleteSetting3Test extends BaseLetterSettings {

    @Test
    @Title("Проверка функциональности 'После удаления письма - Переходить к списку писем'")
    public void checkDeleteLetterOptions3() throws InterruptedException {
        UserData.LoginPassword currentLoginPassword = UserData.EnumSingleton.INSTANCE.getNextLoginPassword();
        try {
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
