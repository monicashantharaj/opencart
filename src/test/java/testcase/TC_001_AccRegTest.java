package testcase;

import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.AccountRegistrationPage;
import pageobjects.homepage;

public class TC_001_AccRegTest extends BaseClass{
	
	@Test
	public void test_account_Registration()
	{
		rb=ResourceBundle.getBundle("config");
		logger.info("Starting test");
		try
		{
	homepage hp = new homepage(driver);
	hp.lnkAccount();
	logger.info("Account login");
	hp.lnkRegister();
	AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
	regpage.setFirstName(rb.getString("firname"));	
	regpage.setLastName(rb.getString("Lasname"));	
	regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
	regpage.setPassword(rb.getString("paswrd"));
	//regpage.clickchkbox();
	//regpage.Continue();
	
	String confmsg=regpage.getmsgConfirmation();
	
	Assert.assertNotEquals(confmsg, "Your Account Has Been Created!");
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	}
	

}
