package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio5 {
	String url = "http://automationpractice.com/index.php";
	String driverPath = "..\\EducacionITViernes\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void login() {
		// Hacer clic en el hipervinculo Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnSignIn();
		
		// Ingresar las credenciales (correo y contraseña)
		PaginaLogin login = new PaginaLogin(driver);
		login.fillEmail("correo@gmail.com");
		login.fillPassword("1q2w3e4r5t6y");
		
		// Hacer clic en el botón Sign In
		login.clicEnBotonSignIn();
		
		//login.completarCredenciales("correo@gmail.com", "1q2w3e4r5t6y");
	}
	
	@Test
	public void buscar() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.ingresarPalabraABuscar("dress");
		inicio.hacerBusqueda();
	}
	
	@Test
	public void irContactus() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnContactUs();
	}
	
	@AfterSuite 
	public void tearDown() {
		//driver.close();
	}
}
