package testcase;

import org.testng.annotations.Test;

import Pages.loginPage;
import Pages.trainingPage;
import utilities.ReadExcelData;

public class trainingTest extends BaseTest {
	loginPage objLogin;
	trainingPage objtaining;

	    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
	    public void LoginTest(String username, String password) throws InterruptedException {
	        objLogin = new loginPage(driver);
	        objtaining = new trainingPage(driver);

	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        System.out.println("login successful");
	        objtaining.clicktraining();
	        objtaining.clicktrainingType();
	        objtaining.strtraintypename("Selenium automation");
	     
	        objtaining.clicksave();
	        Thread.sleep(3000);
	        
	        
	
}
}
