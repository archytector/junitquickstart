package ru.mail.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by olga on 19.08.17.
 */
public class CommonElenentsPage extends PageObject {
    //Элементы верхнего меню, которое есть на каждой странице

    @FindBy(id="portal-menu")
    private WebElementFacade portalMainMenu;

    @FindBy(xpath="//*[@id='portal-menu']//span[text()='Ещё']")
    private WebElementFacade moreToolbarButton;

    @FindBy(xpath=".//*[@id='portal-menu']//a/span[text()='Настройки']")
    private WebElementFacade settingsToolbarItem;

    @FindBy(xpath="//*[@id='portal-menu']//span[text()='Письма']")
    private WebElementFacade lettersToolbarButton;


    public void pressEnterBtn() {
        moreToolbarButton.waitUntilClickable().click();
    }

    public void pressSettingsBtn() {
        settingsToolbarItem.waitUntilClickable().click();
    }

    public void pressLetterBtn() {
        lettersToolbarButton.waitUntilClickable().click();
    }



}
