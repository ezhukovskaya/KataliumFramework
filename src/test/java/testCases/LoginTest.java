package testCases;

import com.katalon.kata.testng.TestTemplate;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.pages.CuraAppoinmentPage;
import pageObject.pages.CuraHomePage;
import pageObject.pages.CuraLoginPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginTest extends TestTemplate {
    private final CuraHomePage curaHomePage = new CuraHomePage(Constants.BASE_URL);

    private final CuraLoginPage curaLoginPage = new CuraLoginPage();

    private final CuraAppoinmentPage curaAppoinmentPage = new CuraAppoinmentPage();

    private final String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    @Test
    public void shouldLogin() {
        curaHomePage.open();
        curaHomePage.makeAppointment();
        curaLoginPage.login(Constants.USERNAME, Constants.PASSWORD);
        Assert.assertTrue(curaAppoinmentPage.isOnPage(), String.format("Page %s is not displayed", curaAppoinmentPage.divAppointment));
        String facility = "Tokyo CURA Healthcare Center";
        curaAppoinmentPage.fillAppointmentDetails(facility, date, null);
        driver.quit();
    }
}
