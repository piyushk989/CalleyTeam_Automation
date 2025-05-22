package pompages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.calley.automation.base.BaseClass;

public class RegistrationPage {
	@FindBy(id = "txtName")
	static WebElement firstName;
	@FindBy(id = "txtEmail")
	static WebElement email;
	@FindBy(id = "txt_mobile")
	static WebElement phone;
	@FindBy(id = "txtPassword")
	static WebElement password;
	@FindBy(className = "confirm")
	static WebElement okay;
	@FindBy(xpath = "//*[@id=\"btnSignUp\"]")
	static WebElement verify;

	@FindBy(xpath = "//*[@id=\"btnSignUp\"]")
	static WebElement registerButton;

	public static void clickTeamsTrial() {
		BaseClass.driver.findElement(By.className("mbr-section-btn")).click();
		BaseClass.driver.findElement(By.xpath("//*[@id=\"btnteamsplanactive\"]")).click();

	}

	public static boolean isRegistrationSuccessful() {
		try {
			return BaseClass.driver.findElement(By.linkText("support@getcalley.com")).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static void registerUser(String fName, String email, String phone, String pwd) throws InterruptedException {

		RegistrationPage.firstName.sendKeys(fName);
		RegistrationPage.email.sendKeys(email);
		Thread.sleep(3000);
		RegistrationPage.password.sendKeys(pwd);

		RegistrationPage.phone.sendKeys(phone);
		Thread.sleep(25000);
		RegistrationPage.registerButton.click();

		// RegistrationPage.terms.click();
		// Thread.sleep(3000);

		RegistrationPage.okay.click();
		Thread.sleep(25000);
		RegistrationPage.verify.click();

	}
}