package org.reznikov.testing.jetbrains.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by P-C on 1/31/2017.
 */
public class CreateAccount extends LoginPage {
    private static final String ACCOUNT_INFO = "//div[contains(@class, 'alert-success')]";

    public CreateAccount(WebDriver driver) {
        super(driver);
    }

    public String getInfoMessageForRegisterAccount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ACCOUNT_INFO))).getText();
    }
}
