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

public class Laboratorio5_1 {
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
	
	@Test(dataProvider="Datos de Prueba Excel")
	public void login(String email, String password) {
		// Hacer clic en el hipervinculo Sign In
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicEnSignIn();
		
		// Ingresar las credenciales (correo y contraseña)
		PaginaLogin login = new PaginaLogin(driver);
		login.fillEmail(email);
		login.fillPassword(password);
		
		// Hacer clic en el botón Sign In
		login.clicEnBotonSignIn();
	}
	
	@AfterSuite 
	public void tearDown() {
		//driver.close();
	}
	
	@DataProvider(name="Datos de Prueba Excel")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionITViernes\\Datos\\datosLab4_E2.xlsx", "Hoja1");
	}
	
	@DataProvider(name="Datos de Prueba")
	public Object[][] obtenerDatos() {
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "correo99@gmail.com";
		datos[0][1] = "ery734yr7w";
		
		datos[1][0] = "correo98@gmail.com";
		datos[1][1] = "45w8tyewertu7843yw8";
		
		datos[2][0] = "correo97@gmail.com";
		datos[2][1] = "dwu565656__";
	
		return datos;
	}
}
