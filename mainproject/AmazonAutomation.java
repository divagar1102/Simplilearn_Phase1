package mainproject;

import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonAutomation {
	public static void main(String[] args) {
		  ChromeDriver driver = new ChromeDriver(); //Open browser
		  driver.manage().window().maximize();//Maximize it
		  driver.get("https://www.amazon.in/");
		  driver.findElement(By.linkText("Mobiles")).click();
		  WebElement mobile = driver.findElement(By.linkText("Mobiles & Accessories"));//Hovering cursor
		  Actions actions = new Actions(driver);
		  actions.moveToElement(mobile).build().perform();
		  WebElement mobile1 = driver.findElement(By.xpath("//a[contains(text(),'Apple')]"));
		  mobile1.click();
		  WebElement firstPhoneElement = driver.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']//a"));
		  firstPhoneElement.click();
		  Set<String> windowHandles = driver.getWindowHandles();	// Get all window handles (tabs)
		  for (String handle : windowHandles) {	  // Switch to the new tab
		      driver.switchTo().window(handle);
		  }
		  WebElement buyNowButton = driver.findElement(By.id("buy-now-button"));
		  buyNowButton.click();
		  String expectedTitle = "Amazon Sign In";//verifying website
		  String actualTitle = driver.getTitle();
		  System.out.println(expectedTitle);
		  System.out.println(actualTitle);
		  if(expectedTitle.equals(actualTitle)) {
			  System.out.println("Test Case Passed");
		  }
		  else {
			  System.out.println("Test Case Failed");
		  }
		  driver.quit(); //exit browser
	  }


}

