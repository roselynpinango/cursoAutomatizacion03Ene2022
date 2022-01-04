package Edit.EducacionITViernes;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio2 {
	String chromePath = "..\\EducacionITViernes\\Drivers\\chromedriver.exe";
	String geckoPath = "..\\EducacionITViernes\\Drivers\\geckodriver.exe";
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	
	@Test
	public void buscarPalabraChrome() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Hacer una búsqueda
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	@Test
	public void buscarPalabraFirefox() {
		System.setProperty("webdriver.gecko.driver", geckoPath);
		
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Hacer una búsqueda
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	@Test
	public void irAContactUs() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Ir a Contact Us
		driver.findElement(By.linkText("Contact us")).click();
	}
	
	@Test
	public void buscarPalabraChromeIncognito() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// Hacer una búsqueda
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
