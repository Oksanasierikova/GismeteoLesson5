package org.reznikov.testing;

import org.reznikov.testing.BaseWebDriverTest;
import org.reznikov.testing.jetbrains.pages.JetBrainsMainPage;
import org.reznikov.testing.jetbrains.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HW6 extends BaseWebDriverTest {

    @Test
    public void testJetBrainsForgotPassw() {
        LoginPage page = new JetBrainsMainPage(driver).navigate().getLoginPage();
        page.forgotPassword();
        page.enterEmail("test@mail.ru");
        softAssert.assertTrue(page.getInfoMessage().contains("We'll send you instructions on how"));
        softAssert.assertAll();
    }

    @DataProvider(name = "accountProvider")
    public Object[][] accountProvider() {
        return new Object[][]{
                {"fname1", "lname1", "email5@mail.ru"},
                {"fname2", "lname2", "email6@mail.ru"}
        };
    }

    @Test(dataProvider = "accountProvider")
    public void testJetBrainsRegisterAccount(String firstname, String lastname, String email) {
        LoginPage page = new JetBrainsMainPage(driver).navigate().getLoginPage();
        page.createAccount(firstname, lastname, email);
        softAssert.assertTrue(page.getInfoMessage().contains("Thank you for registering your JetBrains Account!"));
        softAssert.assertAll();
    }
}
