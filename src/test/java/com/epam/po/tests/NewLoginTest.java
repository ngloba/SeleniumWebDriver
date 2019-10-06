package com.epam.po.tests;

import com.epam.po.NewHomePage;
import com.epam.po.NewInboxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTest extends NewBaseTest {

    @Test
    public void loginTest () {

        NewHomePage newHomePage = new NewHomePage(driver);
        newHomePage.open();
        newHomePage.fillLogin("autotester@mailbox.org", "TestTest753!");
        newHomePage.pressLogin();
        String result = newHomePage.gettingContact();
        Assert.assertEquals(result, "autotester@mailbox.org");



    }
}
