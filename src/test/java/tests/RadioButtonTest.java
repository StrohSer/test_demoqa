package tests;

import pages.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    public void testSelectYesRadioButton() {
        driver.get(BASE_URL + "/radio-button");
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

        radioButtonPage.selectYes();

        Assert.assertTrue(radioButtonPage.isResultDisplayed(), "Result should be displayed");
        String resultText = radioButtonPage.getResultText();
        Assert.assertEquals(resultText, "Yes", "Result should be 'Yes'");
    }

    @Test
    public void testSelectImpressiveRadioButton() {
        driver.get(BASE_URL + "/radio-button");
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

        radioButtonPage.selectImpressive();

        Assert.assertTrue(radioButtonPage.isResultDisplayed(), "Result should be displayed");
        String resultText = radioButtonPage.getResultText();
        Assert.assertEquals(resultText, "Impressive", "Result should be 'Impressive'");
    }
}

