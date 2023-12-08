package testcase;

import org.testng.annotations.Test;

import Pages.loginPage;
import Pages.staff;
import utilities.ReadExcelData;

public class staffTest extends BaseTest {
	
	  loginPage objLogin;
	  staff objstaff;

	    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
	    public void LoginTest(String username, String password) throws InterruptedException {
	        objLogin = new loginPage(driver);
	        objstaff = new staff(driver);

	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        System.out.println("login successful");
	        objstaff.clickstaff();
	        objstaff.clickrolprivi();
	        objstaff.clickadd();
	        objstaff.strrolname("Test1");
	        objstaff.straccess("All Menu Access");
	        objstaff.clicksave();
	        objstaff.clicksearch("dev");
	        Thread.sleep(3000);
	      
	       
	    }
}
