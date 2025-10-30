package tests;

import pages.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    @Test
    public void testSimpleAlert() {
        driver.get(BASE_URL + "/alerts");
        AlertsPage alertsPage = new AlertsPage(driver);

        alertsPage.clickAlertButton();
        String alertText = alertsPage.getAlertText();
        alertsPage.acceptAlert();

        Assert.assertEquals(alertText, "You clicked a button", 
                "Alert text should be 'You clicked a button'");
    }

    @Test
    public void testConfirmAlert() {
        driver.get(BASE_URL + "/alerts");
        AlertsPage alertsPage = new AlertsPage(driver);

        alertsPage.clickConfirmButton();
        alertsPage.acceptAlert();

        String result = alertsPage.getConfirmResult();
        Assert.assertTrue(result.contains("Ok"), "Result should contain 'Ok'");
    }

    @Test
    public void testPromptAlert() {
        driver.get(BASE_URL + "/alerts");
        AlertsPage alertsPage = new AlertsPage(driver);

        String testText = "Test User";
        alertsPage.clickPromptButton();
        alertsPage.sendTextToAlert(testText);

        String result = alertsPage.getPromptResult();
        Assert.assertTrue(result.contains(testText), 
                "Result should contain entered text: " + testText);
    }
}

