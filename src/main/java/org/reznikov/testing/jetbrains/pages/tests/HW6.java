package org.reznikov.testing.jetbrains.pages.tests;

import org.reznikov.testing.BaseWebDriverTest;
import org.reznikov.testing.jetbrains.pages.CreateAccount;
import org.reznikov.testing.jetbrains.pages.ForgotPassword;
import org.reznikov.testing.jetbrains.pages.JetBrainsMainPage;
import org.reznikov.testing.jetbrains.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HW6 extends BaseWebDriverTest {

    @Test
    public void testJetBrainsForgotPassw() {
        LoginPage page = new JetBrainsMainPage(driver).navigate().getLoginPage();
        page.forgotPassword();
        ForgotPassword forgotPage = new ForgotPassword(driver).enterEmail("test@mail.ru");
        //forgotPage.enterEmail("test@mail.ru");
        softAssert.assertTrue(forgotPage.getInfoMessage().contains("We'll send you instructions on how"));
        softAssert.assertAll();
    }

    @DataProvider(name = "accountProvider")
    public Object[][] accountProvider() {
        return new Object[][]{
                {"fname3", "lname3", "email17@mail.ru"},
                {"fname4", "lname4", "emai18@mail.ru"}
        };
    }

    @Test(dataProvider = "accountProvider")
    public void testJetBrainsRegisterAccount(String firstname, String lastname, String email) {
        LoginPage page = new JetBrainsMainPage(driver).navigate().getLoginPage();
        page.createAccount(firstname, lastname, email);
        CreateAccount createAccount = new CreateAccount(driver);
        softAssert.assertTrue(createAccount.getInfoMessageForRegisterAccount().contains("Thank you for registering your JetBrains Account!"));
        softAssert.assertAll();
    }
}
