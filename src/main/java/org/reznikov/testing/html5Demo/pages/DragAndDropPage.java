package org.reznikov.testing.html5Demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.reznikov.testing.Team.Pages.TeamUpCalendarPage;

import java.time.LocalDate;

public class DragAndDropPage {
    private static String URL = "http://www.teamup.com/";
    private static String TRY_LIVE_DEMO = "//a[@class='button button-secondary'][text()='Try a Live Demo']";
    private static String TEAM_CALENDAR = ".//*[@class='calendar-video']/a[contains(text(),'Team Calendar')]";
    protected WebDriver driver;
    private WebDriverWait wait;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public DragAndDropPage navigate() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TRY_LIVE_DEMO))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TEAM_CALENDAR))).click();
        return this;
    }

    public DragAndDropPage MoveElementToNextDay() {
        String SelectorForOne = "//*[contains(@class,'teamup-calendar-panel-multiweek-evt')][text()='Day off']";
        String SelectorForUndo = "//a[contains(@class,'x-border-box')][text()='Undo']";
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(driver.findElement(By.xpath(SelectorForOne)), 100, 0).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SelectorForUndo))).click();
        return this;
    }


    public DragAndDropPage CreateCalendarForOksanasVacation(String name) {
        String SELECT_ADD = "//a[@class='button-plus'][text()='Add / Edit']";
        String SELECT_NEW = "//li[contains(@class,'dropdown-button')]";
        String SELECT_ADD_CALENDAR = "//i[@class='sprite-settings-teamup-white']";
        String ENTER_NAME = "//input[@class='settings__input-big']";
        String SAVE_BUTTON = "//button[@type='submit']";
        String NAME = "//a[text()='Oksana Sierikova']";
        String CLICK_BACK = "//a[@class='btn__state-green']";
        String NAME_PRESENT = "//li[@data-qtip='Hide / show Oksana Sierikova']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECT_ADD))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECT_NEW))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECT_ADD_CALENDAR))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ENTER_NAME))).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAVE_BUTTON))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CLICK_BACK))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_PRESENT)));
        return this;
    }

    public DragAndDropPage AgentaView(String event, String name){
        String AGENTA_PAGE = "//span[contains(@class,'x-btn-inner')][text()='Agenda']";
        String ADD_EVENT = "//span[contains(@class,'x-btn-inner')][text()='Add event']";
        String ENTER_EVENT = "//textarea[contains(@placeholder,'Enter the event title')]";
        String FROM_DATE = "//div[contains(@class,'date-from-value')]";
        String CHOSE_DATE_FROM = "//span[@class='flatpickr-day '][text()='3']";
        // String TO_DATE = "//div[contains(@class,'date-to-value')]";
        // String CHOSE_DATE_TO = "//span[@class='flatpickr-day '][text()='18']";
       // String SELECT = "//div[@class='Select-control']";
        String CLEAR = "//span[@class='Select-value-icon']";
       String CHOOSE_CALENDAR = "//div[@class='Select-placeholder'][text()='Choose calendars']";
       String SAVE_BUTTON = "//button[@type='submit']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AGENTA_PAGE))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ADD_EVENT))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ENTER_EVENT))).sendKeys(event);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FROM_DATE))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHOSE_DATE_FROM))).click();
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TO_DATE))).click();
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHOSE_DATE_TO))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CLEAR))).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHOOSE_CALENDAR))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHOOSE_CALENDAR))).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SAVE_BUTTON))).click();
        return this;
    }

//
//    public DragAndDropPage MoveElementToBin2() {
//        String SelectorForOne = "//*[contains(@class,'teamup-calendar-panel-multiweek-evt')][text()='Day off']";
//        WebElement draggable = driver.findElement(By.xpath(SelectorForOne));
//        WebElement target = driver.findElement(By.id("bin"));
//        new Actions(driver).dragAndDrop(draggable, target).perform();
//        return new DragAndDropPage(driver);
//    }
}

//
//    public DragAndDropPage MoveElementToBin3(int x) {
//        String SelectorForOne = "//a[@id='one'][text()='one']";
//        Actions action = new Actions(driver);
//        action.dragAndDropBy(driver.findElement(By.xpath(SelectorForOne)), x, 0).perform();
//        return this;
//    }