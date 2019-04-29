package com.epam.mail.tests;

import com.epam.mail.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MailFromSentFolderTest extends BaseTest {

    @Test
    public void mailInsentFolderTest () {
        login("nataliia.globa", "TestTest753");
        clickOnSentFolder();
        String result = getSubject().getAttribute("title");
        String newMailSubject = "New Test Mail 5";
        Assert.assertEquals(newMailSubject, result);
    }
}
