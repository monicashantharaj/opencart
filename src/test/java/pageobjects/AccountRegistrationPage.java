package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends basepage
{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	//Elements
	@FindBy(name = "firstname")
	WebElement FirstName;
	
	@FindBy(name = "lastname")
	WebElement LastNmame;
	
	@FindBy(name = "email")
	WebElement Email;

	@FindBy(name = "password")
	WebElement PassWord;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement Agree;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement Continue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	//Action Items
	public void setFirstName(String Fname)
	{
		FirstName.sendKeys(Fname);
	}
	
	public void setLastName(String lname) {
		LastNmame.sendKeys(lname);

	}

	public void setEmail(String email) {
		Email.sendKeys(email);

	}

	public void setPassword(String pwd) {
		PassWord.sendKeys(pwd);

	}
	
	public void clickchkbox() 
	{
		Agree.click();

	}

	public void Continue() {
		Continue.click();
	}
	
	public String getmsgConfirmation()
	{
		try {
			return (msgConfirmation.getText());
		}catch (Exception e){
			return (e.getMessage());			
		}	
	}	
}
