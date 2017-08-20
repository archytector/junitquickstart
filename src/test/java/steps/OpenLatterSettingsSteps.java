package steps;

import pages.CommonElenentsPage;
import net.thucydides.core.annotations.Step;

/**
 * Created by olga on 19.08.17.
 */
public class OpenLatterSettingsSteps {

    CommonElenentsPage commonElenentsPage;

    @Step("Открытие страницу работы с письмами")
    public void openWorkWithLettersPage() {
        commonElenentsPage.pressEnterBtn();
        commonElenentsPage.pressSettingsBtn();
    }

}
