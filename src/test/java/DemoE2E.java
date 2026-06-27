import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoE2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Step1: Navigating to Gmail.....");
		
        driver.get("https://www.gmail.com");
        
        driver.manage().window().maximize();
        
        System.out.println("-----Gmail Info-------");
        
        //getting the page title
        
      String gmailTitle = driver.getTitle();
		
      System.out.println(" Page Tile: " + gmailTitle);
      
      //capture the Current URL
      
     String gmailurl = driver.getCurrentUrl();
     System.out.println(" Current URL: " + gmailurl);
     
     //using navigate method 
     
     driver.navigate().to("https://www.google.com");
     System.out.println(" New Title: " + driver.getTitle());
     
     Thread.sleep(3000);
     
     //back and forward button
     
     driver.navigate().back();
     System.out.println(" Back is clicked: " + driver.getTitle());
     
  Thread.sleep(3000);
     
     driver.navigate().forward();
     System.out.println(" Forward is clicked: " + driver.getTitle());
     
     Thread.sleep(3000);
     
     driver.navigate().refresh();
     
     System.out.println("Page Source length: " + driver.getPageSource().length());
   //  System.out.println("Page Source is: " + driver.getPageSource());
     
    // driver.close();
     
     driver.quit();
     
  
      
	}

}
