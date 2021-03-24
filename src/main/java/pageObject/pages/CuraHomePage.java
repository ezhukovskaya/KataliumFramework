package pageObject.pages;

import com.katalon.kata.selenium.PageTemplate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CuraHomePage extends PageTemplate {
    private String baseUrl;

    @FindBy(id = "btn-make-appointment")
    private WebElement makeAppointmentBtn;

    public CuraHomePage(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void open() {
        log.info("Open CURA home page.");
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public void makeAppointment() {
        log.info("Make appointment.");
        makeAppointmentBtn.click();
    }
}
