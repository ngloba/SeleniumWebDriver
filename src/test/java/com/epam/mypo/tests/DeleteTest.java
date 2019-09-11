package com.epam.mypo.tests;

import com.epam.mypo.HomePage;
import com.epam.mypo.InboxPage;
import org.testng.annotations.Test;

public class DeleteTest extends BaseTest {

    @Test
    public InboxPage deleteTest() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.fillLogin("nataliia.globa", "TestTest753");
        InboxPage inboxPage = homePage.pressLogin();



    }
}
