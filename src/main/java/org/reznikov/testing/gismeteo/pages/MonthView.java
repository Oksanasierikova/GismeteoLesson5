package org.reznikov.testing.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MonthView extends CityPage {
    private String MONTH_TILE = "//*[@class='calendar'][1]//td[contains(@class,'tip')][not(contains(@class,'disabled'))][not(contains(@class,'empty'))][.//span[@class='day'][text()='{0}']]";
    private String MONTH_TILE2 = "//*[@class='calendar'][2]//td[contains(@class,'tip')][not(contains(@class,'disabled'))][not(contains(@class,'empty'))][.//span[@class='day'][text()='{0}']]";
    private String MIN_TEMP = "//*[@class='temp min']/*[@class='value m_temp c']";
    private String MAX_TEMP = "//*[@class='temp max']/*[@class='value m_temp c']";

    public MonthView(WebDriver driver) {
        super(driver);
    }

    public void getForecastForDayInMonthView(LocalDate date) {
        LocalDate firstDayInList = LocalDate.now();
        if (ChronoUnit.DAYS.between(firstDayInList, date) < 5) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(MONTH_TILE.replace(
                            "{0}", String.valueOf(date.getDayOfMonth())))))
                    .click();
            System.out.println("you are in top month");
        } else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(MONTH_TILE2.replace(
                            "{0}", String.valueOf(date.getDayOfMonth())))))
                    .click();
            System.out.println("you are in bottom month");
        }
    }


    public ThreeDaysView getForecastOnDateAsThreeDaysViewTop(LocalDate date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(MONTH_TILE.replace(
                        "{0}", String.valueOf(date.getDayOfMonth())))))
                .click();
        //date.getMonth().getDisplayName(TextStyle.FULL,Locale.)
        return new ThreeDaysView(driver);
    }

    public ThreeDaysView getForecastOnDateAsThreeDaysViewBottom(LocalDate date) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(MONTH_TILE2.replace(
                        "{0}", String.valueOf(date.getDayOfMonth())))))
                .click();
        //date.getMonth().getDisplayName(TextStyle.FULL,Locale.)
        return new ThreeDaysView(driver);
    }

    public String getForecastOnDateAsString(LocalDate date) {
        return "Max temperature on " + date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                + " are " + wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MONTH_TILE + MAX_TEMP))).getText();
    }
}
