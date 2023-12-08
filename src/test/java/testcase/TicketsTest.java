package testcase;

import org.testng.annotations.Test;

import Pages.loginPage;
import Pages.ticketsPage;
import utilities.ReadExcelData;

public class TicketsTest extends BaseTest{
	loginPage objLogin;
	ticketsPage objticket;

	

	 @Test(dataProviderClass=ReadExcelData.class, dataProvider="testdata")
	    public void LoginTest(String username, String password) throws InterruptedException {
	        objLogin = new loginPage(driver);
	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        System.out.println("login successful");
	        objticket=new ticketsPage(driver);
	        objticket.clicktickets();
	        objticket.clickadd();
	        objticket.strcompname("CRROTHRM");
	        objticket.strsub("Ticket1");
	        objticket.stremp_ticket("John Smith");
	        objticket.strpriority("High");
	        objticket.clicksave();
	

}
}
