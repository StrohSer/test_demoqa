package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebTablesPage;

public class WebTablesTest extends BaseTest {

    @Test
    public void testAddNewRecord() {
        driver.get(BASE_URL + "/webtables");
        WebTablesPage webTablesPage = new WebTablesPage(driver);

        int initialRowsCount = webTablesPage.getTableRowsCount();
        
        String firstName = "Ivan";
        String lastName = "Petrov";
        String email = "ivan.petrov@example.com";
        String age = "30";
        String salary = "50000";
        String department = "IT";

        webTablesPage.addNewRecord(firstName, lastName, email, age, salary, department);

        int finalRowsCount = webTablesPage.getTableRowsCount();
        Assert.assertTrue(finalRowsCount > initialRowsCount, 
                "New record should be added. Initial: " + initialRowsCount + ", Final: " + finalRowsCount);
        
        Assert.assertTrue(webTablesPage.isRecordInTable(firstName, lastName),
                "Record should be present in the table");
    }
}

