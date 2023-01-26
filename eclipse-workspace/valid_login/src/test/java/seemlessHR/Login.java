package seemlessHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().driverVersion("109.0.5414.74").setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();  
		driver.findElement(By.id("username")).sendKeys("tomsmith"); 
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
		
		
		
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = driver.findElement(By.cssSelector("#flash")).getText();
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(actualMessage, expectedMessage,"You logged into a secure area!");
		System.out.println(actualMessage);

		driver.close();
		
		
		/*String expectedMessage = "You logged into a secure area!";
		//String actualMessage = driver.findElement(By.xpath("//*[contains(text(),"logged")]).getText();"
		String actualMessage = driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();				
		SoftAssert sa= new SoftAssert();*/
		
		//sa.assertEquals(actualMessage, expectedMessage,"You logged into a secure area!");
		//System.out.println(actualMessage);
		
		
	}

}
