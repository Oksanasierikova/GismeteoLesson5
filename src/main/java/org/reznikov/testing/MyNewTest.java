package org.reznikov.testing;

import org.reznikov.testing.gismeteo.pages.GismeteoHomePage;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;

public class MyNewTest extends BaseWebDriverTest{

    @Test
    public void testSite() throws IOException, InterruptedException {
        /*driver.get("https://google.com.ua");
        softAssert.assertTrue(true,"assert 1");
        softAssert.assertTrue(false,"assert 3");
        softAssert.assertTrue(true,"assert 4");
        softAssert.assertTrue(false,"Assert 5");
        Thread.sleep(2000);
        softAssert.assertAll();*/

        Reporter.log(new GismeteoHomePage(driver)
                .navigate()
                .searchForCity("Харьков")
                .switchToMonthView()
                .getForecastOnDateAsString(LocalDate.now().plusDays(3)),true);

    }

//    @Test
//    public void testSwitchToMonth(){
//        Reporter.log(new GismeteoHomePage(driver)
//                .navigate()
//                .searchForCity("Харьков")
//                .swithchToMonthView()
//                .getForecastOnDateAsString(LocalDate.now().plusDays(3)),true);
//
//    }

}
