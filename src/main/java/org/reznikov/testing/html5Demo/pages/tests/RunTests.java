package org.reznikov.testing.html5Demo.pages.tests;

import org.openqa.selenium.WebDriver;
import org.reznikov.testing.BaseWebDriverTest;
import org.reznikov.testing.html5Demo.pages.DragAndDropPage;
import org.testng.annotations.Test;

public class RunTests extends BaseWebDriverTest {

    @Test
    public void testDragAndDrop() throws InterruptedException {
        DragAndDropPage page = new DragAndDropPage(driver);
        page.navigate();
        page.MoveElementToBin();
        Thread.sleep(2000);
    }
    @Test
    public void testDragAndDrop2() throws InterruptedException {
        DragAndDropPage page = new DragAndDropPage(driver);
        page.navigate();
        page.MoveElementToBin2();
        Thread.sleep(2000);
    }
    @Test
    public void testDragAndDrop3() throws InterruptedException {
        DragAndDropPage page = new DragAndDropPage(driver);
        page.navigate();
        page.MoveElementToBin3(-100);
        Thread.sleep(2000);
    }
}
