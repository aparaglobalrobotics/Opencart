package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	// This class contains only test methods.
	/*
	 * @Test public void verify_account_registration() {
	 * logger.info("******* Starting TC001_AccountRegistrationTest ******** ");
	 * 
	 * try { HomePage hp = new HomePage(driver); hp.clickMyAccount();
	 * logger.info("******* Clicked on MyAccount Link ******** ");
	 * 
	 * hp.clickRegister();
	 * logger.info("******* Clicked on Register Link ******** ");
	 * 
	 * AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
	 * logger.info("******* Providing customer Details ******** ");
	 * 
	 * regpage.setFirstName(randomString().toUpperCase());
	 * regpage.setLastName(randomString().toUpperCase());
	 * regpage.setEmail(randomString() + "@gmail.com");
	 * 
	 * String password = randomAlphaNumeric(); regpage.setPassword(password);
	 * 
	 * regpage.clickCheckBox(); regpage.clickContinue();
	 * 
	 * logger.info("******* Validating expected message ******** "); String
	 * confirmMsg = regpage.getConfirmationMsg(); Assert.assertEquals(confirmMsg,
	 * "Your Account Has Been Created!"); } catch (Exception e) {
	 * logger.error("Test Failed...."+e.getMessage());
	 * logger.debug("Debug Logs....."+e.getMessage()); Assert.fail(); }
	 * 
	 */
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration() {
		logger.info("******* Starting TC001_AccountRegistrationTest ******** ");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());

			// UNIQUE EMAIL: Combines random string with current time to prevent duplicates
			String email = randomString() + System.currentTimeMillis() + "@gmail.com";
			regpage.setEmail(email);
			
			regpage.setTelephone("23365656");

			String password = randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			regpage.setPrivacyPolicy();
			regpage.clickCheckBox();
			Thread.sleep(500);
			regpage.clickContinue();

			logger.info("******* Validating expected message ******** ");
			String confirmMsg = regpage.getConfirmationMsg();

			if (confirmMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed: ");
				logger.debug("Debug logs...");
				Assert.assertTrue(false);
			}

			// Final Fix: The assertion often fails due to leading/trailing spaces or case
			// sensitivity
			Assert.assertEquals(confirmMsg, "Your Account Has Been Created!", "Registration failed!");

		} catch (Exception e) {

			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistrationTest ***** ");
	}

}
