1import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class InventoryTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        // Perform login first to reach inventory
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @DataProvider(name = "productData")
    public Object[][] getProducts() {
        return new Object[][] {
            {"Sauce Labs Backpack"},
            {"Sauce Labs Bike Light"}
        };
    }

    @Test(dataProvider = "productData", groups = {"Regression"})
    public void verifyProductAdd(String productName) {
        // Find the button dynamically based on product name
        String xpath = "//div[text()='" + productName + "']/../../..//button";
        driver.findElement(By.xpath(xpath)).click();
       
        String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(cartCount, "1", "Cart count should be 1");
        System.out.println("Regression Test: Added " + productName + " to cart.");
    }

    @Test(groups = {"Smoke"})
    public void verifyInventoryPageLoad() {
        boolean isInventoryVisible = driver.findElement(By.className("inventory_list")).isDisplayed();
        Assert.assertTrue(isInventoryVisible, "Inventory list not visible!");
        System.out.println("Smoke Test: Inventory page loaded successfully.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}