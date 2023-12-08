package testcase;

import org.testng.annotations.Test;

import Pages.eventsPage;
import Pages.loginPage;
import utilities.ReadExcelData;

public class eventsTest extends BaseTest {
	loginPage objLogin;
	eventsPage objevents;

	    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
	    public void LoginTest(String username, String password) throws InterruptedException {
	        objLogin = new loginPage(driver);
	        objevents = new eventsPage(driver);

	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        System.out.println("login successful");
	        objevents.clickevents_meeting();
	        objevents.clickevents();
	        objevents.strcomp("CRROTHRM");
	        objevents.stremp(" John Smith");
	        objevents.strevent_title("Dev&Testing");
	        Thread.sleep(3000);
	        objevents.strdate("10","Dec","2023");
	        Thread.sleep(3000);    
	        objevents.setEventTime("16","30");
//	        objevents.strhour("16");
//	        objevents.strmin("30");
	        objevents.clicksave();
	        Thread.sleep(4000);

}
}
