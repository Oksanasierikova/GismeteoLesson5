package org.reznikov.testing.html5Demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropPage {
    private static String URL = "http://html5demos.com/drag#";
    protected WebDriver driver;
    private WebDriverWait wait;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public DragAndDropPage navigate() {
        driver.get(URL);
        return this;
    }

    public DragAndDropPage MoveElementToBin() {
        String SelectorForOne = "//a[@id='one'][text()='one']";
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(driver.findElement(By.xpath(SelectorForOne)), -250, 0).build().perform();
        return this;
    }

    public DragAndDropPage MoveElementToBin2() {
        WebElement draggable = driver.findElement(By.id("one"));
        WebElement target = driver.findElement(By.id("bin"));
        new Actions(driver).dragAndDrop(draggable, target).perform();
        return this;
    }

    public DragAndDropPage MoveElementToBin3(int x) {
        String SelectorForOne = "//a[@id='one'][text()='one']";
        Actions action = new Actions(driver);
        action.dragAndDropBy(driver.findElement(By.xpath(SelectorForOne)), x, 0).perform();
        return this;
    }

}
