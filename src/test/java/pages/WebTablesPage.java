package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class WebTablesPage extends BasePage {
    
    @FindBy(id = "addNewRecordButton")
    private WebElement addButton;
    
    @FindBy(id = "firstName")
    private WebElement firstNameInput;
    
    @FindBy(id = "lastName")
    private WebElement lastNameInput;
    
    @FindBy(id = "userEmail")
    private WebElement emailInput;
    
    @FindBy(id = "age")
    private WebElement ageInput;
    
    @FindBy(id = "salary")
    private WebElement salaryInput;
    
    @FindBy(id = "department")
    private WebElement departmentInput;
    
    @FindBy(id = "submit")
    private WebElement submitButton;
    
    @FindBy(xpath = "//div[@class='rt-tbody']//div[@class='rt-tr-group']")
    private List<WebElement> tableRows;
    
    @FindBy(xpath = "//span[@title='Delete']")
    private List<WebElement> deleteButtons;

    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddButton() {
        click(addButton);
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

    public void fillAge(String age) {
        sendKeys(ageInput, age);
    }

    public void fillSalary(String salary) {
        sendKeys(salaryInput, salary);
    }

    public void fillDepartment(String department) {
        sendKeys(departmentInput, department);
    }

    public void submitForm() {
        click(submitButton);
    }

    public void addNewRecord(String firstName, String lastName, String email, String age, String salary, String department) {
        clickAddButton();
        fillFirstName(firstName);
        fillLastName(lastName);
        fillEmail(email);
        fillAge(age);
        fillSalary(salary);
        fillDepartment(department);
        submitForm();
        // Ждем пока модальное окно закроется и таблица обновится
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                org.openqa.selenium.By.id("firstName")));
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            // Игнорируем исключение
        }
    }

    public int getTableRowsCount() {
        try {
            // Всегда находим строки заново, так как таблица может обновиться
            List<WebElement> rows = driver.findElements(
                org.openqa.selenium.By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']"));
            // Фильтруем только видимые строки с данными
            int count = 0;
            for (WebElement row : rows) {
                if (row.isDisplayed()) {
                    String text = row.getText().trim();
                    // Строка считается валидной, если содержит хотя бы один непустой текст
                    if (!text.isEmpty() && text.length() > 10) {
                        count++;
                    }
                }
            }
            return count;
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean isRecordInTable(String firstName, String lastName) {
        try {
            WebElement row = driver.findElement(
                org.openqa.selenium.By.xpath(String.format(
                    "//div[@class='rt-tbody']//div[contains(text(), '%s') and contains(text(), '%s')]",
                    firstName, lastName)));
            return row.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

