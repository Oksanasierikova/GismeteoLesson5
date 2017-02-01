package org.reznikov.testing.Team.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class TeamUpCalendarPage {
    private static String ENV = "http://www.teamup.com/";
    private static String TRY_LIVE_DEMO = "//a[@class='button button-secondary'][text()='Try a Live Demo']";
    private static String TEAM_CALENDAR = ".//*[@class='calendar-video']/a[contains(text(),'Team Calendar')]";
    protected WebDriver driver;
    private WebDriverWait wait;
    protected static Map<String, String> appointment;

    public TeamUpCalendarPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

//    public static Map<String, String> getAppointmentData() {
//        if (appointment == null) {
//            appointment = new HashMap<>();
//            // appointment.put("Title", "Day off");//title - key, day off - value
////            appointment.put("From", "01/31/2017");
////            appointment.put("To", "01/31/2017");
//        }
//        return appointment;
//    }

    public TeamUpCalendarPage navigate() {
        driver.get(ENV);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TRY_LIVE_DEMO))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEAM_CALENDAR))).click();
        return this;
    }

    public TeamUpCalendarPage rescheduleAppointmentByDragAndDrop(
    //        Map<String, String> appointment, String date
    ) {
        //       String dateToSelector = "//*[contains(@id,'teamup-calendar-panel-multiweek-empty-3-day-20170201')]";
        String dateFromSelector = "//*[contains(@class,'teamup-calendar-panel-multiweek-evt')][text()='Day off']";
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(
                driver.findElement(By.xpath(dateFromSelector)),
                -100, 0).build().perform();
        // appointment.put("From", date);
        //appointment.put("To", date);
        return this;
    }
}
