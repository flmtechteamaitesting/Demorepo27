import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenExample {

    // This method provides data to the test
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"user1@example.com", "pass123"},
            {"user2@example.com", "pass456"},
            {"user3@example.com", "pass789"}
        };
    }

    // This test runs 3 times, once for each set of data
    @Test(dataProvider = "loginData")
    public void loginWithMultipleUsers(String username, String password) {
        System.out.println("Testing login for: " + username + " with password: " + password);
        // Here you would normally call your Selenium driver.findElement(...)
    }
}