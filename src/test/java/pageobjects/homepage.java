package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homepage extends basepage 
{
	public homepage(WebDriver driver)
	{
		super(driver);
	}
	
	//Elemets
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkAccount;
	
	@FindBy(linkText = "Register")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Login']")
	WebElement lnkLogin;
	
	
	//Action methods
	public void lnkAccount()
	{
		lnkAccount.click();
	}
	
	public void lnkRegister()
	{
		lnkRegister.click();
	}
	
	public void lnkLogin()
	{
		lnkLogin.click();
	}
	
}
