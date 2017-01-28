package org.reznikov.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.reznikov.testing.gismeteo.pages.GismeteoHomePage;
import org.reznikov.testing.jetbrains.pages.JetBrainsMainPage;
import org.reznikov.testing.jetbrains.pages.LoginPage;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;

public class MyNewTest extends BaseWebDriverTest {

    @Test( //groups = {"smoke"}, priority = 0, enabled = true, timeOut = 1000
            //,dataProvider = "newprovider"
            groups = {"smoke", "regression"},
            priority = 1,
            enabled = true,
            timeOut = 1000,
            dataProvider = "newProvider", threadPoolSize = 5
    )
    public void testSite(/*String city*/) throws IOException, InterruptedException {
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
                .getForecastOnDateAsString(LocalDate.now().plusDays(3)), true)
        ;
    }

    @Test(expectedExceptions = WebDriverException.class
            //retryAnalyzer = neme_of_class
            // dependsOnMethods = "testSuite",
    )
    // retryAnalyzer - есть нестабильные тесты, когда собирается инфо об упавших тестах и ещё раз пытаемся их запустить
    //dependsOnMethods тест не запускается пока тест из тест сью не выполнился успешно
    public void testSecond() {
        throw new WebDriverException();
    }


    //тоже самое можно и в xml, он имеет больший приоритет
//timeout - тест должен завершиться если выболняется больше какого-то времени

    @DataProvider(name = "newProvider", parallel = true)
    public Object[][] newProvider() {
        return new Object[][]{
                {"Харьков"},
                {"Киев"},
                {"Львов"}
        };
    }

    @DataProvider(name = "passwordProvider", parallel = true)
    public Object[][] passwordProvider() {
        return new Object[][]{
                {"user", "passw"}
        };
    }

    @Test(dataProvider = "passwordProvider")
    public void testJetBrainsLogin(String username, String password) {
        LoginPage page = new JetBrainsMainPage(driver).navigate().getLoginPage();
        page.logIn(username, password);
        softAssert.assertTrue(page.getErrorMessage()
                .contains("Incorrect username and/or password!"));
        softAssert.assertAll();
        //   assert driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
    }

}
