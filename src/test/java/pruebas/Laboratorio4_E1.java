package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio4_E1 {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EducacionITViernes\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos de la matriz")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.completarCredenciales(email, password);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider(name="Datos de la matriz")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[2][2];
		
		datos[0][0] = "usuario99@mailinator.com";
		datos[0][1] = "6y4r4r3ee";
		
		datos[1][0] = "usuario98@mailinator.com";
		datos[1][1] = "7ut65ryet34";
		
		return datos;
	}
}
