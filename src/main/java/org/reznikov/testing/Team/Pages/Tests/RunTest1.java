package org.reznikov.testing.Team.Pages.Tests;

import org.reznikov.testing.BaseWebDriverTest;
import org.reznikov.testing.Team.Pages.TeamUpCalendarPage;
import org.testng.annotations.Test;

public class RunTest1 extends BaseWebDriverTest {
    @Test
    public void testDragAndDrop() throws InterruptedException {
        TeamUpCalendarPage page = new TeamUpCalendarPage(driver);
        page.navigate();
        page.rescheduleAppointmentByDragAndDrop(
        //        TeamUpCalendarPage.getAppointmentData(), "02/04/2017"
        );
        Thread.sleep(4000);
    }
}

