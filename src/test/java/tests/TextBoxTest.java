package tests;

import pages.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    @Test
    public void testSubmitTextBoxForm() {
        driver.get(BASE_URL + "/text-box");
        TextBoxPage textBoxPage = new TextBoxPage(driver);

        String userName = "John Doe";
        String email = "john.doe@example.com";
        String currentAddress = "123 Main St, City, Country";
        String permanentAddress = "456 Second St, City, Country";

        textBoxPage.fillUserName(userName);
        textBoxPage.fillUserEmail(email);
        textBoxPage.fillCurrentAddress(currentAddress);
        textBoxPage.fillPermanentAddress(permanentAddress);
        textBoxPage.submitForm();

        Assert.assertTrue(textBoxPage.isOutputDisplayed(), "Output should be displayed");
        String outputText = textBoxPage.getOutputText();
        Assert.assertTrue(outputText.contains(userName), "Output should contain user name");
        Assert.assertTrue(outputText.contains(email), "Output should contain email");
    }
}

