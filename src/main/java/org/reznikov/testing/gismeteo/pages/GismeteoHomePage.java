package org.reznikov.testing.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GismeteoHomePage {

    private static final String SEARCH = "//input[contains(@class,'input')]";
    private static final String AUTOCOMPLETE = "//*[@id='jSuggestContainer']/ul/li[1]";
    private static final String SITE_URL = "https://www.gismeteo.ua/";
    protected WebDriver driver;
    protected WebDriverWait wait;
    private long DEFAULT_TIMEOUT = 1;

    public GismeteoHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
         this.driver.get(SITE_URL);
    }

    public GismeteoHomePage navigate(){
        driver.get(SITE_URL);
        return this;
    }

    public CityPage searchForCity(String city){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH))).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AUTOCOMPLETE))).click();
    return new CityPage(driver);
    }

}
