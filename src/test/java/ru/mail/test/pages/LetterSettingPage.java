package ru.mail.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

/**
 * Created by olga on 21.08.17.
 */
public class LetterSettingPage extends PageObject{
    @FindBy(css = "#formMail")
    private WebElementFacade letterSettingsForm;


    public void checkLetterSettingsPageOpened() {
        Assert.assertTrue("Не открыта страница 'Настройки'", letterSettingsForm.isCurrentlyVisible());
    }
}
