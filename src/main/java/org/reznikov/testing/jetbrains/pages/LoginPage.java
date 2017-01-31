package org.reznikov.testing.jetbrains.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends JetBrainsMainPage {

    private static final String USER_ID = "username";
    private static final String PASSWORD_ID = "//*[@type='password']";
    private static final String SUBMIT_BUTTON = ".login-submit-btn";
    private static final String ERROR_LOCATOR = ".alert-danger";
    private static final String FORGOT_PASS = "//a[@class='btn']";
    private static final String FNAME_ID = "//input[@placeholder='First Name']";
    private static final String LNAME_ID = "//input[@placeholder='Last Name']";
    private static final String EMAIL = "//input[@id='email']";
    private static final String SUBMIT_BUTTON2 = "//button[contains(@class, 'eml-submit-btn')]";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LogIn logIn(String user, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(USER_ID))).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSWORD_ID))).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SUBMIT_BUTTON))).click();
        return new LogIn(driver);
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ERROR_LOCATOR))).getText();
    }

    public ForgotPassword forgotPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FORGOT_PASS))).click();
        wait.until(ExpectedConditions.urlToBe("https://account.jetbrains.com/forgot-password"));
        return new ForgotPassword(driver);
    }

    public CreateAccount createAccount(String firstname, String lastname, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FNAME_ID))).sendKeys(firstname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LNAME_ID))).sendKeys(lastname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBMIT_BUTTON2))).click();
        return  new CreateAccount(driver);
    }


}
