package Edit.EducacionITViernes;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Laboratorio1 {
	@Test
	public void acceder() {
		// Indicar dónde está nuestro driver
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITViernes\\Drivers\\chromedriver.exe");
		
		// Abrir la página
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		
		// Cerrar la página
		//driver.close();
	}
}
