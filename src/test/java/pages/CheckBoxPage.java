package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBoxPage extends BasePage {
    
    @FindBy(xpath = "//button[@title='Expand all']")
    private WebElement expandAllButton;
    
    @FindBy(xpath = "//button[@title='Collapse all']")
    private WebElement collapseAllButton;
    
    @FindBy(xpath = "//label[@for='tree-node-home']")
    private WebElement homeCheckbox;
    
    @FindBy(xpath = "//label[@for='tree-node-desktop']")
    private WebElement desktopCheckbox;
    
    @FindBy(xpath = "//label[@for='tree-node-documents']")
    private WebElement documentsCheckbox;
    
    @FindBy(xpath = "//label[@for='tree-node-downloads']")
    private WebElement downloadsCheckbox;
    
    @FindBy(id = "result")
    private WebElement resultText;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public void expandAll() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(expandAllButton));
            click(expandAllButton);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            // Если кнопка уже нажата или не найдена, продолжаем
        }
    }

    public void collapseAll() {
        try {
            click(collapseAllButton);
        } catch (Exception e) {
            // Если кнопка уже нажата или не найдена, продолжаем
        }
    }

    public void clickHomeCheckbox() {
        try {
            click(homeCheckbox);
        } catch (Exception e) {
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", homeCheckbox);
        }
    }

    public void clickDesktopCheckbox() {
        try {
            click(desktopCheckbox);
        } catch (Exception e) {
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", desktopCheckbox);
        }
    }

    public void clickDocumentsCheckbox() {
        try {
            click(documentsCheckbox);
        } catch (Exception e) {
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", documentsCheckbox);
        }
    }

    public void clickDownloadsCheckbox() {
        try {
            click(downloadsCheckbox);
        } catch (Exception e) {
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", downloadsCheckbox);
        }
    }

    public String getResultText() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.id("result")));
            WebElement result = driver.findElement(org.openqa.selenium.By.id("result"));
            return getText(result);
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isResultDisplayed() {
        try {
            WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(
                org.openqa.selenium.By.id("result")));
            return result.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

