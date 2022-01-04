package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(css="#passwd")
	WebElement txtPassword;
	
	@FindBy(name="SubmitLogin")
	WebElement btnSignIn;
	
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void fillEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void fillPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clicEnBotonSignIn() {
		btnSignIn.click();
	}
	

	public void completarCredenciales(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnSignIn.click();
	}
}
