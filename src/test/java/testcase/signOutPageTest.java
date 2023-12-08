package testcase;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Pages.loginPage;
import Pages.signOutPage;
import utilities.ReadExcelData;

public class signOutPageTest extends BaseTest {
	loginPage objLogin;
	signOutPage objempexist;
	

	 @Test(dataProviderClass=ReadExcelData.class, dataProvider="testdata")
	    public void LoginTest(String username, String password) throws InterruptedException, AWTException {
	        objLogin = new loginPage(driver);
	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        objempexist = new signOutPage(driver);
	        objempexist.clickempi_img();
	        Thread.sleep(3000);
	        objempexist.clicKsign_out();
	        

}
}
