package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CheckBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

    @Test
    @Description("Test selecting Home checkbox")
    @Severity(SeverityLevel.NORMAL)
    public void testSelectHomeCheckbox() {
        driver.get(BASE_URL + "/checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.expandAll();
        checkBoxPage.clickHomeCheckbox();

        Assert.assertTrue(checkBoxPage.isResultDisplayed(), "Result should be displayed");
        String resultText = checkBoxPage.getResultText().toLowerCase();
        Assert.assertTrue(resultText.contains("home"), "Result should contain 'home', but was: " + resultText);
    }

    @Test
    @Description("Test selecting multiple checkboxes")
    @Severity(SeverityLevel.NORMAL)
    public void testSelectMultipleCheckboxes() {
        driver.get(BASE_URL + "/checkbox");
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.expandAll();
        checkBoxPage.clickDesktopCheckbox();
        checkBoxPage.clickDownloadsCheckbox();

        Assert.assertTrue(checkBoxPage.isResultDisplayed(), "Result should be displayed");
        String resultText = checkBoxPage.getResultText().toLowerCase();
        Assert.assertTrue(resultText.contains("desktop") || resultText.contains("downloads"),
                "Result should contain selected checkboxes, but was: " + resultText);
    }
}

