package tests;

import pages.FormsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormsTest extends BaseTest {

    @Test
    public void testSubmitPracticeForm() {
        driver.get(BASE_URL + "/automation-practice-form");
        FormsPage formsPage = new FormsPage(driver);

        String firstName = "John";
        String lastName = "Doe";
        String email = "john.doe@example.com";
        String mobile = "1234567890";
        String address = "123 Main Street, City, Country";

        formsPage.fillFirstName(firstName);
        formsPage.fillLastName(lastName);
        formsPage.fillEmail(email);
        formsPage.selectGender("Male");
        formsPage.fillMobileNumber(mobile);
        formsPage.selectHobby("Sports");
        formsPage.fillCurrentAddress(address);
        
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", 
                        driver.findElement(org.openqa.selenium.By.id("submit")));
        
        formsPage.submitForm();

        Assert.assertTrue(formsPage.isModalDisplayed(), "Modal should be displayed");
        String modalTitle = formsPage.getModalTitle();
        Assert.assertEquals(modalTitle, "Thanks for submitting the form", 
                "Modal title should be correct");
    }
}

