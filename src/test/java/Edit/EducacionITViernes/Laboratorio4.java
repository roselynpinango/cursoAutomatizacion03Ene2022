package Edit.EducacionITViernes;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio4 {
	String driverPath = "..\\EducacionITViernes\\Drivers\\chromedriver.exe";
	String url = "http://automationpractice.com/index.php";
	WebDriver driver;
	File screen;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Buscar Palabra",priority=0)
	public void buscarPalabra() throws IOException {
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITViernes\\Evidencias\\01_pantalla_inicial.png"));
		
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscador.sendKeys("skirt");
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITViernes\\Evidencias\\02_palabra_a_buscar.png"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITViernes\\Evidencias\\03_resultado_obtenido.png"));
	}
	
	@Test(description="CP02 - Ir a Contact Us",priority=1)
	public void irAContactUs() {
		driver.findElement(By.linkText("Contact us")).click();
		
		String tituloEsperado = "Contact us - My Store";
		
		Assert.assertEquals(tituloEsperado, driver.getTitle());
	}
	
	@AfterSuite
	public void tearDown() {
		System.out.println("Fin Suite de Pruebas");
		driver.close();
	}
}
