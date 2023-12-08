package testcase;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Pages.fileManagerPage;
import Pages.loginPage;
import utilities.ReadExcelData;

public class fileManagerTest extends BaseTest  { 
	loginPage objLogin;
	fileManagerPage objfile;

@Test(dataProviderClass = ReadExcelData.class, dataProvider = "testdata")
public void LoginTest(String username, String password) throws InterruptedException, AWTException {
    objLogin = new loginPage(driver);
    objfile = new fileManagerPage(driver);

    objLogin.setUsername(username);
    objLogin.setPassword(password);
    objLogin.clickLogin();
    System.out.println("login successful");
    objfile.clickfileManager();
    objfile.strdept(" MD Office");    
    objfile.clickfileUpload();
    objfile.clicksave();

}
}
