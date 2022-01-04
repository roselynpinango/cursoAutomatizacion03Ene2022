package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio4_E2 {
	String url = "http://automationpractice.com/";
	String driverPath = "..\\EducacionITViernes\\Drivers\\chromedriver.exe";
	WebDriver driver;
	String ruta = "..\\EducacionITViernes\\Datos\\datosLab4_E2.xlsx";
	String nombreHoja = "Hoja1";
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="Datos del excel")
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
	
	@DataProvider(name="Datos del excel")
	public Object[][] obtenerDatos() throws Exception {
		return DatosExcel.leerExcel(ruta, nombreHoja);
	}
}
