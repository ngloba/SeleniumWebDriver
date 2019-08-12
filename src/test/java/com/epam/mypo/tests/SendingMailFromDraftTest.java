package com.epam.mypo.tests;

import com.epam.mypo.DraftPage;
import com.epam.mypo.HomePage;
import com.epam.mypo.InboxPage;
import com.epam.mypo.SentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendingMailFromDraftTest extends BaseTest {

    @Test
    public void sendingMailFromDraftTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.fillLogin("nataliia.globa", "TestTest753");
        InboxPage inboxPage = homePage.pressLogin();
        DraftPage draftPage = inboxPage.clickOnDraftFolder();
        String subjectBefore = draftPage.getSubjectFromDraft();
        draftPage.sendingMailFromDraft();
        SentPage sentPage = inboxPage.clickOnSentFolder();
        String subjectAfter = sentPage.getSubjectFromSent();
        Assert.assertEquals(subjectAfter,subjectBefore);

    }
}
