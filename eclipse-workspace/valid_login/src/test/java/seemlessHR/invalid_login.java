package seemlessHR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class invalid_login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "//Users//samuelabatan//Downloads//chromedriver");
		
		WebDriver driver = new ChromeDriver();
	
		
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();  
		driver.findElement(By.id("username")).sendKeys("thomas"); 
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
		
		String expectedMessage = "Your username is invalid!";
		String actualMessage = driver.findElement(By.cssSelector("#flash")).getText();		
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualMessage, expectedMessage);
		
		System.out.println(actualMessage);
		
		driver.close();

	}

}
