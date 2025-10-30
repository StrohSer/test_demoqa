package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends BasePage {
    
    @FindBy(id = "firstName")
    private WebElement firstNameInput;
    
    @FindBy(id = "lastName")
    private WebElement lastNameInput;
    
    @FindBy(id = "userEmail")
    private WebElement emailInput;
    
    @FindBy(xpath = "//label[text()='Male']")
    private WebElement maleRadio;
    
    @FindBy(xpath = "//label[text()='Female']")
    private WebElement femaleRadio;
    
    @FindBy(xpath = "//label[text()='Other']")
    private WebElement otherRadio;
    
    @FindBy(id = "userNumber")
    private WebElement mobileNumberInput;
    
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;
    
    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;
    
    @FindBy(xpath = "//label[text()='Sports']")
    private WebElement sportsCheckbox;
    
    @FindBy(xpath = "//label[text()='Reading']")
    private WebElement readingCheckbox;
    
    @FindBy(xpath = "//label[text()='Music']")
    private WebElement musicCheckbox;
    
    @FindBy(id = "currentAddress")
    private WebElement currentAddressTextarea;
    
    @FindBy(id = "submit")
    private WebElement submitButton;
    
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement modalTitle;
    
    @FindBy(xpath = "//table//td")
    private java.util.List<WebElement> modalTableCells;

    public FormsPage(WebDriver driver) {
        super(driver);
    }

    public void fillFirstName(String firstName) {
        sendKeys(firstNameInput, firstName);
    }

    public void fillLastName(String lastName) {
        sendKeys(lastNameInput, lastName);
    }

    public void fillEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void selectGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                click(maleRadio);
                break;
            case "female":
                click(femaleRadio);
                break;
            case "other":
                click(otherRadio);
                break;
        }
    }

    public void fillMobileNumber(String mobile) {
        sendKeys(mobileNumberInput, mobile);
    }

    public void fillDateOfBirth(String date) {
        sendKeys(dateOfBirthInput, date);
    }

    public void selectHobby(String hobby) {
        switch (hobby.toLowerCase()) {
            case "sports":
                click(sportsCheckbox);
                break;
            case "reading":
                click(readingCheckbox);
                break;
            case "music":
                click(musicCheckbox);
                break;
        }
    }

    public void fillCurrentAddress(String address) {
        sendKeys(currentAddressTextarea, address);
    }

    public void submitForm() {
        click(submitButton);
    }

    public boolean isModalDisplayed() {
        return isElementDisplayed(modalTitle);
    }

    public String getModalTitle() {
        return getText(modalTitle);
    }

    public java.util.List<WebElement> getModalTableCells() {
        return modalTableCells;
    }
}

