package ru.mail.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by olga on 19.08.17.
 */

public class LoginPage extends PageObject {

    @FindBy(id="mailbox__login")
    private WebElementFacade loginInput;

    @FindBy(id="mailbox__password")
    private WebElementFacade passwordInput;

    @FindBy(id="mailbox__auth__button")
    private WebElementFacade authButton;


    public void enterEmail(String emailFromFile) {
        loginInput.waitUntilVisible().clear();
        loginInput.sendKeys(emailFromFile);
    }

    public void enterPassword(String passwordFromFile) {
        passwordInput.waitUntilVisible().clear();
        passwordInput.sendKeys(passwordFromFile);
    }

    public void pressEnterBtn() {
        authButton.waitUntilClickable().click();
    }
}
