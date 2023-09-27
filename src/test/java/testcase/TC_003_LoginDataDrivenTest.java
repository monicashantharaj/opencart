package testcase;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageobjects.homepage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info(" Starting TC_003_LoginDataDrivenTest ");

		try {
			homepage hp = new homepage(driver);
			hp.lnkAccount();
			hp.lnkLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage = macc.isMyAccountPageExists();// this method is created MyAccountPage

			if (exp.equals("Valid")) {
				if (targetpage == true) {
					macc.Clickloggout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equals("Invalid")) {
				if (targetpage == true) {
					MyAccountPage myaccpage = new MyAccountPage(driver);
					myaccpage.Clickloggout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_003_LoginDataDrivenTest");

	}

}
