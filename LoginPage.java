package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.calley.automation.base.BaseClass;

public class LoginPage {
	@FindBy(id = "txtEmailId")
	static WebElement email;
	@FindBy(id = "txtPassword")
	static WebElement password;
	@FindBy(id = "btnLogIn")
	static WebElement loginButton;

	public static void login(String email, String password) {
		LoginPage.email.sendKeys(email);
		LoginPage.password.sendKeys(password);
		loginButton.click();
	}

	public static boolean isLoginSuccessful() {
		try {
			return BaseClass.driver.findElement(By.linkText("Dashboard")).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}