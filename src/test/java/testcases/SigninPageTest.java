package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SigninPageTest {

	static WebDriver driver;
	
	
	@BeforeTest
	public static void before() {
		
		String path = System.getProperty("user.dir");   // return project folder path
		
		//System.out.println(path);
		
		System.setProperty("webdriver.chrome.driver", path+"\\src\\test\\resources\\drivers\\chromeDriver\\chromedriver.exe");

		//driver = new ChromeDriver();
		//driver.get("https://opensource-demo.orangehrmlive.com/");
	
	}
	
	@AfterTest
	public void after() {
		//driver.manage().timeouts();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.close();
		driver.quit();
	}
	
	
	@Test()
	public static void testSigninUser(){
		
		driver = new ChromeDriver();
		
		System.out.println("Site will open ORANGE!");

		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		System.out.println("Site is open !");
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
		System.out.println("admin username Entered !");
		
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		System.out.println("password entered !");

		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		System.out.println("Button clicked !");

	}
	
	@Test()
	public static void testAmazon() throws InterruptedException{
		
		driver = new ChromeDriver();


		System.out.println("Site will open AMAZON!");
		driver.get("https://www.amazon.in");
		
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

		System.out.println("Enter in search box!");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Water bottel");
		

		System.out.println("Search button clicked!");
		
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		Thread.sleep(5000);
	}
	

}
