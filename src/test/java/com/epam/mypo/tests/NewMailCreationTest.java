package com.epam.mypo.tests;

import com.epam.mypo.DraftPage;
import com.epam.mypo.HomePage;
import com.epam.mypo.InboxPage;
import com.epam.mypo.NewMailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewMailCreationTest extends BaseTest {

    @Test
    public void newMailCreationTest (){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.fillLogin("nataliia.globa", "TestTest753");
        InboxPage inboxPage = homePage.pressLogin();
        NewMailPage newMailPage = inboxPage.clickOnNewMailButton();
        newMailPage.newMailCreation("nataliia.globa@mail.ru", "Page Object mail");
        newMailPage.saveNewMailToDraft();
        DraftPage draftPage = inboxPage.clickOnDraftFolder();
        String result = draftPage.getSubjectFromDraft();
        Assert.assertTrue(result.equals("Page Object mail"));


    }
}
