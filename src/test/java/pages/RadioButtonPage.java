package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage extends BasePage {
    
    @FindBy(xpath = "//label[text()='Yes']")
    private WebElement yesRadioButton;
    
    @FindBy(xpath = "//label[text()='Impressive']")
    private WebElement impressiveRadioButton;
    
    @FindBy(xpath = "//label[text()='No']")
    private WebElement noRadioButton;
    
    @FindBy(xpath = "//span[@class='text-success']")
    private WebElement resultText;

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public void selectYes() {
        click(yesRadioButton);
    }

    public void selectImpressive() {
        click(impressiveRadioButton);
    }

    public void selectNo() {
        click(noRadioButton);
    }

    public String getResultText() {
        return getText(resultText);
    }

    public boolean isResultDisplayed() {
        return isElementDisplayed(resultText);
    }
}

