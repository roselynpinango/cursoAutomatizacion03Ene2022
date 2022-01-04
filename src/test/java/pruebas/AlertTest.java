package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AlertTest {
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verAlerta1() {
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void verAlerta6() {
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		driver.switchTo().alert().accept();
		System.out.println("Prueba");
	}
	
	@Test
	public void verAlerta2() {
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		myWait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void verAlerta3() {
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void verAlerta3Cancelar() {
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void verAlerta4() {
		driver.findElement(By.cssSelector("#promtButton")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Rose");
		alert.accept();
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
