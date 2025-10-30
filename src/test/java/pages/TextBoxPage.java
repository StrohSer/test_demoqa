package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {
    
    @FindBy(id = "userName")
    private WebElement userNameInput;
    
    @FindBy(id = "userEmail")
    private WebElement userEmailInput;
    
    @FindBy(id = "currentAddress")
    private WebElement currentAddressTextarea;
    
    @FindBy(id = "permanentAddress")
    private WebElement permanentAddressTextarea;
    
    @FindBy(id = "submit")
    private WebElement submitButton;
    
    @FindBy(id = "output")
    private WebElement outputDiv;
    
    @FindBy(id = "name")
    private WebElement outputName;
    
    @FindBy(id = "email")
    private WebElement outputEmail;

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String userName) {
        sendKeys(userNameInput, userName);
    }

    public void fillUserEmail(String email) {
        sendKeys(userEmailInput, email);
    }

    public void fillCurrentAddress(String address) {
        sendKeys(currentAddressTextarea, address);
    }

    public void fillPermanentAddress(String address) {
        sendKeys(permanentAddressTextarea, address);
    }

    public void submitForm() {
        click(submitButton);
    }

    public boolean isOutputDisplayed() {
        return isElementDisplayed(outputDiv);
    }

    public String getOutputText() {
        return getText(outputDiv);
    }

    public String getOutputName() {
        return getText(outputName);
    }

    public String getOutputEmail() {
        return getText(outputEmail);
    }
}

