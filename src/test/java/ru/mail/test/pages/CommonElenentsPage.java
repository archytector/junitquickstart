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

    @FindBy(xpath="//*[@id='portal-menu']//span//span[text()='Ещё']")
    private WebElementFacade moreBtn;

    @FindBy(xpath=".//*[@id='portal-menu']//span[11]//span[text()='Настройки']")
    private WebElementFacade settingsBtn;

    @FindBy(css="span[role='button'] span[text='Письма']")
    private WebElementFacade lettersBtn;

    @FindBy(name="Accept_Terms_of_Use")
    private WebElementFacade termsofuseChb;

    public void pressEnterBtn() {
        moreBtn.waitUntilClickable().click();
    }

    public void pressSettingsBtn() {
        settingsBtn.waitUntilClickable().click();
    }

}
