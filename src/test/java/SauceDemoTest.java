
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class SauceDemoTest {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        softAssert = new SoftAssert();
    }

    @Test(groups = {"Smoke"})
    public void verifyLoginPageTitle() {
        String title = driver.getTitle();
        // Hard assertion: If this fails, the test stops immediately
        org.testng.Assert.assertEquals(title, "Swag Labs", "Title mismatch!");
        System.out.println("Smoke Test: Title Verified.");
    }

    @Test(groups = {"Regression"})
    public void verifyLoginFunctionality() {
        driver.findElement(By.id("user-name1")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String url = driver.getCurrentUrl();
       
        // Soft Assertion: Test continues even if assertion fails
        softAssert.assertTrue(url.contains("inventory"), "URL does not contain inventory!");
       
        boolean isCartVisible = driver.findElement(By.className("shopping_cart_link")).isDisplayed();
        softAssert.assertTrue(isCartVisible, "Cart icon is missing!");
       
        System.out.println("Regression Test: Login successful and elements verified.");
        softAssert.assertAll(); // Important: Reports all failures at the end
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}