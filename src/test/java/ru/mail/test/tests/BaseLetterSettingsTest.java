package ru.mail.test.tests;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import ru.mail.test.steps.CheckLetterDeleteSettingsSteps;
import ru.mail.test.steps.LetterSettingsSteps;
import ru.mail.test.steps.PrepareSteps;


/**
 * Created by olga on 19.08.17.
 */
//@RunWith(SerenityRunner.class)
public class BaseLetterSettingsTest {

    @Steps
    private PrepareSteps prepareSteps;
    @Steps
    private LetterSettingsSteps latterSettingsSteps;
    @Steps
    private CheckLetterDeleteSettingsSteps checkLetterDeleteSettingsSteps;



}
