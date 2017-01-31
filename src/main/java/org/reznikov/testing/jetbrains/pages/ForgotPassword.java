package org.reznikov.testing.jetbrains.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPassword extends LoginPage {
    private static final String ENTER_EMAIL = "//input[contains(@class, 'form-control')]";
    private static final String SUBMIT_BTN = "//button[contains(@class, 'btn')]";
    private static final String ALLERT_INFO = "//div[contains(@class, 'alert')]";

    public ForgotPassword(WebDriver driver) {
        super(driver);
    }

    public EnterEmail enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ENTER_EMAIL))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBMIT_BTN))).click();
        return new EnterEmail(driver);
    }

    public String getInfoMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ALLERT_INFO))).getText();
    }

}
