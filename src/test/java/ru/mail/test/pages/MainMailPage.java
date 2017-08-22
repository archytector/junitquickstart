package ru.mail.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by olga on 19.08.17.
 */

public class MainMailPage extends PageObject {

    @FindBy(id = "b-letters")
    private WebElementFacade lettersInList;

    @FindBy(xpath = "//*[@class='b-letter__head__subj__text']")
    private WebElementFacade letterHeaderText;

    @FindBy(xpath = "//*[@id='b-toolbar__right']//div[3]//div[1]/span[text()='Удалить']")
    private WebElementFacade deleteButton;

    @FindBy(xpath = "//*[@id='b-toolbar__right']//div[3]//div[1]/span[text()='Ответить']")
    private WebElementFacade answerButton;

    private String letterHeader;

    public void checkMainMailPageOpened() {
        Assert.assertTrue("Не открыта страница со списком писем", lettersInList.waitUntilVisible().isCurrentlyVisible());
    }

    public void rememberLetterHeader(int letterNumber) {
        letterNumber++;
        letterHeader = lettersInList.findElement(By.cssSelector("div:nth-child(" + letterNumber + ") > div > a")).getAttribute("data-subject");

    }

    public void deleteLetter(int letterNumber) {
        lettersInList.findElement(By.cssSelector("div:nth-child(" + letterNumber + ")> div > a")).click();
        deleteButton.waitUntilClickable().click();
    }

    public void checkAfterDeleteOption(String option) {
        switch (option) {
            case "view next letter":
                waitFor(answerButton);
                Assert.assertEquals(letterHeader.replace(" ", ""), letterHeaderText.getText().replace(" ", ""));
                break;
            case "view list letters":
                checkMainMailPageOpened();
                break;
        }
    }


}
