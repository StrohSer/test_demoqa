package tests;

import pages.ButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test
    public void testDoubleClickButton() {
        driver.get(BASE_URL + "/buttons");
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.doubleClickButton();

        Assert.assertTrue(buttonsPage.isDoubleClickMessageDisplayed(), 
                "Double click message should be displayed");
        String message = buttonsPage.getDoubleClickMessage();
        Assert.assertTrue(message.contains("double click"), 
                "Message should contain 'double click'");
    }

    @Test
    public void testRightClickButton() {
        driver.get(BASE_URL + "/buttons");
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.rightClickButton();

        Assert.assertTrue(buttonsPage.isRightClickMessageDisplayed(), 
                "Right click message should be displayed");
        String message = buttonsPage.getRightClickMessage();
        Assert.assertTrue(message.contains("right click"), 
                "Message should contain 'right click'");
    }

    @Test
    public void testDynamicClickButton() {
        driver.get(BASE_URL + "/buttons");
        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickMeButton();

        Assert.assertTrue(buttonsPage.isDynamicClickMessageDisplayed(), 
                "Dynamic click message should be displayed");
        String message = buttonsPage.getDynamicClickMessage();
        Assert.assertTrue(message.contains("dynamic click"), 
                "Message should contain 'dynamic click'");
    }
}

