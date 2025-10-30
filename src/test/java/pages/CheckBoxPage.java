package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxPage extends BasePage {
    
    @FindBy(xpath = "//button[@title='Expand all']")
    private WebElement expandAllButton;
    
    @FindBy(xpath = "//button[@title='Collapse all']")
    private WebElement collapseAllButton;
    
    @FindBy(xpath = "//span[contains(@class, 'rct-checkbox')]")
    private List<WebElement> checkboxes;
    
    @FindBy(xpath = "//span[text()='Home']/ancestor::span[contains(@class, 'rct-text')]//span[contains(@class, 'rct-checkbox')]")
    private WebElement homeCheckbox;
    
    @FindBy(xpath = "//span[text()='Desktop']/ancestor::span[contains(@class, 'rct-text')]//span[contains(@class, 'rct-checkbox')]")
    private WebElement desktopCheckbox;
    
    @FindBy(xpath = "//span[text()='Documents']/ancestor::span[contains(@class, 'rct-text')]//span[contains(@class, 'rct-checkbox')]")
    private WebElement documentsCheckbox;
    
    @FindBy(xpath = "//span[text()='Downloads']/ancestor::span[contains(@class, 'rct-text')]//span[contains(@class, 'rct-checkbox')]")
    private WebElement downloadsCheckbox;
    
    @FindBy(id = "result")
    private WebElement resultText;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public void expandAll() {
        click(expandAllButton);
    }

    public void collapseAll() {
        click(collapseAllButton);
    }

    public void clickHomeCheckbox() {
        click(homeCheckbox);
    }

    public void clickDesktopCheckbox() {
        click(desktopCheckbox);
    }

    public void clickDocumentsCheckbox() {
        click(documentsCheckbox);
    }

    public void clickDownloadsCheckbox() {
        click(downloadsCheckbox);
    }

    public String getResultText() {
        return getText(resultText);
    }

    public boolean isResultDisplayed() {
        return isElementDisplayed(resultText);
    }
}

