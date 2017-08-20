package steps;

import pages.CommonElenentsPage;
import pages.LoginPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by olga on 19.08.17.
 */
public class PrepareSteps {

    LoginPage loginPage;
    CommonElenentsPage commonElenentsPage;

    @Step("Авторизация")
    public void login(String email,String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.pressEnterBtn();
    }

    @Step("Открытие страници настроек")
    public void openSettingsPage() {
        commonElenentsPage.pressEnterBtn();
        commonElenentsPage.pressSettingsBtn();
    }

}
