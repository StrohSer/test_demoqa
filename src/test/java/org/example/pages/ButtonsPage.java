package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonsPage extends BasePage {
    
    @FindBy(id = "doubleClickBtn")
    private WebElement doubleClickButton;
    
    @FindBy(id = "rightClickBtn")
    private WebElement rightClickButton;
    
    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeButton;
    
    @FindBy(id = "doubleClickMessage")
    private WebElement doubleClickMessage;
    
    @FindBy(id = "rightClickMessage")
    private WebElement rightClickMessage;
    
    @FindBy(id = "dynamicClickMessage")
    private WebElement dynamicClickMessage;

    private Actions actions;

    public ButtonsPage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);
    }

    public void doubleClickButton() {
        wait.until(ExpectedConditions.elementToBeClickable(doubleClickButton));
        actions.doubleClick(doubleClickButton).perform();
    }

    public void rightClickButton() {
        wait.until(ExpectedConditions.elementToBeClickable(rightClickButton));
        actions.contextClick(rightClickButton).perform();
    }

    public void clickMeButton() {
        click(clickMeButton);
    }

    public String getDoubleClickMessage() {
        wait.until(ExpectedConditions.visibilityOf(doubleClickMessage));
        return getText(doubleClickMessage);
    }

    public String getRightClickMessage() {
        wait.until(ExpectedConditions.visibilityOf(rightClickMessage));
        return getText(rightClickMessage);
    }

    public String getDynamicClickMessage() {
        wait.until(ExpectedConditions.visibilityOf(dynamicClickMessage));
        return getText(dynamicClickMessage);
    }

    public boolean isDoubleClickMessageDisplayed() {
        return isElementDisplayed(doubleClickMessage);
    }

    public boolean isRightClickMessageDisplayed() {
        return isElementDisplayed(rightClickMessage);
    }

    public boolean isDynamicClickMessageDisplayed() {
        return isElementDisplayed(dynamicClickMessage);
    }
}
