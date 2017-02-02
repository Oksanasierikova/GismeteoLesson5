package org.reznikov.testing.html5Demo.pages.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.reznikov.testing.BaseWebDriverTest;
import org.reznikov.testing.html5Demo.pages.DragAndDropPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RunTests extends BaseWebDriverTest {

    @Test
    public void testDragAndDrop() throws InterruptedException {
        DragAndDropPage page = new DragAndDropPage(driver);
        page.navigate();
        page.MoveElementToNextDay();
        Thread.sleep(2000);
    }
    @Test
    public void testAddNewCalendar() throws InterruptedException {
        DragAndDropPage page = new DragAndDropPage(driver);
        page.navigate();
        page.CreateCalendarForOksanasVacation("Oksana Sierikova");
        page.AgentaView("Oksana's vacation","Oksana Sierikova");
    }

    //    @Test
//    public void testDragAndDrop2() throws InterruptedException {
//        DragAndDropPage page = new DragAndDropPage(driver);
//        page.navigate();
//        page.MoveElementToBin2();
//        softAssert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("one"))));
//        softAssert.assertAll();
//        Thread.sleep(5000);
//    }
//    @Test
//    public void testDragAndDrop3() throws InterruptedException {
//        DragAndDropPage page = new DragAndDropPage(driver);
//        page.navigate();
//        page.MoveElementToBin3(-100);
//        Thread.sleep(2000);
//    }
}
