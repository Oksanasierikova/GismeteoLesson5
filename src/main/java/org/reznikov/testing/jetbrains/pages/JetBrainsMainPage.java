package org.reznikov.testing.jetbrains.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JetBrainsMainPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static String LOGIN_SELECTOR = "//a[@title='Account']";

    public JetBrainsMainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public JetBrainsMainPage navigate() {
        driver.get("https://www.jetbrains.com/");
        return this;
    }

    public LoginPage getLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_SELECTOR))).click();
        return new LoginPage(driver);
    }
}
