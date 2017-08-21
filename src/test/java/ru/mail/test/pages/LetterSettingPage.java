package ru.mail.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

/**
 * Created by olga on 21.08.17.
 */
public class LetterSettingPage extends PageObject {
    @FindBy(id = "formMail")
    private WebElementFacade letterSettingsForm;

    @FindBy(id = "afterDelete0")
    private WebElementFacade goToNextLetterCheckbox;

    @FindBy(id = "afterDelete1")
    private WebElementFacade goToLettersListCheckbox;

    @FindBy(css = "#formMail button[type='submit']")
    private WebElementFacade saveButton;

    public void clickGoToNextLetterCheckbox() {
        goToNextLetterCheckbox.waitUntilClickable().click();
    }

    public void clickGoToLettersListCheckbox() {
        goToLettersListCheckbox.waitUntilClickable().click();
    }

    public void checkLetterSettingsPageOpened() {
        Assert.assertTrue("Не открыта страница 'Работа с письмами'", letterSettingsForm.waitUntilVisible().isCurrentlyVisible());
    }

    public void pressSaveBtn() {
        saveButton.waitUntilClickable().click();
    }




}
