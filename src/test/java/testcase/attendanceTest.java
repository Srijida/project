package testcase;

import org.testng.annotations.Test;

import Pages.attendancePage;
import Pages.loginPage;
import utilities.ReadExcelData;

public class attendanceTest extends BaseTest{
	loginPage objLogin;
	attendancePage objattend;
	 public void performLogin(String username, String password) throws InterruptedException {
	        objLogin = new loginPage(driver);
	        objLogin.setUsername(username);
	        objLogin.setPassword(password);
	        objLogin.clickLogin();
	        System.out.println("login successful");
	    }

	    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
	    public void LoginTest(String username, String password) throws InterruptedException {
	        performLogin(username, password);
	    }
	    @Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata", dependsOnMethods = "LoginTest")
	    public void Attendance(String username,String password,String date) throws InterruptedException {
	    	performLogin(username, password);
	    	objattend=new attendancePage(driver);
	    	objattend.clicktimesheet();
	    	objattend.clickattendance();
	    	String[] parts = date.split("-");
	        String day = parts[0];
	        String month = parts[1];
	        String year = parts[2]; 
	        objattend.strdate(day, month, year);
	        objattend.clickget();
	        objattend.clicksearch();
	    }

}
