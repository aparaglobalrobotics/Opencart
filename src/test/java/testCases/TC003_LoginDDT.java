package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriven") // getting data provider from different
																				// class
	public void verify_loginDDT(String email, String password, String exp) throws InterruptedException {
		
		logger.info("******Starting TC003_LoginDDT *******");
		
		try
		{
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// LoginPage
		LoginPage lp = new LoginPage(driver);
		// getting variables from config.properties files
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();

		// MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();

		/*
		 * Data is valid - login success - test pass - logout login failed - test fail
		 *
		 * Data is invalid - login success - test fail - logout Data is invalid -- login
		 * failed - test pass
		 */

		if (exp.equalsIgnoreCase("Valid")) {
			if (targetPage == true) {
				Assert.assertTrue(true);
				macc.clickLogout();
			} else {
				Assert.assertTrue(false);
			}
		}
		if (exp.equalsIgnoreCase("Invalid")) {
			if (targetPage == true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("******* Fininshed TC003_LoginDDT ********");
	}

}
