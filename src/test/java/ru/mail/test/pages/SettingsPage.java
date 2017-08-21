package ru.mail.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

/**
 * Created by olga on 19.08.17.
 */

public class SettingsPage extends PageObject {

    @FindBy(id = "content-index")
    private WebElementFacade allSettingsMenu;

    @FindBy(xpath = ".//*[@id='content-index']//div[text()='Работа с письмами']")
    private WebElementFacade workWithLettersItem;

    public void pressWorkWithLettersBtn() {
        workWithLettersItem.waitUntilClickable().click();
    }

    public void checkSettingsPageOpened() {
        Assert.assertTrue("Не открыта страница 'Настройки'", allSettingsMenu.isCurrentlyVisible());
    }


}
