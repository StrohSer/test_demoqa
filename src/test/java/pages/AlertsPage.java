package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {
    
    @FindBy(id = "alertButton")
    private WebElement alertButton;
    
    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertButton;
    
    @FindBy(id = "confirmButton")
    private WebElement confirmButton;
    
    @FindBy(id = "promtButton")
    private WebElement promptButton;
    
    @FindBy(id = "confirmResult")
    private WebElement confirmResult;
    
    @FindBy(id = "promptResult")
    private WebElement promptResult;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAlertButton() {
        click(alertButton);
    }

    public void clickTimerAlertButton() {
        click(timerAlertButton);
    }

    public void clickConfirmButton() {
        click(confirmButton);
    }

    public void clickPromptButton() {
        click(promptButton);
    }

    public Alert switchToAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        Alert alert = switchToAlert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    public void sendTextToAlert(String text) {
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getAlertText() {
        Alert alert = switchToAlert();
        return alert.getText();
    }

    public String getConfirmResult() {
        return getText(confirmResult);
    }

    public String getPromptResult() {
        return getText(promptResult);
    }
}

