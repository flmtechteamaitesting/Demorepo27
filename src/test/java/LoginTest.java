import org.testng.annotations.*;

public class LoginTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("Opening Browser and navigating to Login Page...");
    }

    @Test(priority = 1, groups = {"Smoke"})
    public void validLoginTest() {
        System.out.println("Executing: User logs in with valid credentials.");
    }

    @Test(priority = 2, groups = {"Regression"})
    public void invalidLoginTest() {
        System.out.println("Executing: User logs in with invalid credentials.");
    }
   

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing Browser.");
        System.out.println("---------------------------------");
    }
}