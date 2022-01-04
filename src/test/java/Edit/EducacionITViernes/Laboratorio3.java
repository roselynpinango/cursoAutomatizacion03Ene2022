package Edit.EducacionITViernes;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio3 {
	String driverPath = "..\\EducacionITViernes\\Drivers\\chromedriver.exe";
	String url = "http://automationpractice.com/index.php?controller=authentication";
	WebDriver driver;
	
	@Test
	public void registrarUsuario() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		// Ingresar el correo y hacer clic en el botón
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("prueba@mailinator.com");
		
		driver.findElement(By.name("SubmitCreate")).click();
		
		// Completar el formulario
		WebDriverWait espera = new WebDriverWait(driver, 10);
		espera.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#id_gender1")));
		
		driver.findElement(By.cssSelector("#id_gender1")).click();
		
		driver.findElement(By.xpath("//*[@name='customer_firstname']")).sendKeys("Ruben");
		
		driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Gomez");
		
		driver.findElement(By.id("passwd")).sendKeys("1q2w3e4r5t");
		
		Select selDias = new Select(driver.findElement(By.id("days")));
		selDias.selectByValue("18");
		
		driver.findElement(By.name("newsletter")).click();
		
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Micalle 4567 11B");
		
		driver.findElement(By.name("city")).sendKeys("Cordoba");
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Alabama");
		
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		
		// Comprobar que no se completó el registro y que seguimos en la misma página
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?controller=authentication";
		
		if (expectedUrl.contentEquals(currentUrl)) {
			System.out.println("URL - El usuario no se ha registrado");
		} else {
			System.out.println("URL - El usuario se registró");
		}
		
		String expectedTitle = "Login - My Store";
		String currentTitle = driver.getTitle();
		
		if (expectedTitle.contentEquals(currentTitle)) {
			System.out.println("TITLE - El usuario no se ha registrado");
		} else {
			System.out.println("TITLE - El usuario se registró");
		}
	}
}
