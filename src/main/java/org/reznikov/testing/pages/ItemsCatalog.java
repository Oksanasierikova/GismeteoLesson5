package org.reznikov.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ItemsCatalog extends LandingPage {

    public ItemsCatalog(WebDriver driver) {
        super(driver);
    }

    public ItemsCatalog selectCategory(String category) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@data-title='" + category + "']"))).build().perform();
        return this;
    }

    public LandingPage goToCategory(String category) {
        selectCategory(category);
        driver.findElement(By.xpath("//*[@data-title='" + category + "']")).click();
        return new LandingPage(driver);
    }
}
