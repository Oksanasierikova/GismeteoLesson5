package org.reznikov.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.reznikov.testing.gismeteo.pages.CityPage;
import org.reznikov.testing.gismeteo.pages.GismeteoHomePage;
import org.reznikov.testing.gismeteo.pages.MonthView;
import org.reznikov.testing.gismeteo.pages.TwoWeeksView;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class RunTest extends BaseWebDriverTest {
//    @Test
//    public void testGoToTwoWeeksView() {
//        GismeteoHomePage page = new GismeteoHomePage(driver);
//        page.searchForCity("Харьков");
//        wait.until(ExpectedConditions.titleIs("GISMETEO: Погода в Харькове на сегодня, завтра - прогноз погоды на 3 дня, Харьковская область, Харьков, Украина."));
//        TwoWeeksView twoWeeks = new CityPage(driver).switchToTwoWeeksView();
//        // wait.until(ExpectedConditions.urlContains("https://www.gismeteo.ua/weather-kharkiv-5053/14-days/"));
//        assert driver.getCurrentUrl().equals("https://www.gismeteo.ua/weather-kharkiv-5053/14-days/");
//        twoWeeks.getForecastForDay(LocalDate.of(2017, 01, 27));
//        twoWeeks.getDayTemp();
//        twoWeeks.getNightTemp();
//    }

    @Test
    public void testGoTopCalendar() {
        GismeteoHomePage page = new GismeteoHomePage(driver);
        page.searchForCity("Харьков");
        MonthView monthView = new CityPage(driver).switchToMonthView();
        monthView.getForecastForDayInMonthView(LocalDate.of(2017,01,27));
        monthView.getDate();
    }

    @Test
    public void testGoBottomCalendar() {
        GismeteoHomePage page = new GismeteoHomePage(driver);
        page.searchForCity("Харьков");
        MonthView monthView = new CityPage(driver).switchToMonthView();
        //monthView.getForecastOnDateAsString(LocalDate.now());
        monthView.getForecastForDayInMonthView(LocalDate.of(2017, 02, 01));
        monthView.getDate();
    }
}
