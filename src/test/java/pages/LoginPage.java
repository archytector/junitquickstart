package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by olga on 19.08.17.
 */
@DefaultUrl("https://mail.ru")
public class LoginPage extends PageObject {

    @FindBy(id="mailbox__login")
    private WebElementFacade email;

    @FindBy(id="mailbox__password")
    private WebElementFacade password;

    @FindBy(id="mailbox__auth__button")
    private WebElementFacade enterBtn;


    public void enterEmail(String emailFromFile) {
        email.waitUntilVisible().clear();
        email.sendKeys(emailFromFile);
    }

    public void enterPassword(String passwordFromFile) {
        password.waitUntilVisible().clear();
        password.sendKeys(passwordFromFile);
    }

    public void pressEnterBtn() {
        enterBtn.waitUntilClickable().click();
    }
}
