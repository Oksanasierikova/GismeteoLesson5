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
    private static final String ENTER_EMAIL = "//input[contains(@class, 'form-control')]";
    private static final String SUBMIT_BTN = "//button[contains(@class, 'btn')]";
    private static final String ALLERT_INFO = "//div[contains(@class, 'alert')]";
    private static final String FNAME_ID = "//input[@placeholder='First Name']";
    private static final String LNAME_ID = "//input[@placeholder='Last Name']";
    private static final String EMAIL = "//input[@id='email']";
    private static final String SUBMIT_BUTTON2 = "//button[contains(@class, 'eml-submit-btn')]";
    private static final String ACCOUNT_INFO = "//div[contains(@class, 'alert-success')]";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(String user, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(USER_ID))).sendKeys(user);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSWORD_ID))).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SUBMIT_BUTTON))).click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(ERROR_LOCATOR)))
                .getText();
    }

    public void forgotPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FORGOT_PASS))).click();
        wait.until(ExpectedConditions.urlToBe("https://account.jetbrains.com/forgot-password"));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ENTER_EMAIL))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBMIT_BTN))).click();
    }

    public String getInfoMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ALLERT_INFO))).getText();
    }

    public void createAccount(String firstname, String lastname, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FNAME_ID))).sendKeys(firstname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LNAME_ID))).sendKeys(lastname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBMIT_BUTTON2))).click();
    }

    public String getInfoMessageForRegisterAccount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ACCOUNT_INFO))).getText();
    }
}
