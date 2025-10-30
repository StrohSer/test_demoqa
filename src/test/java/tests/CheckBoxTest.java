package tests;

import pages.CheckBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    @Test
    public void testSelectHomeCheckbox() {
        driver.get(BASE_URL + "/checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.expandAll();
        checkBoxPage.clickHomeCheckbox();

        Assert.assertTrue(checkBoxPage.isResultDisplayed(), "Result should be displayed");
        String resultText = checkBoxPage.getResultText();
        Assert.assertTrue(resultText.contains("home"), "Result should contain 'home'");
    }

    @Test
    public void testSelectMultipleCheckboxes() {
        driver.get(BASE_URL + "/checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.expandAll();
        checkBoxPage.clickDesktopCheckbox();
        checkBoxPage.clickDownloadsCheckbox();

        Assert.assertTrue(checkBoxPage.isResultDisplayed(), "Result should be displayed");
        String resultText = checkBoxPage.getResultText();
        Assert.assertTrue(resultText.contains("desktop") || resultText.contains("downloads"),
                "Result should contain selected checkboxes");
    }
}

